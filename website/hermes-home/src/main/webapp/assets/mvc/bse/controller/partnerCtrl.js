/**
 * Created by Martin on 2016/6/27.
 */
angular.module('bse', [])
    .controller('partnerMgrCtrl', partnerMgrCtrl);

/**
 * partnerMgrCtrl - controller
 */
partnerMgrCtrl.$inject = ['$scope', 'Constants', 'Formly'];

function partnerMgrCtrl($scope, Constants, Formly) {
    var mgrOpts = {
        fields: [
            {
                'key': 'roleName',
                'type': 'c_input',
                'templateOptions': {'label': '角色名', required: true, 'placeholder': '角色名'}
            },
            {'key': 'description', 'type': 'c_input', 'templateOptions': {'label': '描述', 'placeholder': '描述'}}
        ],
        api: {
            read: '/admin/roles/paging',
            update: '/admin/roles/save'
        }
    };

    Constants.initMgrCtrl(mgrOpts, $scope);
}