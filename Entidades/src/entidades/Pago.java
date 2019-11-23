package entidades;

public class Pago{
    private int codigo_P;
    private int codigo_TP;
    private int codigo_COMP;
    private String fecha_COMP;
    private double total_COMP;
    private Boolean estado_COMP;

    public int getCodigo_P() {
        return codigo_P;
    }

    public void setCodigo_P(int codigo_P) {
        this.codigo_P = codigo_P;
    }

    public int getCodigo_TP() {
        return codigo_TP;
    }

    public void setCodigo_TP(int codigo_TP) {
        this.codigo_TP = codigo_TP;
    }

    public int getCodigo_COMP() {
        return codigo_COMP;
    }

    public void setCodigo_COMP(int codigo_COMP) {
        this.codigo_COMP = codigo_COMP;
    }

    public String getFecha_COMP() {
        return fecha_COMP;
    }

    public void setFecha_COMP(String fecha_COMP) {
        this.fecha_COMP = fecha_COMP;
    }

    public double getTotal_COMP() {
        return total_COMP;
    }

    public void setTotal_COMP(double total_COMP) {
        this.total_COMP = total_COMP;
    }

    public Boolean getEstado_COMP() {
        return estado_COMP;
    }

    public void setEstado_COMP(Boolean estado_COMP) {
        this.estado_COMP = estado_COMP;
    }

    
}
