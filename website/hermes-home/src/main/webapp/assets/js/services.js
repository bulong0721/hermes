/**
 * Created by Martin on 2016/4/12.
 */
function constService($filter, $compile, $resource, $state, $q, NgTableParams) {
    var vm = this;

    vm.sizeFormatter = function (value, opts, row) {
        if (!row.leaf || 0 == value) {
            return '-';
        }
        if (value > 1024 * 1024 * 1024) {
            return Math.ceil(value / (1024 * 1024 * 1024)) + 'G';
        }
        if (value > 1024 * 1024) {
            return Math.ceil(value / (1024 * 1024)) + 'M';
        }
        if (value > 1024) {
            return Math.ceil(value / 1024) + 'K';
        }
        return value + 'B';
    };

    vm.dateFormatter = function (value, opts, row) {
        if (value) {
            return $filter('date')(new Date(value), 'yyyy-MM-dd HH:mm:ss');
        }
        return '-';
    };

    vm.initMgrCtrl = function (mgrOpts, scope) {
        scope.where = {};
        scope.formData = {
            fields: mgrOpts.fields
        };
        scope.showDataTable = true;
        scope.showEditor = false;

        scope.goDataTable = function () {
            scope.showDataTable = true;
            scope.showEditor = false;
        };

        scope.goEditor = function (rowIndex) {
            if (rowIndex > -1) {
                var data = scope.tableOpts.data[rowIndex];
                scope.formData.model = angular.copy(data);
                scope.rowIndex = rowIndex;
            } else {
                scope.formData.model = {};
                scope.rowIndex = -1;
            }
            scope.showDataTable = false;
            scope.showEditor = true;
        };

        scope.doDelete = function (rowIndex) {
            if (mgrOpts.api.delete && rowIndex > -1) {
                var data = scope.tableOpts.data[rowIndex];
                $resource(mgrOpts.api.delete).save({}, data, saveSuccess, saveFailed);
            }
        };

        function saveSuccess(response) {
            if (0 != response.status) {
                return;
            }
            var data = scope.formData.model;
            if (scope.rowIndex < 0) {
                scope.tableOpts.data.splice(0, 0, data);
            } else {
                scope.tableOpts.data.splice(scope.rowIndex, 1, data);
            }
            scope.goDataTable();
        }

        function saveFailed(response) {
        }

        scope.processSubmit = function () {
            var formly = scope.formData;
            if (formly.form.$valid) {
                formly.options.updateInitialValue();
                var xhr = $resource(mgrOpts.api.update);
                xhr.save({}, formly.model).$promise.then(saveSuccess, saveFailed);
            }
        };

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
                    return data.rows;
                });
            }
        });

        scope.search = function () {
            scope.loadByInit = true;
            scope.tableOpts.reload();
        };
    };
}

/*
 * fromly
 * */
function fromlyService(formlyConfig, $window) {
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
    .service('Fromly', fromlyService);