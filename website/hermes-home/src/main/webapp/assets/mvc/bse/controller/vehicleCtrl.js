/**
 * Created by Martin on 2016/6/27.
 */
angular.module('bse', [])
    .controller('vehicleMgrCtrl', vehicleMgrCtrl);

/**
 * vehicleMgrCtrl - controller
 */
vehicleMgrCtrl.$inject = ['$scope', 'Constants', 'Formly'];

function vehicleMgrCtrl($scope, Constants, Formly) {
    var mgrOpts = {
        fields: [
            {key: 'nature', type: 'select', templateOptions: {label: '性质', placeholder: '性质'}},
            {key: 'name', type: 'input', templateOptions: {label: '车名', placeholder: '车名'}},
            {key: 'tonnage', type: 'input', templateOptions: {label: '吨位', placeholder: '吨位'}},
            {key: 'engineNo', type: 'input', templateOptions: {label: '发动机号', placeholder: '发动机号'}},
            {key: 'plateNo', type: 'input', templateOptions: {label: '车牌号', placeholder: '车牌号'}},
            {key: 'licenseNo', type: 'input', templateOptions: {label: '车架号', placeholder: '车架号'}},
            {key: 'mileageCurrent', type: 'input', templateOptions: {label: '当前里程', placeholder: '当前里程'}},
            {key: 'contractNo', type: 'input', templateOptions: {label: '合同编号', placeholder: '合同编号'}},
            {key: 'limited', type: 'textarea', templateOptions: {label: '限行', placeholder: '限行'}},
            {key: 'comment', type: 'textarea', templateOptions: {label: '备注', placeholder: '备注'}}
        ],
        api: {
            read: '/admin/roles/paging',
            update: '/admin/roles/save'
        }
    };

    Constants.initMgrCtrl(mgrOpts, $scope);
}