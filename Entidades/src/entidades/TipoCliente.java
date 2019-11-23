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
public class TipoCliente{
    private int codigo_TC;
    private String descripcion_TC;
    private Boolean estado_TC;

    /**
     * @return int return the codigo_TC
     */
    public int getCodigo_TC() {
        return codigo_TC;
    }

    /**
     * @param codigo_TC the codigo_TC to set
     */
    public void setCodigo_TC(int codigo_TC) {
        this.codigo_TC = codigo_TC;
    }

    /**
     * @return String return the descripcion_TC
     */
    public String getDescripcion_TC() {
        return descripcion_TC;
    }

    /**
     * @param descripcion_TC the descripcion_TC to set
     */
    public void setDescripcion_TC(String descripcion_TC) {
        this.descripcion_TC = descripcion_TC;
    }

    /**
     * @return Boolean return the estado_TC
     */
    public Boolean isEstado_TC() {
        return estado_TC;
    }

    /**
     * @param estado_TC the estado_TC to set
     */
    public void setEstado_TC(Boolean estado_TC) {
        this.estado_TC = estado_TC;
    }

}
