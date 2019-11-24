package entidades;

public class TipoServicio{
    private int codigo_TS;
    private String descripcion_TS;
    private Boolean estado_TS;

    public int getCodigo_TS() {
        return codigo_TS;
    }

    public void setCodigo_TS(int codigo_TS) {
        this.codigo_TS = codigo_TS;
    }

    public String getDescripcion_TS() {
        return descripcion_TS;
    }

    public void setDescripcion_TS(String descripcion_TS) {
        this.descripcion_TS = descripcion_TS;
    }

    public Boolean isEstado_TS() {
        return estado_TS;
    }

    public void setEstado_TS(Boolean estado_TS) {
        this.estado_TS = estado_TS;
    }
}
