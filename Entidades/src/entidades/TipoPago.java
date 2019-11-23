package entidades;

public class TipoPago{
    private int codigo_TP;
    private String descripcion_TP;
    private Boolean estado_TP;

    public int getCodigo_TP() {
        return codigo_TP;
    }

    public void setCodigo_TP(int codigo_TP) {
        this.codigo_TP = codigo_TP;
    }
    
    public String getDescripcion_TP() {
        return descripcion_TP;
    }

    public void setDescripcion_TP(String descripcion_TP) {
        this.descripcion_TP = descripcion_TP;
    }

    public Boolean isEstado_TP() {
        return estado_TP;
    }

    public void setEstado_TP(Boolean estado_TP) {
        this.estado_TP = estado_TP;
    }
}
