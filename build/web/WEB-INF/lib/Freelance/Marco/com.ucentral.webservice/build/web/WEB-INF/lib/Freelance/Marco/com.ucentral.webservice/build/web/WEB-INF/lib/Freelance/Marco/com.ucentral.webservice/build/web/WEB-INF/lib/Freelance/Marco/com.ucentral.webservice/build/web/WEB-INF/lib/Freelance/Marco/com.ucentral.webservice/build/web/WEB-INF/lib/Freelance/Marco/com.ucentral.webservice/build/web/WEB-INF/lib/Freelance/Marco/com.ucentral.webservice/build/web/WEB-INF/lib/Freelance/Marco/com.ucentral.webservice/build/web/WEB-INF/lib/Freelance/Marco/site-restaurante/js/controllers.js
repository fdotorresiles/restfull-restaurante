/**
 * Created by Sandeep on 01/06/14.
 */
angular.module('restaApp.controllers', [])
    .controller('restauranteDataController', function ($scope, $http) {

        http://localhost:8080/com.ucentral.webservice/restaurante/saloneros
        $http({
            method: 'GET',
            url: 'http://localhost:8080/com.ucentral.webservice/restaurante/saloneros'
        }).then(response => {
            $scope._saloneros = response.data;
        });

        $scope.seleccionarSalonero = (idSalonero) => {
            $scope._idSalonero = idSalonero;
        }
    })
    .controller('ordenController', function ($scope, $http, $stateParams) {

        $http({
            method: 'GET',
            url: 'http://localhost:8080/com.ucentral.webservice/restaurante/productos'
        }).then(response => {
            $scope._bebidas = response.data.filter(x => {
                return x.tipoProducto == "Bebida";
            });

            $scope._postres = response.data.filter(x => {
                return x.tipoProducto == "Postre";
            });

            $scope._platosFuertes = response.data.filter(x => {
                return x.tipoProducto == "Plato fuerte";
            });

            $scope._combos = response.data.filter(x => {
                return x.tipoProducto == "Combo";
            });

        });


        $scope.agregarOrden = (item) => {

            if (!$scope._detalleOrden) {
                $scope._detalleOrden = [];
                $scope._detalleOrden.push({
                    idProducto: item.idProducto,
                    descripcion: item.descripcion,
                    tipoProducto: item.tipoProducto,
                    precio: item.precio,
                    cantidad: 1
                });
            } else {
                var itemDetalle = $scope._detalleOrden.find(x => {
                    return x.idProducto == item.idProducto;
                });
                if (itemDetalle) {
                    $scope._detalleOrden.find(x => {
                        if (x.idProducto == item.idProducto) {
                            x.cantidad += 1;
                        }
                    });
                } else {
                    $scope._detalleOrden.push({
                        idProducto: item.idProducto,
                        descripcion: item.descripcion,
                        tipoProducto: item.tipoProducto,
                        precio: item.precio,
                        cantidad: 1
                    });
                }
            }

            calcularTotal($scope, $scope._detalleOrden);
        };

        $scope.disminuirOrden = (item) => {
            $scope._detalleOrden.find(x => {
                if (x.idProducto == item.idProducto) {
                    if (x.cantidad - 1 == 0) {
                        $scope._detalleOrden.remove(item);
                    } else {
                        x.cantidad -= 1;
                    }
                }
            });
            calcularTotal($scope, $scope._detalleOrden);
        };

        $scope.guardarOrden = () => {

            var _customerId = document.getElementById('customerId').value;

            if (!_customerId) {
                alert('Ingrese el nombre del cliente');
            }

            var data = { idSalonero: 1, cliente: "NA" };
            console.log(data)
            $http({
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data,
                url: 'http://localhost:8080/com.ucentral.webservice/restaurante/orden',
                
            }).then(response => {
                if (!response) {
                    alert('Problemas guardando la orden');
                }


            });

            // $scope._detalleOrden.forEach(element => {

            // });
            // console.log($stateParams.idSalonero);
            // console.log($scope._detalleOrden);
            // console.log(_customerId);

        }

    })
    .controller('consultaController', function ($scope, $http) {

        $http({
            method: 'GET',
            url: 'http://localhost:8080/com.ucentral.webservice/restaurante/saloneros'
        }).then(response => {
            $scope._saloneros = response.data;
        });

        $scope.seleccionarSalonero = (idSalonero) => {
            $scope._idSalonero = idSalonero;
        }
        console.log('Consulta saloneros');
    })
    .controller('historialController', function ($scope, $http, $stateParams) {
        $http({
            method: 'GET',
            url: `http://localhost:8080/com.ucentral.webservice/restaurante/orden/${$stateParams.idSalonero}`
        }).then(response => {
            $scope._ordenes = response.data;
        });


        $scope.mostrarOrden = (idOrden, cliente) => {

            $scope.clienteNombre = cliente;

            $http({
                method: 'GET',
                url: 'http://localhost:8080/com.ucentral.webservice/restaurante/productos'
            }).then(response => {
                var productos = response.data;
                $http({
                    method: 'GET',
                    url: `http://localhost:8080/com.ucentral.webservice/restaurante/detalleOrden/${idOrden}`
                }).then(response => {

                    var tempdetalle = response.data;

                    calcularTotal($scope, tempdetalle);


                    var detalle = tempdetalle.forEach(detalle => {
                        var producto = productos.find(producto => {
                            if (producto.idProducto == detalle.idProducto) {

                                return producto;
                            }
                        });

                        detalle.descripcion = producto.descripcion;

                    });

                    $scope._detalleOrden = tempdetalle;
                });
            });
        };
    });

function calcularTotal($scope, listaDetalle) {
    if (!listaDetalle) {
        $scope.totalPagar = 0;
    } else {
        var monto = 0;
        listaDetalle.forEach(element => {
            monto += (element.precio || element.precioRegistrado * element.cantidad);
        });
        $scope.totalPagar = monto;
    }
}