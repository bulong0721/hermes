/**
 * Created by Martin on 2016/4/12.
 */
function constService($filter, $compile, $resource, $state, $q, NgTableParams) {
    var vm = this;

    //获取产品类型
    vm.productOpts = [];

    //从后台拿商户类型
    vm.merchantType = [];

    //从后台拿商户菜系
    vm.merchantCuisine = [];

    //切换门店
    vm.thisMerchantStore = {};
    vm.getSwitchMerchantStore = function () {
        var deferred = $q.defer();
        $resource('./merchantStore/getSwitch').get({}, function (resp) {
            if (resp.rows.length > 0) {
                $rootScope.storeInfo = vm.thisMerchantStore = resp.rows[0];
            }
            deferred.resolve(vm.thisMerchantStore);
        });
        return deferred.promise;
    }

    //从后台拿到省列表
    vm.provinces = [];

    //根据省从后台拿市列表
    vm.citys = [];
    vm.getCitysByProvince = function (provinceId) {
        if (provinceId) {
            $resource('./city/listByProvince').get({id: provinceId}, function (resp) {
                var length = resp.rows.length;
                if (length > 0) {
                    vm.citys.splice(0, vm.citys.length);
                    for (var j = 0; j < length; j++) {
                        vm.citys.push({name: resp.rows[j].name, value: resp.rows[j].id});
                    }
                }
            });
        }
    }

    //根据市从后台拿区县列表
    vm.districts = [];
    vm.getDistrictsByCity = function (cityId) {
        if (cityId) {
            $resource('./district/listByCity').get({id: cityId}, function (resp) {
                var length = resp.rows.length;
                if (length > 0) {
                    vm.districts.splice(0, vm.districts.length);
                    for (var j = 0; j < length; j++) {
                        vm.districts.push({name: resp.rows[j].name, value: resp.rows[j].id});
                    }
                }
            });
        }
    }

    //根据区县拿商圈
    vm.circles = [];

    //根据商圈拿商场
    vm.malls = [];
}

/**
 * cTables
 * */
