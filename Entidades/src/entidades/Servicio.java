package entidades;

public class Servicio{
    private int codigo_S;
    private int codigo_TS;
    private int codigo_PR;
    private String nombre_S;
    private String descripcion_S;
    private String precio_S;
    private Boolean estado;

    public int getCodigo_S() {
        return codigo_S;
    }

    public void setCodigo_S(int codigo_S) {
        this.codigo_S = codigo_S;
    }

    public int getCodigo_TS() {
        return codigo_TS;
    }

    public void setCodigo_TS(int codigo_TS) {
        this.codigo_TS = codigo_TS;
    }

    public int getCodigo_PR() {
        return codigo_PR;
    }

    public void setCodigo_PR(int codigo_PR) {
        this.codigo_PR = codigo_PR;
    }

    public String getNombre_S() {
        return nombre_S;
    }

    public void setNombre_S(String nombre_S) {
        this.nombre_S = nombre_S;
    }

    public String getDescripcion_S() {
        return descripcion_S;
    }

    public void setDescripcion_S(String descripcion_S) {
        this.descripcion_S = descripcion_S;
    }

    public String getPrecio_S() {
        return precio_S;
    }

    public void setPrecio_S(String precio_S) {
        this.precio_S = precio_S;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }  
}
