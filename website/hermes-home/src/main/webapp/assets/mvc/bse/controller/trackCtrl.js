/**
 * Created by Martin on 2016/6/27.
 */
angular.module('bse', [])
    .controller('trackCtrl', trackCtrl);

/**
 * trackCtrl - controller
 */
trackCtrl.$inject = ['$scope', '$ngTable', '$ngForms'];

function trackCtrl($scope, $ngTable, $ngForms) {
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
            read: 'roles/paging', update: 'roles/save'
        }
    };

    $ngTable.initNgMgrCtrl(mgrOpts, $scope);
}