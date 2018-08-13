/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('restaApp', ['ui.router', 'ngResource', 'restaApp.controllers']);

angular.module('restaApp').config(function ($stateProvider) {
    $stateProvider.state('home', {
        url: '/home',
        templateUrl: 'partials/home.html',
        controller: 'restauranteDataController'
    }).state('orden', {
        url: '/orden/:idSalonero',
        templateUrl: 'partials/orden.html',
        controller: 'ordenController'
    }).state('consulta', {
        url: '/consulta',
        templateUrl: 'partials/consulta.html',
        controller: 'consultaController'
    }).state('historial', {
        url: '/historial/:idSalonero',
        templateUrl: 'partials/historial.html',
        controller: 'historialController'
    });
});

Array.prototype.remove = function () {
    var what, a = arguments, L = a.length, ax;
    while (L && this.length) {
        what = a[--L];
        while ((ax = this.indexOf(what)) !== -1) {
            this.splice(ax, 1);
        }
    }
    return this;
};