function tablesService($resource, NgTableParams, $alert, toaster) {
    var vm = this, iDatatable = 0, iEditor = 1;

    vm.initNgMgrCtrl = function (mgrOpts, scope) {
        scope.toastError = 0, scope.toastOperationSucc = 1, scope.toastDeleteSucc = 2, scope.toastSearchSucc = 3, scope.toastUploadSucc = 4;
        //初始化搜索配置
        scope.where = {};

        //formly配置项
        scope.formData = {
            fields: mgrOpts.fields
        };

        //formly返回
        scope.goDataTable = function () {
            scope.activeTab = iDatatable;
        };

        //提交失败预留
        scope.saveFailed = function (response) {
            scope.toasterManage(scope.toastError, response);
        }

        //弹提示
        scope.toasterManage = function (type, response) {
            switch (type) {
                case scope.toastError://错误
                    toaster.error({body: "出错啦！" + response.statusMessage});
                    break;
                case scope.toastOperationSucc://操作成功
                    toaster.success({body: "操作成功"});
                    break;
                case scope.toastDeleteSucc://删除成功
                    toaster.success({body: "删除成功"});
                    break;
                case scope.toastSearchSucc://查询成功
                    toaster.success({body: "查询成功"});
                    break;
                case scope.toastUploadSucc://查询成功
                    toaster.success({body: "上传成功"});
                    break;
                default :
                    toaster.error({body: response.statusMessage});
            }

        }

        //formly提交
        scope.processSubmit = function () {
            var formly = scope.formData;
            if (formly.form.$valid) {
                formly.options.updateInitialValue();
                var xhr = $resource(mgrOpts.api.update);
                xhr.save({}, formly.model).$promise.then(scope.saveSuccess, scope.saveFailed);
            }
        };

        //初始化配置tabs的show or hide
        scope.activeTab = iDatatable;

        //点击编辑
        scope.goEditor = function (rowIndex) {
            if (rowIndex > -1) {
                var data = scope.tableOpts.data[rowIndex];
                scope.formData.model = angular.copy(data);
                scope.rowIndex = rowIndex;
            } else {
                scope.formData.model = {};
                scope.rowIndex = -1;
            }
            scope.activeTab = iEditor;
        };

        //点击删除
        scope.doDelete = function (rowIndex) {
            $alert.confirm('确定删除?', function () {
                //点击确定回调
                if (mgrOpts.api.delete && rowIndex > -1) {
                    var data = scope.tableOpts.data[rowIndex];
                    $resource(mgrOpts.api.delete).save({}, data, function deleteSuccess(response) {
                        if (0 != response.status) {
                            scope.toasterManage(scope.toastError, response);
                            return;
                        }
                        scope.tableOpts.data.splice(rowIndex, 1);//更新数据表
                        scope.toasterManage(scope.toastDeleteSucc);
                    }, scope.saveFailed);
                }
            }, function () {
                //点击取消回调
            });

        };

        //增删改查后处理tables数据
        scope.saveSuccess = function (response) {
            if (0 != response.status) {
                scope.toasterManage(scope.toastError, response);
                return;
            }
            var data = response.dataMap.updateResult;//scope.formData.model;//response.rows[0].updateResult;//

            if (scope.rowIndex < 0) {
                //scope.tableOpts.data.unshift(data);
                scope.tableOpts.data.splice(0, 0, data);
            } else {
                scope.tableOpts.data.splice(scope.rowIndex, 1, data);
            }
            scope.toasterManage(scope.toastOperationSucc);
            scope.goDataTable();
        }

        //tables获取数据
        scope.tableOpts = new NgTableParams({}, {
            counts: [], getData: function (params) {
                if (!scope.loadByInit) {
                    return [];
                }
                var xhr = $resource(mgrOpts.api.read);
                var args = angular.extend(params.url(), scope.where);

                return xhr.get(args).$promise.then(function (data) {
                    if (0 != data.status) {
                        scope.toasterManage(scope.toastError, data);
                        return;
                    }
                    scope.toasterManage(scope.toastSearchSucc);
                    params.total(data.recordsTotal);
                    return data.rows ? data.rows : [];
                });
            }
        });

        //搜索tables的数据
        scope.search = function () {
            scope.loadByInit = true;
            scope.tableOpts.page(1);
            scope.tableOpts.reload();
        };
    }
}

/*
 * cfromly
 * */
