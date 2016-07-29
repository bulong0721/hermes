/**
 * Created by Martin on 2016/4/12.
 */
function constService($filter, $compile, $resource, $state, $q, NgTableParams) {
    var vm = this, iDatatable = 0, iEditor = 1;
    vm.initMgrCtrl = function (mgrOpts, scope) {
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

        //提交成功预留
        function saveFailed(response) {
        }

        //formly提交
        scope.processSubmit = function () {
            var formly = scope.formData;
            if (formly.form.$valid) {
                formly.options.updateInitialValue();
                var xhr = $resource(mgrOpts.api.update);
                xhr.save({}, formly.model).$promise.then(saveSuccess, saveFailed);
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
            cAlerts.confirm('确定删除?', function () {
                //点击确定回调
                if (mgrOpts.api.delete && rowIndex > -1) {
                    var data = scope.tableOpts.data[rowIndex];
                    $resource(mgrOpts.api.delete).save({}, data, function deleteSuccess(response) {
                        if (0 != response.status) {
                            return;
                        }
                        scope.tableOpts.data.splice(rowIndex, 1);//更新数据表
                    }, saveFailed);
                }
            }, function () {
                //点击取消回调
            });

        };

        //增删改查后处理tables数据
        function saveSuccess(response) {
            if (0 != response.status) {
                return;
            }
            var data = response.dataMap.updateResult;//scope.formData.model;//response.rows[0].updateResult;//

            if (scope.rowIndex < 0) {
                //scope.tableOpts.data.unshift(data);
                scope.tableOpts.data.splice(0, 0, data);
            } else {
                scope.tableOpts.data.splice(scope.rowIndex, 1, data);
            }
            scope.goDataTable();
        }

        //tables获取数据
        scope.tableOpts = new NgTableParams({}, {
            counts: [],
            getData: function (params) {
                if (!scope.loadByInit) {
                    return [];
                }
                var xhr = $resource(mgrOpts.api.read);
                var args = angular.extend(params.url(), scope.where);

                return xhr.get(args).$promise.then(function (data) {
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
    };
}

/*
 * FormUtil
 * */
function formlyService(formlyConfig, $window) {
    //自定义formly Label&input一行显示
    formlyConfig.setWrapper({
        name: 'lineLabel',
        template: [
            '<label ng-hide="hide" for="{{::id}}" class="col-sm-2 control-label">',
            '{{to.label}} {{to.required ? "*" : ""}}',
            '</label>',
            '<div ng-hide="hide" class="col-sm-8">',
            '<formly-transclude></formly-transclude>',
            '</div>'
        ].join(' ')
    });

    /*以下 使用forEach*/
    //input
    formlyConfig.setType({
        name: 'c_input',
        extends: 'input',
        wrapper: ['lineLabel', 'bootstrapHasError'],
    });

    //select
    formlyConfig.setType({
        name: 'c_select',
        extends: 'select',
        wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //textarea
    formlyConfig.setType({
        name: 'c_textarea',
        extends: 'textarea',
        wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //checkbox
    formlyConfig.setType({
        name: 'c_checkbox',
        extends: 'checkbox',
        wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //radio
    formlyConfig.setType({
        name: 'c_radio',
        extends: 'radio',
        wrapper: ['lineLabel', 'bootstrapHasError']
    });

    //file
    formlyConfig.setType({
        name: 'upload',
        extends: 'input',
        wrapper: ['bootstrapLabel', 'bootstrapHasError'],
        defaultOptions: {
            templateOptions: {
                type: 'file',
                required: true
            }
        },
        link: function (scope, el, attrs) {
            el.on("change", function (changeEvent) {
                var file = changeEvent.target.files[0];
                if (file) {
                    var fd = new FormData();
                    fd.append('file', file);
                    scope.$emit('fileToUpload', fd);
                    var fileProp = {};
                    for (var properties in file) {
                        if (!angular.isFunction(file[properties])) {
                            fileProp[properties] = file[properties];
                        }
                    }
                    scope.fc.$setViewValue(fileProp);
                } else {
                    scope.fc.$setViewValue(undefined);
                }
            });
            el.on("focusout", function (focusoutEvent) {
                if ($window.document.activeElement.id === scope.id) {
                    scope.$apply(function (scope) {
                        scope.fc.$setUntouched();
                    });
                } else {
                    scope.fc.$validate();
                }
            });
        }
    });

    //datepicker
    formlyConfig.setType({
        name: 'datepicker',
        template: [
            '<p class="input-group">',
            '<input  type="text" id="{{::id}}" name="{{::id}}" ng-model="model[options.key]" class="form-control" ng-click="datepicker.open($event)" uib-datepicker-popup="{{to.datepickerOptions.format}}" is-open="datepicker.opened" datepicker-options="to.datepickerOptions" />',
            '<span class="input-group-btn">',
            '<button type="button" class="btn btn-default" ng-click="datepicker.open($event)" ng-disabled="to.disabled"><i class="fa fa-calendar"></i></button>',
            '</span></p>'
        ].join(' '),
        wrapper: ['bootstrapLabel', 'bootstrapHasError'],
        defaultOptions: {
            ngModelAttrs: {},
            templateOptions: {
                datepickerOptions: {
                    format: 'yyyy.MM.dd',
                    initDate: new Date()
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

angular
    .module('inspinia')
    .service('Constants', constService)
    .service('Formly', formlyService);