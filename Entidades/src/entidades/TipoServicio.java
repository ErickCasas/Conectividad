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
public class TipoServicio{
    private int codigo_TS;
    private String descripcion_TS;
    private Boolean estado_TS;

    /**
     * @return int return the codigo_TS
     */
    public int getCodigo_TS() {
        return codigo_TS;
    }

    /**
     * @param codigo_TS the codigo_TS to set
     */
    public void setCodigo_TS(int codigo_TS) {
        this.codigo_TS = codigo_TS;
    }

    /**
     * @return String return the descripcion_TS
     */
    public String getDescripcion_TS() {
        return descripcion_TS;
    }

    /**
     * @param descripcion_TS the descripcion_TS to set
     */
    public void setDescripcion_TS(String descripcion_TS) {
        this.descripcion_TS = descripcion_TS;
    }

    /**
     * @return Boolean return the estado_TS
     */
    public Boolean isEstado_TS() {
        return estado_TS;
    }

    /**
     * @param estado_TS the estado_TS to set
     */
    public void setEstado_TS(Boolean estado_TS) {
        this.estado_TS = estado_TS;
    }

}
