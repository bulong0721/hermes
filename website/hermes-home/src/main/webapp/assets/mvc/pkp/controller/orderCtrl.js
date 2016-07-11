/**
 * Created by Martin on 2016/6/27.
 */
angular.module('pkp', [])
    .controller('orderMgrCtrl', orderMgrCtrl);

/**
 * orderMgrCtrl - controller
 */
orderMgrCtrl.$inject = ['$scope', 'Constants', 'Formly'];

function orderMgrCtrl($scope, Constants, Formly) {
    var mgrOpts = {
        fields: [
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-2', key: 'docStatus', type: 'input', templateOptions: {label: '运单状态'}},
                    {className: 'flex-3_5', key: 'documentNo', type: 'input', templateOptions: {label: '托运单号'}},
                    {className: 'flex-2_5', key: 'dateOrdered', type: 'input', templateOptions: {label: '受理日期'}},
                    {className: 'flex-2_5', key: 'datePromise', type: 'input', templateOptions: {label: '承诺日期'}},
                    {className: 'flex-2_5', key: 'departureOrgID', type: 'input', templateOptions: {label: '起始站'}},
                    {className: 'flex-2_5', key: 'arrivalOrgID', type: 'input', templateOptions: {label: '终点站'}}
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-2_5',key: 'consignorOrg', type: 'input', templateOptions: {label: '发货单位'}},
                    {className: 'flex-2',key: 'consignorBPartnerID', type: 'input', templateOptions: {label: '发货人'}},
                    {className: 'flex-2',key: 'consignorPhone', type: 'input', templateOptions: {label: '电话'}},
                    {className: 'flex-2',key: 'consignorMobile', type: 'input', templateOptions: {label: '手机号码'}},
                    {className: 'flex-3_5',key: 'consignorAddr', type: 'input', templateOptions: {label: '发货地址'}}
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-2_5',key: 'consigneeOrg', type: 'input', templateOptions: {label: '收货单位'}},
                    {className: 'flex-2',key: 'consigneeBPartnerID', type: 'input', templateOptions: {label: '收货人'}},
                    {className: 'flex-2',key: 'consigneePhone', type: 'input', templateOptions: {label: '电话'}},
                    {className: 'flex-2',key: 'consigneeMobile', type: 'input', templateOptions: {label: '手机号码'}},
                    {className: 'flex-3_5',key: 'consigneeAddr', type: 'input', templateOptions: {label: '收货地址'}}
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-2',key: 'transportType', type: 'input', templateOptions: {label: '运输类型'}},
                    {className: 'flex-2',key: 'pickup', type: 'input', templateOptions: {label: '上门接货'}},
                    {className: 'flex-2',key: 'delivery', type: 'input', templateOptions: {label: '送货上门'}},
                    {className: 'flex-2',key: 'receiptCopies', type: 'input', templateOptions: {label: '回单数量'}},
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-1_5',key: 'goodsName', type: 'input', templateOptions: {label: '品名'}},
                    {className: 'flex-1_5',key: 'packageType', type: 'input', templateOptions: {label: '包装'}},
                    {className: 'flex-1',key: 'amount', type: 'input', templateOptions: {label: '件数'}},
                    {className: 'flex-1',key: 'weight', type: 'input', templateOptions: {label: '重量/KG'}},
                    {className: 'flex-1',key: 'volume', type: 'input', templateOptions: {label: '体积/方'}},
                    {className: 'flex-1',key: 'price', type: 'input', templateOptions: {label: '单价'}},
                    {className: 'flex-1_5',key: 'chargeMethod', type: 'input', templateOptions: {label: '计费方式'}},
                    {className: 'flex-1',key: 'chargeFreight', type: 'input', templateOptions: {label: '基本运费'}},
                    {className: 'flex-1',key: 'chargePickup', type: 'input', templateOptions: {label: '接货费'}},
                    {className: 'flex-1',key: 'chargeDelivery', type: 'input', templateOptions: {label: '送货费'}},
                    {className: 'flex-1',key: 'value', type: 'input', templateOptions: {label: '货物价值'}},
                    {className: 'flex-1',key: 'chargeInsurance', type: 'input', templateOptions: {label: '保费'}},
                    {className: 'flex-1',key: 'costCommission', type: 'input', templateOptions: {label: '回扣'}},
                    {className: 'flex-1',key: 'costOther', type: 'input', templateOptions: {label: '其他费用'}}
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-1', key: 'totalCharge', type: 'input', templateOptions: {label: '费用合计'}}
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-2_5',key: 'paymentRule', type: 'input', templateOptions: {label: '付款方式'}},
                    {className: 'flex-2',key: 'paidConsignor', type: 'input', templateOptions: {label: '现付'}},
                    {className: 'flex-2',key: 'paidConsignee', type: 'input', templateOptions: {label: '到付'}},
                    {className: 'flex-2',key: 'paidReceipt', type: 'input', templateOptions: {label: '回单付'}},
                    {className: 'flex-2',key: 'paidMonthly', type: 'input', templateOptions: {label: '月结'}},
                    {className: 'flex-2',key: 'costPaidCommission', type: 'input', templateOptions: {label: '已结回扣'}},
                    {className: 'flex-2',key: 'costUnpaidCommission', type: 'input', templateOptions: {label: '未付回扣'}}
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-6',key: 'commentCharge', type: 'input', templateOptions: {label: '费用说明'}},
                    {className: 'flex-6',key: 'comment', type: 'input', templateOptions: {label: '托运备注'}}
                ]
            },
            {
                className: 'display-flex',
                fieldGroup: [
                    {className: 'flex-1',key: 'user1ID', type: 'input', templateOptions: {label: '业务员'}},
                    {className: 'flex-1',key: 'user2ID', type: 'input', templateOptions: {label: '开单员'}}
                ]
            }
        ],
        api: {
            read: '/admin/roles/paging',
            update: '/admin/roles/save'
        }
    };

    Constants.initMgrCtrl(mgrOpts, $scope);
}