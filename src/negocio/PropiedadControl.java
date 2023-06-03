package negocio;

import dominio.Propiedad;
import datos.impl.PropiedadDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import datos.PropiedadDAO;

public class PropiedadControl {
    
    private final PropiedadDAO DATOS;
    private Propiedad obj;
    
    public PropiedadControl() {
        
        this.DATOS = new PropiedadDAOImpl();
        this.obj = new Propiedad();
    }
    
    private DefaultTableModel modeloTabla;
    public DefaultTableModel listar(String texto){
        
        List<Propiedad> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "NOMBRE", "DIRECCION", "CARACTERISTICAS", "ESTADO", "PRECIO ALQUILER"};
        String[] registro = new String[6];
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        for (Propiedad item : lista) {
            
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDireccion();
            registro[3] = item.getCaracteristica();
            registro[4] = item.getEstado();
            registro[5] = Double.toString(item.getPrecioalquiler());
            this.modeloTabla.addRow(registro);
          
         }
        
         return this.modeloTabla;
    }
    
}
