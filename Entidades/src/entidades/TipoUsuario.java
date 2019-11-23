package entidades;

public class TipoUsuario{
    private int codigo_TU;
    private String descripcion_TU;
    private Boolean estado_TU;

    public int getCodigo_TU() {
        return codigo_TU;
    }

    public void setCodigo_TU(int codigo_TU) {
        this.codigo_TU = codigo_TU;
    }

    public String getDescripcion_TU() {
        return descripcion_TU;
    }

    public void setDescripcion_TU(String descripcion_TU) {
        this.descripcion_TU = descripcion_TU;
    }

    public Boolean isEstado_TU() {
        return estado_TU;
    }

    public void setEstado_TU(Boolean estado_TU) {
        this.estado_TU = estado_TU;
    }
}
