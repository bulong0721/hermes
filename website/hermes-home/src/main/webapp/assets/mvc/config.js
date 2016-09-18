/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function controllerLoader(oclazyload, dir, ctrl) {
    return oclazyload.load([
        {
            serie: true,
            files: ['assets/plugins/formly/api-check.min.js']
        },
        {
            serie: true,
            name: 'formly',
            files: ['assets/plugins/formly/formly.min.js']
        },
        {
            serie: true,
            name: 'formlyBootstrap',
            files: ['assets/plugins/formly/angular-formly-templates-bootstrap.js']
        },
        {
            serie: true,
            name: 'ngTable',
            files: ['assets/plugins/ng-table/ng-table.js', 'assets/plugins/ng-table/ng-table.css']
        },
        {
            serie: true,
            name: 'treeGrid',
            files: ['assets/plugins/ui-tree/angular-tree-grid.css', 'assets/plugins/ui-tree/angular-tree-grid.js']
        },
        {
            name: dir,//属于哪个模块
            files: ['assets/mvc/' + dir + '/controller/' + ctrl]
        }
    ])
}

function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    $urlRouterProvider.otherwise("/sys/user");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider
        .state('pkp', {
            abstract: true,
            url: "/pkp",
            template: "<div ui-view></div>",
            data: {
                pageTitle: '接送货管理'
            }
        })
        .state('pkp.order', {
            url: "/order",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'orderMgrCtrl',
            data: {
                subTitle: '订单管理',
                datatable: 'assets/mvc/pkp/view/order_datatable.html',
                editor: 'assets/mvc/pkp/view/order_editor.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'pkp', 'orderCtrl.js')
                }
            }
        })
        .state('pkp.sign', {
            url: "/sign",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'orderMgrCtrl',
            data: {
                subTitle: '派送签收',
                datatable: 'assets/mvc/pkp/view/order_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'pkp', 'orderCtrl.js')
                }
            }
        })
        .state('tfr', {
            abstract: true,
            url: "/tfr",
            template: "<div ui-view></div>",
            data: {
                pageTitle: '中转管理'
            }
        })
        .state('tfr.load', {
            url: "/load",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'orderMgrCtrl',
            data: {
                subTitle: '装车配载',
                datatable: 'assets/mvc/pkp/view/load_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'pkp', 'orderCtrl.js')
                }
            }
        })
        .state('tfr.depart', {
            url: "/depart",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'orderMgrCtrl',
            data: {
                subTitle: '发车管理',
                datatable: 'assets/mvc/pkp/view/load_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'pkp', 'orderCtrl.js')
                }
            }
        })
        .state('tfr.arrive', {
            url: "/arrive",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'orderMgrCtrl',
            data: {
                subTitle: '到达入库',
                datatable: 'assets/mvc/pkp/view/arrive_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'pkp', 'orderCtrl.js')
                }
            }
        })
        .state('tfr.outsource', {
            url: "/outsource",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'orderMgrCtrl',
            data: {
                subTitle: '中转外包',
                datatable: 'assets/mvc/pkp/view/outsource_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'pkp', 'orderCtrl.js')
                }
            }
        })
        .state('stl', {
            abstract: true,
            url: "/stl",
            template: "<div ui-view></div>",
            data: {
                pageTitle: '结算管理'
            }
        })
        .state('bse', {
            abstract: true,
            url: "/bse",
            template: "<div ui-view></div>",
            data: {
                pageTitle: '营运管理'
            }
        })
        .state('bse.partner', {
            url: "/partner",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'partnerMgrCtrl',
            data: {
                subTitle: '客户管理',
                datatable: 'assets/mvc/bse/view/partner_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'bse', 'partnerCtrl.js')
                }
            }
        })
        .state('bse.vehicle', {
            url: "/vehicle",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'vehicleMgrCtrl',
            data: {
                subTitle: '车辆管理',
                datatable: 'assets/mvc/bse/view/vehicle_datatable.html',
                editor: 'assets/mvc/bse/view/vehicle_editor.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'bse', 'vehicleCtrl.js')
                }
            }
        })
        .state('bse.track', {
            url: "/track",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'vehicleMgrCtrl',
            data: {
                subTitle: '跟踪管理',
                datatable: 'assets/mvc/bse/view/track_datatable.html',
                editor: 'assets/mvc/bse/view/receipt_editor.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'bse', 'vehicleCtrl.js')
                }
            }
        })
        .state('bse.receipt', {
            url: "/receipt",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'vehicleMgrCtrl',
            data: {
                subTitle: '回单管理',
                datatable: 'assets/mvc/bse/view/receipt_datatable.html',
                editor: 'assets/mvc/bse/view/receipt_editor.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'bse', 'vehicleCtrl.js')
                }
            }
        })
        .state('sys', {
            abstract: true,
            url: "/sys",
            template: "<div ui-view></div>",
            data: {
                pageTitle: '系统管理'
            }
        })
        .state('sys.client', {
            url: "/client",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'userMgrCtrl',
            data: {
                subTitle: '编辑资料',
                datatable: 'assets/mvc/sys/view/client_editor.html',
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'sys', 'userCtrl.js')
                }
            }
        })
        .state('sys.org', {
            url: "/org",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'userMgrCtrl',
            data: {
                subTitle: '分站管理',
                datatable: 'assets/mvc/sys/view/org_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'sys', 'userCtrl.js')
                }
            }
        })
        .state('sys.user', {
            url: "/user",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'userMgrCtrl',
            data: {
                subTitle: '用户管理',
                datatable: 'assets/mvc/sys/view/user_datatable.html',
                editor: 'assets/mvc/sys/view/user_editor.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'sys', 'userCtrl.js')
                }
            }
        })
        .state('sys.role', {
            url: "/role",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'roleMgrCtrl',
            data: {
                subTitle: '角色管理',
                datatable: 'assets/mvc/sys/view/role_datatable.html'
            },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return controllerLoader($ocLazyLoad, 'sys', 'roleCtrl.js')
                }
            }
        });
}
angular
    .module('inspinia')
    .config(config)
    .run(function ($rootScope, $state) {
        $rootScope.$state = $state;
    });
