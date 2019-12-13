package entidades;

public class Contrato{
    private int codigo_CONT;
    private int codigo_C;
    private int codigo_S;
    private String fechaInicio_CONT;
    private String fechaFin_CONT;
    private String tipoContrato_CONT;
    private Boolean estado_CONT;
    private Cliente C;
    private Servicio S;

    public Cliente getC() {
        return C;
    }

    public void setC(Cliente C) {
        this.C = C;
    }

    public Servicio getS() {
        return S;
    }

    public void setS(Servicio S) {
        this.S = S;
    }
    
    public int getCodigo_CONT() {
        return codigo_CONT;
    }

    public void setCodigo_CONT(int codigo_CONT) {
        this.codigo_CONT = codigo_CONT;
    }

    public int getCodigo_C() {
        return codigo_C;
    }

    public void setCodigo_C(int codigo_C) {
        this.codigo_C = codigo_C;
    }

    public int getCodigo_S() {
        return codigo_S;
    }

    public void setCodigo_S(int codigo_S) {
        this.codigo_S = codigo_S;
    }

    public String getFechaInicio_CONT() {
        return fechaInicio_CONT;
    }

    public void setFechaInicio_CONT(String fechaInicio_CONT) {
        this.fechaInicio_CONT = fechaInicio_CONT;
    }

    public String getFechaFin_CONT() {
        return fechaFin_CONT;
    }

    public void setFechaFin_CONT(String fechaFin_CONT) {
        this.fechaFin_CONT = fechaFin_CONT;
    }

    public String getTipoContrato_CONT() {
        return tipoContrato_CONT;
    }

    public void setTipoContrato_CONT(String tipoContrato_CONT) {
        this.tipoContrato_CONT = tipoContrato_CONT;
    }

    public Boolean isEstado_CONT() {
        return estado_CONT;
    }

    public void setEstado_CONT(Boolean estado_CONT) {
        this.estado_CONT = estado_CONT;
    }
}
