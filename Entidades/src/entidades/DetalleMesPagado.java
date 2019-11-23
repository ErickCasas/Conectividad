package entidades;

public class DetalleMesPagado{
    private int codigo_DMP;
    private int codigo_M;
    private int codigo_P;
    private double monto_DMP;

    public int getCodigo_DMP() {
        return codigo_DMP;
    }

    public void setCodigo_DMP(int codigo_DMP) {
        this.codigo_DMP = codigo_DMP;
    }

    public int getCodigo_M() {
        return codigo_M;
    }

    public void setCodigo_M(int codigo_M) {
        this.codigo_M = codigo_M;
    }

    public int getCodigo_P() {
        return codigo_P;
    }

    public void setCodigo_P(int codigo_P) {
        this.codigo_P = codigo_P;
    }

    public double getMonto_DMP() {
        return monto_DMP;
    }

    public void setMonto_DMP(double monto_DMP) {
        this.monto_DMP = monto_DMP;
    }
}
