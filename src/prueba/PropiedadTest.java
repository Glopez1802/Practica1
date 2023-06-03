
package prueba;

import datos.impl.PropiedadDAOImpl;
import dominio.Propiedad;

public class PropiedadTest {

    public static void main(String[] args) {
       insertarCategoria("casa2","La Victoria", "Casa Mediana", "Ocupado", 2250.5);

    }
    
    private static void insertarCategoria(String nombre, String direccion, String caracteristica, String estado, Double precioalquiler){
        Propiedad obj=new Propiedad();
        PropiedadDAOImpl datos=new PropiedadDAOImpl();
        obj.setNombre(nombre);
        obj.setDireccion(direccion);
        obj.setCaracteristica(caracteristica);
        obj.setEstado(estado);
        obj.setPrecioalquiler(precioalquiler);
        boolean resp;
        resp=datos.insertar(obj);
        System.out.println("Insertar: "+resp);
    }
          
}