function fromsService(formlyConfig, $window, $q, toaster, $filter, $timeout, formlyValidationMessages) {
    formlyConfig.extras.errorExistsAndShouldBeVisibleExpression = 'fc.$touched || form.$submitted';
    formlyValidationMessages.addStringMessage('required', '此字段必填');

    //自定义formly Label&input一行显示
    formlyConfig.setWrapper({
        name: 'lineLabel',
        template: ['<label ng-hide="hide" for="{{::id}}" class="col-sm-2 control-label">', '{{to.label}} {{to.required ? "*" : ""}}', '</label>', '<div ng-hide="hide" class="col-sm-8">', '<formly-transclude></formly-transclude> <div class="validation" ng-if="showError" ng-messages="fc.$error">', '<div ng-message="required">此字段必填</div>', '<div ng-message="email">无效的邮件地址</div>', '<div ng-message="minlength">太短</div>', '<div ng-message="maxlength">太长</div>', '<div ng-message="{{::name}}" ng-repeat="(name, message) in ::options.validation.messages">', '{{message(fc.$viewValue, fc.$modelValue, this)}}', '</div></div></div>',].join(' ')
    });

    //input
    formlyConfig.setType({
        name: 'c_input',
        extends: 'input',
        wrapper: ['lineLabel', 'bootstrapHasError'],
        template: '<input type="{{options.templateOptions.type}}" class="form-control" id="{{id}}" formly-dynamic-name="id" formly-custom-validation="options.validators" placeholder="{{options.templateOptions.placeholder}}" aria-describedby="{{id}}_description" ng-required="options.templateOptions.required" ng-disabled="options.templateOptions.disabled" ng-model="model[options.key]">'
    });

    //select
    formlyConfig.setType({
        name: 'c_select', extends: 'select', wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //textarea
    formlyConfig.setType({
        name: 'c_textarea', extends: 'textarea', wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //checkbox
    formlyConfig.setType({
        name: 'c_checkbox', extends: 'checkbox', wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //radio
    formlyConfig.setType({
        name: 'c_radio', extends: 'radio', wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //images
    formlyConfig.setType({
        name: 'c_images',
        template: ['<label ng-hide="hide" for="{{::id}}" class="col-sm-2 control-label">', '{{to.label}}', '</label>', '<div ng-hide="hide" class="col-sm-8">', '<img ng-if="!Multi"  ng-src="{{model[options.key]}}" src="http://cdn.myee7.com/FuMJj5jpAK8_wd2c0KvdwEmCaATt?imageView2/1/w/150/h/95" />', '</div>'].join(' ')
    });

    //datepicker
    formlyConfig.setType({
        name: 'c_datepicker',
        template: ['<div class="col-sm-8"><p class="input-group">', '<input  type="text" id="{{::id}}" name="{{::id}}" ng-model="model[options.key]" class="form-control" ng-click="datepicker.open($event)" uib-datepicker-popup="{{to.datepickerOptions.format}}" is-open="datepicker.opened" datepicker-options="to.datepickerOptions" />', '<span class="input-group-btn">', '<button type="button" class="btn btn-default" ng-click="datepicker.open($event)" ng-disabled="to.disabled"><i class="fa fa-calendar"></i></button>', '</span></p></div>'].join(' '),
        wrapper: ['bootstrapLabel', 'bootstrapHasError'],
        defaultOptions: {
            ngModelAttrs: {}, className: 'c_datepicker', templateOptions: {
                datepickerOptions: {
                    format: 'yyyy.MM.dd', initDate: new Date()
                }
            }
        },
        controller: ['$scope', function ($scope) {
            $scope.datepicker = {};

            $scope.datepicker.opened = false;

            $scope.datepicker.open = function ($event) {
                $scope.datepicker.opened = !$scope.datepicker.opened;
            };
        }]
    });
}

/*
 * $alert
 * */
function alertService($uibModal) {
    return {
        confirm: function (titile, ok, cancel) {
            $uibModal.open({
                animation: false,
                template: ['<div class="modal-header">', '<h4 class="modal-title">{{title}}</h4>', '</div>', '<div class="modal-footer">', '<button class="btn-xs btn-primary" type="button" ng-click="ok()">确定</button>', '<button class="btn-xs btn-warning" type="button" ng-click="cancel()">取消</button>', '</div>'].join(''),
                controller: function ($scope, $uibModalInstance) {
                    $scope.ok = function () {
                        $uibModalInstance.close();
                        ok();
                    }

                    $scope.cancel = function () {
                        $uibModalInstance.dismiss('cancel');
                        cancel();
                    }
                },
                size: 'sm'
            });
        }
    }
}

/*
 * $upload
 * */
function uploadService($qupload, $resource) {
    var token = $resource('./superman/picture/tokenAndKey').get();
    return {
        qnUpload: function (file, progress) {
            //七牛上传
            var files = $qupload.upload({file: file, token: token.dataMap.uptoken})
            files.then(function (res) {

            }, function (res) {

            }, function (evt) {
                progress(Math.floor(100 * evt.loaded / evt.totalSize))
            });
            return files
        }, myeeUpload: function (file, attr, progress) {
            //木爷服务器上传
            //qiniuPath:qn?qn:
            //attr.param.qiniuPath = 'key'
            var files = $resource(attr.url).save(attr.param, file).$promise;
            files.then(function (res) {
                if (0 != res.status) {
                    $scope.toasterManage($scope.toastError, res);
                    return false;
                } else {
                    return res;
                }
            });
            progress(0)
            return files;
        }
    }
}

angular
    .module('inspinia')
    .service('$constant', constService)
    .service('$ngTable', tablesService)
    .service('$ngForms', fromsService)
    .factory('$upload', uploadService)
    .factory('$alert', alertService);