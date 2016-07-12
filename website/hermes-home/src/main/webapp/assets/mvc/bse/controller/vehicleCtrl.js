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
            {key: 'nature', type: 'c_select', templateOptions: {label: '性质', placeholder: '性质'}},
            {key: 'name', type: 'c_input', templateOptions: {label: '车名', placeholder: '车名'}},
            {key: 'tonnage', type: 'c_input', templateOptions: {label: '吨位', placeholder: '吨位'}},
            {key: 'engineNo', type: 'c_input', templateOptions: {label: '发动机号', placeholder: '发动机号'}},
            {key: 'plateNo', type: 'c_input', templateOptions: {label: '车牌号', placeholder: '车牌号'}},
            {key: 'licenseNo', type: 'c_input', templateOptions: {label: '车架号', placeholder: '车架号'}},
            {key: 'mileageCurrent', type: 'c_input', templateOptions: {label: '当前里程', placeholder: '当前里程'}},
            {key: 'contractNo', type: 'c_input', templateOptions: {label: '合同编号', placeholder: '合同编号'}},
            {key: 'limited', type: 'c_textarea', templateOptions: {label: '限行', placeholder: '限行'}},
            {key: 'comment', type: 'c_textarea', templateOptions: {label: '备注', placeholder: '备注'}}
        ],
        api: {
            read: '/admin/roles/paging',
            update: '/admin/roles/save'
        }
    };

    Constants.initMgrCtrl(mgrOpts, $scope);
}