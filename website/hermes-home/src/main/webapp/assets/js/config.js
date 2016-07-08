/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */

function managerLoader($ocLazyLoad) {
    return $ocLazyLoad.load([
        {
            serie: true,
            files: ['assets/js/plugins/formly/api-check.min.js']
        },
        {
            serie: true,
            name: 'formly',
            files: ['assets/js/plugins/formly/formly.min.js']
        },
        {
            serie: true,
            name: 'formlyBootstrap',
            files: ['assets/js/plugins/formly/angular-formly-templates-bootstrap.js']
        },
        {
            serie: true,
            name: 'ngTable',
            files: ['assets/js/plugins/ng-table/ng-table.js', 'assets/js/plugins/ng-table/ng-table.css']
        },
    ]);
}

//动态加载controller
function controllerLoader(oclazyload, module, ctrl) {
    return oclazyload.load([
        {
            name: module,
            files: ['assets/mvc/' + module + '/controller/' + ctrl]
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
            templateUrl: "assets/mvc/desktop/view/content.html",
            data: {
                pageTitle: '接送货管理'
            },
            resolve: {
                loadPlugin: managerLoader
            }
        })
        .state('pkp.order', {
            url: "/order",
            templateUrl: "assets/mvc/desktop/view/manager.html",
            controller: 'orderMgrCtrl',
            data: {
                subTitle: '订单管理',
                datatable: 'assets/mvc/bse/view/order_datatable.html'
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
            templateUrl: "assets/mvc/desktop/view/content.html",
            data: {
                pageTitle: '中转管理'
            },
            resolve: {
                loadPlugin: managerLoader
            }
        })
        .state('stl', {
            abstract: true,
            url: "/stl",
            templateUrl: "assets/mvc/desktop/view/content.html",
            data: {
                pageTitle: '结算管理'
            },
            resolve: {
                loadPlugin: managerLoader
            }
        })
        .state('bse', {
            abstract: true,
            url: "/bse",
            templateUrl: "assets/mvc/desktop/view/content.html",
            data: {
                pageTitle: '营运管理'
            },
            resolve: {
                loadPlugin: managerLoader
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
        .state('sys', {
            abstract: true,
            url: "/sys",
            templateUrl: "assets/mvc/desktop/view/content.html",
            data: {
                pageTitle: '系统管理'
            },
            resolve: {
                loadPlugin: managerLoader
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
