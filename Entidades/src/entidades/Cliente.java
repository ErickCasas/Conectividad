package entidades;

public class Cliente{
    private int codigo_C;
    private int codigo_TC;    
    private String nroDocumento_C;
    private String nombre_C;
    private String apellido_C;
    private String direccion_C;
    private String telefono_C;
    private Boolean estado_C;

    public int getCodigo_C() {
        return codigo_C;
    }

    public void setCodigo_C(int codigo_C) {
        this.codigo_C = codigo_C;
    }

    public int getCodigo_TC() {
        return codigo_TC;
    }

    public void setCodigo_TC(int codigo_TC) {
        this.codigo_TC = codigo_TC;
    }

    public String getNroDocumento_C() {
        return nroDocumento_C;
    }

    public void setNroDocumento_C(String nroDocumento_C) {
        this.nroDocumento_C = nroDocumento_C;
    }
    
        public String getNombre_C() {
        return nombre_C;
    }

    public void setNombre_C(String nombre_C) {
        this.nombre_C = nombre_C;
    }

    public String getApellido_C() {
        return apellido_C;
    }

    public void setApellido_C(String apellido_C) {
        this.apellido_C = apellido_C;
    }

    public String getDireccion_C() {
        return direccion_C;
    }

    public void setDireccion_C(String direccion_C) {
        this.direccion_C = direccion_C;
    }

    public String getTelefono_C() {
        return telefono_C;
    }

    public void setTelefono_C(String telefono_C) {
        this.telefono_C = telefono_C;
    }

    public Boolean isEstado_C() {
        return estado_C;
    }

    public void setEstado_C(Boolean estado_C) {
        this.estado_C = estado_C;
    }

}
