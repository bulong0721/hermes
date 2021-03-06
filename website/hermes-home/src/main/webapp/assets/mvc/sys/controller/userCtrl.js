/**
 * Created by Martin on 2016/6/27.
 */
angular.module('sys', [])
    .controller('userMgrCtrl', userMgrCtrl);

/**
 * userMgrCtrl - controller
 */
userMgrCtrl.$inject = ['$scope', '$ngTable', '$ngForms'];

function userMgrCtrl($scope, $ngTable, $ngForms) {
    var option = {
        fields: [
            {'key': 'name', 'type': 'c_input', 'templateOptions': {'label': '昵称', required: true, 'placeholder': '昵称'}},
            {
                'key': 'login',
                'type': 'c_input',
                'templateOptions': {'label': '登录名', required: true, 'placeholder': '登录名'}
            },
            {'key': 'phoneNumber', 'type': 'c_input', 'templateOptions': {'label': '电话号码', 'placeholder': '电话号码'}},
            {
                key: 'email',
                type: 'c_input',
                templateOptions: {type: 'email', label: '电子邮件', required: true, placeholder: '电子邮件'}
            },
            {key: 'activeStatusFlag', className: 'formly-min-checkbox', type: 'c_checkbox', templateOptions: {label: '状态', placeholder: '状态'}}
        ],
        api: {
            read: 'users/paging',
            update: 'users/save'
        }
    };

    $ngTable.initNgMgrCtrl(option, $scope);
}