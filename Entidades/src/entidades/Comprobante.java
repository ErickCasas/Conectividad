package entidades;

public class Comprobante{
    private int codigo_COMP;
    private int codigo_CONT;
    private int codigo_TCO;
    private double monto_COMP;
    private Boolean estado_COMP;

    /**
     * @return int return the codigo_COMP
     */
    public int getCodigo_COMP() {
        return codigo_COMP;
    }

    /**
     * @param codigo_COMP the codigo_COMP to set
     */
    public void setCodigo_COMP(int codigo_COMP) {
        this.codigo_COMP = codigo_COMP;
    }

    /**
     * @return int return the codigo_CONT
     */
    public int getCodigo_CONT() {
        return codigo_CONT;
    }

    /**
     * @param codigo_CONT the codigo_CONT to set
     */
    public void setCodigo_CONT(int codigo_CONT) {
        this.codigo_CONT = codigo_CONT;
    }

    /**
     * @return int return the codigo_TCO
     */
    public int getCodigo_TCO() {
        return codigo_TCO;
    }

    /**
     * @param codigo_TCO the codigo_TCO to set
     */
    public void setCodigo_TCO(int codigo_TCO) {
        this.codigo_TCO = codigo_TCO;
    }

    /**
     * @return double return the monto_COMP
     */
    public double getMonto_COMP() {
        return monto_COMP;
    }

    /**
     * @param monto_COMP the monto_COMP to set
     */
    public void setMonto_COMP(double monto_COMP) {
        this.monto_COMP = monto_COMP;
    }

    /**
     * @return Boolean return the estado_COMP
     */
    public Boolean isEstado_COMP() {
        return estado_COMP;
    }

    /**
     * @param estado_COMP the estado_COMP to set
     */
    public void setEstado_COMP(Boolean estado_COMP) {
        this.estado_COMP = estado_COMP;
    }

}
