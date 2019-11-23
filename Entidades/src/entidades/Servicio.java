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
public class Servicio{
    private int codigo_S;
    private int codigo_TS;
    private int codigo_PR;
    private String nombre_S;
    private String descripcion_S;
    private String precio_S;
    private Boolean estado;

    /**
     * @return int return the codigo_S
     */
    public int getCodigo_S() {
        return codigo_S;
    }

    /**
     * @param codigo_S the codigo_S to set
     */
    public void setCodigo_S(int codigo_S) {
        this.codigo_S = codigo_S;
    }

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
     * @return int return the codigo_PR
     */
    public int getCodigo_PR() {
        return codigo_PR;
    }

    /**
     * @param codigo_PR the codigo_PR to set
     */
    public void setCodigo_PR(int codigo_PR) {
        this.codigo_PR = codigo_PR;
    }

    /**
     * @return String return the nombre_S
     */
    public String getNombre_S() {
        return nombre_S;
    }

    /**
     * @param nombre_S the nombre_S to set
     */
    public void setNombre_S(String nombre_S) {
        this.nombre_S = nombre_S;
    }

    /**
     * @return String return the descripcion_S
     */
    public String getDescripcion_S() {
        return descripcion_S;
    }

    /**
     * @param descripcion_S the descripcion_S to set
     */
    public void setDescripcion_S(String descripcion_S) {
        this.descripcion_S = descripcion_S;
    }

    /**
     * @return String return the precio_S
     */
    public String getPrecio_S() {
        return precio_S;
    }

    /**
     * @param precio_S the precio_S to set
     */
    public void setPrecio_S(String precio_S) {
        this.precio_S = precio_S;
    }

    /**
     * @return Boolean return the estado
     */
    public Boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
