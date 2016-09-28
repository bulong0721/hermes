/**
 * Created by Martin on 2016/6/27.
 */
angular.module('bse', [])
    .controller('receiptCtrl', receiptCtrl);

/**
 * partnerMgrCtrl - controller
 */
receiptCtrl.$inject = ['$scope', '$ngTable', '$ngForms'];

function receiptCtrl($scope, $ngTable, $ngForms) {
    var mgrOpts = {
        fields: [{
            'key': 'roleName',
            'type': 'c_input',
            'templateOptions': {'label': '角色名', required: true, 'placeholder': '角色名'}
        }, {
            'key': 'description',
            'type': 'c_input',
            'templateOptions': {'label': '描述', 'placeholder': '描述'}
        }], api: {
            read: '/admin/roles/paging', update: '/admin/roles/save'
        }
    };

    $ngTable.initNgMgrCtrl(mgrOpts, $scope);
}