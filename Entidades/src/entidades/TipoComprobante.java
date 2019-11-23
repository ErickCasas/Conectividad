package entidades;

public class TipoComprobante{
    private int codigo_TCO;
    private String descripcion_TCO;
    private Boolean estado_TCO;

    public int getCodigo_TCO() {
        return codigo_TCO;
    }

    public void setCodigo_TCO(int codigo_TCO) {
        this.codigo_TCO = codigo_TCO;
    }

    public String getDescripcion_TCO() {
        return descripcion_TCO;
    }

    public void setDescripcion_TCO(String descripcion_TCO) {
        this.descripcion_TCO = descripcion_TCO;
    }

    public Boolean isEstado_TCO() {
        return estado_TCO;
    }

    public void setEstado_TCO(Boolean estado_TCO) {
        this.estado_TCO = estado_TCO;
    }
}
