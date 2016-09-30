/**
 * Created by Martin on 2016/6/27.
 */
angular.module('pkp', [])
    .controller('signCtrl', signCtrl);

/**
 * signCtrl - controller
 */
signCtrl.$inject = ['$scope', '$ngTable', '$ngForms'];

function signCtrl($scope, $ngTable, $ngForms) {
    var mgrOpts = {
        fields: [
            {
                fieldGroup: [
                    {className: 'col-sm-2', key: 'docStatus', type: 'input', templateOptions: {label: '运单状态'}},
                    {className: 'col-sm-2', key: 'documentNo', type: 'input', templateOptions: {label: '托运单号'}},
                    {className: 'col-sm-2', key: 'dateOrdered', type: 'input', templateOptions: {label: '受理日期'}},
                    {className: 'col-sm-2', key: 'datePromise', type: 'input', templateOptions: {label: '承诺日期'}},
                    {className: 'col-sm-2', key: 'departureOrgID', type: 'input', templateOptions: {label: '起始站'}},
                    {className: 'col-sm-2', key: 'arrivalOrgID', type: 'input', templateOptions: {label: '终点站'}}
                ]
            }
        ],
        api: {
            read: '/admin/roles/paging',
            update: '/admin/roles/save'
        }
    };

    $ngTable.initNgMgrCtrl(mgrOpts, $scope);
}