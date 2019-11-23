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
public class Usuario{
    private int codigo_U;
    private int codigo_TU;
    private int codigo_C;
    private int codigo_P;
    private String nombre_U;
    private String password_U;
    private boolean vigencia_U;


    /**
     * @return int return the codigo_U
     */
    public int getCodigo_U() {
        return codigo_U;
    }

    /**
     * @param codigo_U the codigo_U to set
     */
    public void setCodigo_U(int codigo_U) {
        this.codigo_U = codigo_U;
    }

    /**
     * @return int return the codigo_TU
     */
    public int getCodigo_TU() {
        return codigo_TU;
    }

    /**
     * @param codigo_TU the codigo_TU to set
     */
    public void setCodigo_TU(int codigo_TU) {
        this.codigo_TU = codigo_TU;
    }

    /**
     * @return int return the codigo_C
     */
    public int getCodigo_C() {
        return codigo_C;
    }

    /**
     * @param codigo_C the codigo_C to set
     */
    public void setCodigo_C(int codigo_C) {
        this.codigo_C = codigo_C;
    }

    /**
     * @return int return the codigo_P
     */
    public int getCodigo_P() {
        return codigo_P;
    }

    /**
     * @param codigo_P the codigo_P to set
     */
    public void setCodigo_P(int codigo_P) {
        this.codigo_P = codigo_P;
    }

    /**
     * @return String return the nombre_U
     */
    public String getNombre_U() {
        return nombre_U;
    }

    /**
     * @param nombre_U the nombre_U to set
     */
    public void setNombre_U(String nombre_U) {
        this.nombre_U = nombre_U;
    }

    /**
     * @return String return the password_U
     */
    public String getPassword_U() {
        return password_U;
    }

    /**
     * @param password_U the password_U to set
     */
    public void setPassword_U(String password_U) {
        this.password_U = password_U;
    }

    /**
     * @return boolean return the vigencia_U
     */
    public boolean isVigencia_U() {
        return vigencia_U;
    }

    /**
     * @param vigencia_U the vigencia_U to set
     */
    public void setVigencia_U(boolean vigencia_U) {
        this.vigencia_U = vigencia_U;
    }

}
