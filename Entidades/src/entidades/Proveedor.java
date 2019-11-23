package entidades;

public class Proveedor{
    private int codigo_PR;
    private String razonSocial_PR;
    private String nombre_PR;
    private String ruc_PR;
    private String direccion_PR;
    private String telefono_PR;
    private boolean estado_PR;
    
    public int getCodigo_PR() {
        return codigo_PR;
    }

    public void setCodigo_PR(int codigo_PR) {
        this.codigo_PR = codigo_PR;
    }

    public String getRazonSocial_PR() {
        return razonSocial_PR;
    }

    public void setRazonSocial_PR(String razonSocial_PR) {
        this.razonSocial_PR = razonSocial_PR;
    }

    public String getNombre_PR() {
        return nombre_PR;
    }

    public void setNombre_PR(String nombre_PR) {
        this.nombre_PR = nombre_PR;
    }

    public String getRuc_PR() {
        return ruc_PR;
    }

    public void setRuc_PR(String ruc_PR) {
        this.ruc_PR = ruc_PR;
    }

    public String getDireccion_PR() {
        return direccion_PR;
    }

    public void setDireccion_PR(String direccion_PR) {
        this.direccion_PR = direccion_PR;
    }

    public String getTelefono_PR() {
        return telefono_PR;
    }

    public void setTelefono_PR(String telefono_PR) {
        this.telefono_PR = telefono_PR;
    }

    public boolean isEstado_PR() {
        return estado_PR;
    }

    public void setEstado_PR(boolean estado_PR) {
        this.estado_PR = estado_PR;
    }
}
