/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesodatos.conexion;
import entidades.DetalleMesPagado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAODetalleMesPagado extends conexion{
    public void registrar(DetalleMesPagado Dm) throws Exception {
        String sql = "INSERT INTO detallemespagado(codigo_M, codigo_P, monto_DMP) "
                + " VALUES ( " + Dm.getCodigo_M()+ ", " + Dm.getCodigo_P()
                + ", " + Dm.getMonto_DMP() + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<DetalleMesPagado> listar() throws Exception {
        List<DetalleMesPagado> meses = null;
        DetalleMesPagado Dm;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT codigo_M, codigo_P, monto_DMP "
                    + " FROM detallemespagado DM "
                    + "ORDER BY DM.monto_DMP");
            meses = new ArrayList<>();
            while (rs.next() == true) {
                Dm = new DetalleMesPagado();
                Dm.setCodigo_M(rs.getInt("codigo_M"));
                Dm.setCodigo_P(rs.getInt("codigo_CONT"));
                Dm.setMonto_DMP(rs.getDouble("monto_DMP"));
                meses.add(Dm);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return meses;
    }
     
    public DetalleMesPagado leer(int id) throws Exception {
        DetalleMesPagado Dm = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM detallemespagado "
                    + " WHERE codigo_DMP = " + id + ";");
            while (rs.next() == true) {
                Dm = new DetalleMesPagado();
                Dm.setCodigo_M(rs.getInt("codigo_M"));
                Dm.setCodigo_P(rs.getInt("codigo_P"));
                Dm.setMonto_DMP(rs.getDouble("monto_DMP"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return Dm;
    }
    
    
    public void modificar(DetalleMesPagado Dm) throws Exception {
        String sql = "UPDATE detallemespagado SET "
                + "codigo_CONT=" + Dm.getCodigo_M()+ " , "
                + "codigo_CONT=" + Dm.getCodigo_P()+ " , "
                + "codigo_CONT=" + Dm.getMonto_DMP()+ " ";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM detallemespagado "
                + "WHERE codigo_DMP=" + id + ";";
        System.out.println("sql eliminar--> " + sql);
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
}
