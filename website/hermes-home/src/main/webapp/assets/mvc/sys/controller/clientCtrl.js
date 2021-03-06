/**
 * Created by Martin on 2016/6/27.
 */
angular.module('sys', [])
    .controller('clientCtrl', clientCtrl);

/**
 * merchantCtrl - controller
 */
clientCtrl.$inject = ['$scope', '$ngTable', '$resource', '$constant', '$ngForms'];

function clientCtrl($scope, $ngTable, $resource, $constant, $ngForms) {
    var mgrData = {
        fields: [
            {
                key: 'name',
                type: 'c_input',
                templateOptions: {type: 'text', label: '商户名称', required: true, placeholder: '商户名称'}
            },
            {
                key: 'businessType',
                type: 'c_select',
                className: 'c_select',
                templateOptions: {
                    required: true,
                    label: '商户类型',
                    options: $constant.merchantType
                }
            },
            {
                key: 'cuisineType',
                type: 'c_select',
                className: 'c_select',
                templateOptions: {
                    required: false,
                    label: '商户菜系',
                    options: $constant.merchantCuisine
                },
                hideExpression: function ($viewValue, $modelValue, scope) {
                    if (scope.model.businessType != 'FOOD') {
                        return true;   //隐藏
                    } else {
                        return false;  //餐厅类型为餐饮时显示
                    }
                }
            },
            {
                id: 'imgFile',
                key: 'imgFile',
                type: 'upload',
                templateOptions: {
                    type: 'file', label: '商户图标', required: false, placeholder: '商户图标',
                    upAttr: {
                        name: 'img',//这个name是用来判断上传文件的类型，不判断为空('') || null
                        upType: 2,
                        url: './files/create',
                        param: {//这是url参数
                            type: 'file',
                            path: 'logo'
                        },
                        upMore: 1
                    }
                },
                controller: ['$scope', function ($scope) {
                    //资源回显
                    $scope.editFile = function (call) {
                        if ($scope.model.imgFile) {
                            call({url: baseUrl.pushUrl + $scope.model.imgFile})
                        }
                    };

                    //删除资源
                    $scope.upRemove = function (index) {
                        console.log(index);
                        $scope.model.logo = ""; //若是数组用这种方式删scope.thumbnail.splice(index,1);
                    };
                }]
            },
            {
                key: 'description',
                type: 'c_textarea',
                ngModelAttrs: {
                    style: {attribute: 'style'}
                },
                templateOptions: {label: '商户描述', placeholder: '商户描述', rows: 10, style: 'max-width:500px'}
            }
        ],
        api: {
            read: './merchant/paging',
            update: './merchant/save',
            delete: './merchant/delete',
            upload: './files/create'
        }
    };
    $ngTable.initNgMgrCtrl(mgrData, $scope);

    $scope.thisMerchantId = 1;

    var iEditor = 1;

    //formly提交
    $scope.processSubmit = function () {
        var formly = $scope.formData;
        if (formly.form.$valid) {
            //formly.options.updateInitialValue();
            var xhr = $resource(mgrData.api.update);
            xhr.save({}, formly.model).$promise.then($scope.saveSuccess, $scope.saveFailed);
        }
    };

    //点击编辑
    $scope.goEditor = function (rowIndex) {
        //angular.element('#imgFile')[0].value = '';//清空input[type=file]value[ 垃圾方式 建议不要使用]
        if (rowIndex > -1) {
            var data = $scope.tableOpts.data[rowIndex];
            $scope.formData.model = angular.copy(data);
            console.log(data)
            $scope.formData.model.imgFile = data.logo;
            $scope.rowIndex = rowIndex;
        } else {
            $scope.formData.model = {};
            $scope.rowIndex = -1;
        }

        $scope.activeTab = iEditor;
    };

    //上传控件监听器
    $scope.$on('fileToUpload', function (event, res) {
        console.log(res)
        //把上传结果赋值到formly.model对象对应字段
        var pic = res[0].dataMap.tree.downloadPath;
        $scope.toasterManage($scope.toastUploadSucc);
        $scope.formData.model.logo = pic;
    });
}
