package entidades;

public class Mes{
    private int codigo_M;
    private int codigo_CONT;
    private String intervaloT_M;
    private String fechaInicio_M;
    private String fechaFin_M;
    private Boolean vigencia_M;
    private String observacion_M;
    private double costo_M;

    public int getCodigo_M() {
        return codigo_M;
    }

    public void setCodigo_M(int codigo_M) {
        this.codigo_M = codigo_M;
    }

    public int getCodigo_CONT() {
        return codigo_CONT;
    }

    public void setCodigo_CONT(int codigo_CONT) {
        this.codigo_CONT = codigo_CONT;
    }

    public String getIntervaloT_M() {
        return intervaloT_M;
    }

    public void setIntervaloT_M(String intervaloT_M) {
        this.intervaloT_M = intervaloT_M;
    }

    public String getFechaInicio_M() {
        return fechaInicio_M;
    }

    public void setFechaInicio_M(String fechaInicio_M) {
        this.fechaInicio_M = fechaInicio_M;
    }

    public String getFechaFin_M() {
        return fechaFin_M;
    }

    public void setFechaFin_M(String fechaFin_M) {
        this.fechaFin_M = fechaFin_M;
    }

    public Boolean getVigencia_M() {
        return vigencia_M;
    }

    public void setVigencia_M(Boolean vigencia_M) {
        this.vigencia_M = vigencia_M;
    }

    public String getObservacion_M() {
        return observacion_M;
    }

    public void setObservacion_M(String observacion_M) {
        this.observacion_M = observacion_M;
    }

    public double getCosto_M() {
        return costo_M;
    }

    public void setCosto_M(double costo_M) {
        this.costo_M = costo_M;
    }
}
