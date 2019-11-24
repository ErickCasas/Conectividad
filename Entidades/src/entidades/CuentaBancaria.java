package entidades;

public class CuentaBancaria{
    private int codigo_B;
    private int codigo_PR;
    private int codigo_P;
    private String numeroCuenta_B;
    private String tipoCuenta_B;
    private String fechaVencimiento_B;
    private String clave_B;
    private Boolean estado_B;
    private double saldo_B;

    public int getCodigo_B() {
        return codigo_B;
    }

    public void setCodigo_B(int codigo_B) {
        this.codigo_B = codigo_B;
    }

    public int getCodigo_PR() {
        return codigo_PR;
    }

    public void setCodigo_PR(int codigo_PR) {
        this.codigo_PR = codigo_PR;
    }

    public int getCodigo_P() {
        return codigo_P;
    }

    public void setCodigo_P(int codigo_P) {
        this.codigo_P = codigo_P;
    }

    public String getNumeroCuenta_B() {
        return numeroCuenta_B;
    }

    public void setNumeroCuenta_B(String numeroCuenta_B) {
        this.numeroCuenta_B = numeroCuenta_B;
    }

    public String getTipoCuenta_B() {
        return tipoCuenta_B;
    }

    public void setTipoCuenta_B(String tipoCuenta_B) {
        this.tipoCuenta_B = tipoCuenta_B;
    }

    public String getFechaVencimiento_B() {
        return fechaVencimiento_B;
    }

    public void setFechaVencimiento_B(String fechaVencimiento_B) {
        this.fechaVencimiento_B = fechaVencimiento_B;
    }

    public String getClave_B() {
        return clave_B;
    }

    public void setClave_B(String clave_B) {
        this.clave_B = clave_B;
    }

    public Boolean getEstado_B() {
        return estado_B;
    }

    public void setEstado_B(Boolean estado_B) {
        this.estado_B = estado_B;
    }

    public double getSaldo_B() {
        return saldo_B;
    }

    public void setSaldo_B(double saldo_B) {
        this.saldo_B = saldo_B;
    }  
}
