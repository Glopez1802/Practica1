
package datos.impl;

import java.sql.PreparedStatement;
import dominio.Propiedad;
import java.util.List;
import java.sql.SQLException;
import database.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.PropiedadDAO;



public class PropiedadDAOImpl implements PropiedadDAO<Propiedad>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public PropiedadDAOImpl(){
        CON=Conexion.getInstancia();
    }
    

    @Override
    public List<Propiedad> listar(String texto) {
         List<Propiedad> registros= new ArrayList();
        try{
           ps=CON.conectar().prepareStatement ( "SELECT  id, nombre, direccion, caracteristica, estado, precioalquiler from propiedades where nombre like ?");
           ps.setString(1 , "%" + texto + "%");
           rs=ps.executeQuery();
            while (rs.next()) {                 
                registros.add(new Propiedad(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6)));
            }             
            ps.close();             
            rs.close(); 
        }catch (SQLException e) { 
            System.out.println(e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }       
        return registros;
    }

    @Override
    public boolean insertar(Propiedad obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("INSERT INTO propiedades (nombre, direccion, caracteristica, estado, precioalquiler)VALUE (?,?,?,?,?)");
            ps.setString(1,obj.getNombre());
            ps.setString(2,obj.getDireccion());
            ps.setString(3,obj.getCaracteristica());
            ps.setString(4,obj.getEstado());
            ps.setDouble(5,obj.getPrecioalquiler());
            if(ps.executeUpdate()>0){
                resp=true;
            }
            
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Propiedad obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
