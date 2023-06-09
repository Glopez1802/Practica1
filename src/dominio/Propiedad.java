
package dominio;


public class Propiedad {
    private int id;
    private String nombre;
    private String direccion;
    private String caracteristica;
    private String estado;
    private double precioalquiler;

    public Propiedad() {
    }

    public Propiedad(int id, String nombre, String direccion, String caracteristica, String estado, double precioalquiler) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.caracteristica = caracteristica;
        this.estado = estado;
        this.precioalquiler = precioalquiler;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioalquiler() {
        return precioalquiler;
    }

    public void setPrecioalquiler(double precioalquiler) {
        this.precioalquiler = precioalquiler;
    }

    
    
}
