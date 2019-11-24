package entidades;

public class Comprobante{
    private int codigo_COMP;
    private int codigo_CONT;
    private int codigo_TCO;
    private double monto_COMP;
    private Boolean estado_COMP;

    public int getCodigo_COMP() {
        return codigo_COMP;
    }

    public void setCodigo_COMP(int codigo_COMP) {
        this.codigo_COMP = codigo_COMP;
    }

    public int getCodigo_CONT() {
        return codigo_CONT;
    }

    public void setCodigo_CONT(int codigo_CONT) {
        this.codigo_CONT = codigo_CONT;
    }

    public int getCodigo_TCO() {
        return codigo_TCO;
    }

    public void setCodigo_TCO(int codigo_TCO) {
        this.codigo_TCO = codigo_TCO;
    }

    public double getMonto_COMP() {
        return monto_COMP;
    }

    public void setMonto_COMP(double monto_COMP) {
        this.monto_COMP = monto_COMP;
    }

    public Boolean isEstado_COMP() {
        return estado_COMP;
    }

    public void setEstado_COMP(Boolean estado_COMP) {
        this.estado_COMP = estado_COMP;
    }
}
