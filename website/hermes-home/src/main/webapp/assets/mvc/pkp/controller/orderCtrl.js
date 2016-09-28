/**
 * Created by Martin on 2016/6/27.
 */
angular.module('pkp', [])
    .controller('orderMgrCtrl', orderMgrCtrl);

/**
 * orderMgrCtrl - controller
 */
orderMgrCtrl.$inject = ['$scope', '$ngTable', '$ngForms'];

function orderMgrCtrl($scope, $ngTable, $ngForms) {
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
            },
            {
                fieldGroup: [
                    {className: 'col-sm-2',key: 'consignorOrg', type: 'input', templateOptions: {label: '发货单位'}},
                    {className: 'col-sm-2',key: 'consignorBPartnerID', type: 'input', templateOptions: {label: '发货人'}},
                    {className: 'col-sm-2',key: 'consignorPhone', type: 'input', templateOptions: {label: '电话'}},
                    {className: 'col-sm-2',key: 'consignorMobile', type: 'input', templateOptions: {label: '手机号码'}},
                    {className: 'col-sm-4',key: 'consignorAddr', type: 'input', templateOptions: {label: '发货地址'}}
                ]
            },
            {
                fieldGroup: [
                    {className: 'col-sm-2',key: 'consigneeOrg', type: 'input', templateOptions: {label: '收货单位'}},
                    {className: 'col-sm-2',key: 'consigneeBPartnerID', type: 'input', templateOptions: {label: '收货人'}},
                    {className: 'col-sm-2',key: 'consigneePhone', type: 'input', templateOptions: {label: '电话'}},
                    {className: 'col-sm-2',key: 'consigneeMobile', type: 'input', templateOptions: {label: '手机号码'}},
                    {className: 'col-sm-4',key: 'consigneeAddr', type: 'input', templateOptions: {label: '收货地址'}}
                ]
            },
            {
                fieldGroup: [
                    {className: 'col-sm-3',key: 'transportType', type: 'input', templateOptions: {label: '运输类型'}},
                    {className: 'col-sm-3',key: 'pickup', type: 'input', templateOptions: {label: '上门接货'}},
                    {className: 'col-sm-3',key: 'delivery', type: 'input', templateOptions: {label: '送货上门'}},
                    {className: 'col-sm-3',key: 'receiptCopies', type: 'input', templateOptions: {label: '回单数量'}},
                ]
            },
            {
                fieldGroup: [
                    {className: 'col-sm-12', key: 'totalCharge', type: 'input', templateOptions: {label: '费用合计'}}
                ]
            },
            {
                fieldGroup: [
                    // {className: 'flex-2_5',key: 'paymentRule', type: 'input', templateOptions: {label: '付款方式'}},
                    {className: 'col-sm-2',key: 'paidConsignor', type: 'input', templateOptions: {label: '现付'}},
                    {className: 'col-sm-2',key: 'paidConsignee', type: 'input', templateOptions: {label: '到付'}},
                    {className: 'col-sm-2',key: 'paidReceipt', type: 'input', templateOptions: {label: '回单付'}},
                    {className: 'col-sm-2',key: 'paidMonthly', type: 'input', templateOptions: {label: '月结'}},
                    {className: 'col-sm-2',key: 'costPaidCommission', type: 'input', templateOptions: {label: '已结回扣'}},
                    {className: 'col-sm-2',key: 'costUnpaidCommission', type: 'input', templateOptions: {label: '未付回扣'}}
                ]
            },
            {
                fieldGroup: [
                    {className: 'col-sm-6',key: 'commentCharge', type: 'input', templateOptions: {label: '费用说明'}},
                    {className: 'col-sm-6',key: 'comment', type: 'input', templateOptions: {label: '托运备注'}}
                ]
            },
            {
                fieldGroup: [
                    {className: 'col-sm-6',key: 'user1ID', type: 'input', templateOptions: {label: '业务员'}},
                    {className: 'col-sm-6',key: 'user2ID', type: 'input', templateOptions: {label: '开单员'}}
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