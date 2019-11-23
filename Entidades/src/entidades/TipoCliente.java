package entidades;

public class TipoCliente{
    private int codigo_TC;
    private String descripcion_TC;
    private Boolean estado_TC;

    public int getCodigo_TC() {
        return codigo_TC;
    }

    public void setCodigo_TC(int codigo_TC) {
        this.codigo_TC = codigo_TC;
    }

    public String getDescripcion_TC() {
        return descripcion_TC;
    }

    public void setDescripcion_TC(String descripcion_TC) {
        this.descripcion_TC = descripcion_TC;
    }

    public Boolean isEstado_TC() {
        return estado_TC;
    }

    public void setEstado_TC(Boolean estado_TC) {
        this.estado_TC = estado_TC;
    }
}
