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
public class TipoComprobante{
    private int codigo_TCO;
    private String descripcion_TCO;
    private Boolean estado_TCO;

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
     * @return String return the descripcion_TCO
     */
    public String getDescripcion_TCO() {
        return descripcion_TCO;
    }

    /**
     * @param descripcion_TCO the descripcion_TCO to set
     */
    public void setDescripcion_TCO(String descripcion_TCO) {
        this.descripcion_TCO = descripcion_TCO;
    }

    /**
     * @return Boolean return the estado_TCO
     */
    public Boolean isEstado_TCO() {
        return estado_TCO;
    }

    /**
     * @param estado_TCO the estado_TCO to set
     */
    public void setEstado_TCO(Boolean estado_TCO) {
        this.estado_TCO = estado_TCO;
    }

}
