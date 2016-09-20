/**
 * Created by Martin on 2016/6/27.
 */
angular.module('sys', [])
    .controller('roleMgrCtrl', roleMgrCtrl);

/**
 * roleCtrl - controller
 */
roleMgrCtrl.$inject = ['$scope', '$ngTable', '$ngForms'];

function roleMgrCtrl($scope, $ngTable, $ngForms) {
    var option = {
        fields: [
            {
                'key': 'roleName',
                'type': 'input',
                'templateOptions': {'label': '角色名', required: true, 'placeholder': '角色名'}
            },
            {'key': 'description', 'type': 'input', 'templateOptions': {'label': '描述', 'placeholder': '描述'}}
        ],
        api: {
            read: 'roles/paging',
            update: 'roles/save'
        }
    };

    $ngTable.initNgMgrCtrl(option, $scope);
}