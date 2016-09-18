/**
 * Created by Martin on 2016/6/27.
 */
angular.module('tfr', [])
    .controller('loadCtrl', loadCtrl);

/**
 * roleCtrl - controller
 */
loadCtrl.$inject = ['$scope', '$resource', '$ngTable', '$ngForms'];

function loadCtrl($scope, $resource, $ngTable, $ngForms) {
    var mgrData = {
        fields: [
            {'key': 'name', 'type': 'input', 'templateOptions': {'label': '昵称', required: true, 'placeholder': '昵称'}},
            {
                'key': 'login',
                'type': 'input',
                'templateOptions': {'label': '登录名', required: true, 'placeholder': '登录名'}
            },
            {'key': 'phoneNumber', 'type': 'input', 'templateOptions': {'label': '电话号码', 'placeholder': '电话号码'}},
            {
                'key': 'email',
                'type': 'input',
                'templateOptions': {type: 'email', 'label': '电子邮件', required: true, 'placeholder': '电子邮件'}
            },
            {'key': 'activeStatusFlag', 'type': 'checkbox', 'templateOptions': {'label': '状态', 'placeholder': '状态'}}
        ],
        api: {
            read: '/admin/users/paging',
            update: '/admin/users/save'
        }
    };

    $ngTable.initNgMgrCtrl(mgrData, $scope);
}