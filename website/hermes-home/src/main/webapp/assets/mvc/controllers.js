/**
 * INSPINIA - Responsive Admin Theme
 *
 */

/**
 * MainCtrl - controller
 */
function MainCtrl() {

    this.shopName = '千途物流公司';
    this.userName = 'Martin.Xu';
    this.helloText = 'Welcome in SeedProject';
    this.descriptionText = 'It is an application skeleton for a typical AngularJS web app. You can use it to quickly bootstrap your angular webapp projects and dev environment for these projects.';
}

angular
    .module('inspinia')
    .controller('MainCtrl', MainCtrl);