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
public class DetalleMesPagado{
    private int codigo_DMP;
    private int codigo_M;
    private int codigo_P;
    private double monto_DMP;


    /**
     * @return int return the codigo_DMP
     */
    public int getCodigo_DMP() {
        return codigo_DMP;
    }

    /**
     * @param codigo_DMP the codigo_DMP to set
     */
    public void setCodigo_DMP(int codigo_DMP) {
        this.codigo_DMP = codigo_DMP;
    }

    /**
     * @return int return the codigo_M
     */
    public int getCodigo_M() {
        return codigo_M;
    }

    /**
     * @param codigo_M the codigo_M to set
     */
    public void setCodigo_M(int codigo_M) {
        this.codigo_M = codigo_M;
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
     * @return double return the monto_DMP
     */
    public double getMonto_DMP() {
        return monto_DMP;
    }

    /**
     * @param monto_DMP the monto_DMP to set
     */
    public void setMonto_DMP(double monto_DMP) {
        this.monto_DMP = monto_DMP;
    }

}
