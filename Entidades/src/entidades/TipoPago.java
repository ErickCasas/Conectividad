/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * 
 */
public class TipoPago{
    private int codigo_TP;
    private String descripcion_TP;
    private Boolean estado_TP;

    /**
     * @return int return the codigo_TP
     */
    public int getCodigo_TP() {
        return codigo_TP;
    }

    /**
     * @param codigo_TP the codigo_TP to set
     */
    public void setCodigo_TP(int codigo_TP) {
        this.codigo_TP = codigo_TP;
    }

    /**
     * @return String return the descripcion_TP
     */
    public String getDescripcion_TP() {
        return descripcion_TP;
    }

    /**
     * @param descripcion_TP the descripcion_TP to set
     */
    public void setDescripcion_TP(String descripcion_TP) {
        this.descripcion_TP = descripcion_TP;
    }

    /**
     * @return Boolean return the estado_TP
     */
    public Boolean isEstado_TP() {
        return estado_TP;
    }

    /**
     * @param estado_TP the estado_TP to set
     */
    public void setEstado_TP(Boolean estado_TP) {
        this.estado_TP = estado_TP;
    }

}
