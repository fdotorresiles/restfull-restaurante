/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.ucentral.ws;

import java.util.Set;
import javax.ws.rs.core.Application;
/**
 *
 * @author luisfernandotorressiles
 */
@javax.ws.rs.ApplicationPath("restaurante")
public class ConfiguracionAplicacion  extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addResourceClasses(resources);
        return resources;
    }
    
    
    private void addResourceClasses(Set<Class<?>> resources) {
        //Incluir clases de los servicios
        resources.add(ServicioPruebas.class);
        resources.add(Productos.class);
        resources.add(Saloneros.class);
    }
    
}
