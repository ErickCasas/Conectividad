/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesodatos.conexion;
import entidades.Mes;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOMes extends conexion{
    public void registrar(Mes m) throws Exception {
        String sql = "INSERT INTO mes(codigo_CONT, intervaloT_M, fechaInicio_M, fechaFin_M, vigencia_M, "
                + "observacion_M,costo_M) "
                + " VALUES ( " + m.getCodigo_CONT()+ ", '" + m.getIntervaloT_M()
                + "', '" + m.getFechaInicio_M() + "', '" + m.getFechaFin_M() 
                + "', '" + (m.getVigencia_M()== true ? "1" : "0") 
                + "', '" + m.getObservacion_M()+ "', " + m.getCosto_M() + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<Mes> listar() throws Exception {
        List<Mes> meses = null;
        Mes m;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT codigo_CONT, intervaloT_M, fechaInicio_M, fechaFin_M, vigencia_M, "
                    + "observacion_M, costo_M "
                    + " FROM mes M "
                    + "ORDER BY M.fechaInicio_M");
            meses = new ArrayList<>();
            while (rs.next() == true) {
                m = new Mes();
                m.setCodigo_CONT(rs.getInt("codigo_CONT"));
                m.setIntervaloT_M(rs.getString("intervaloT_M"));
                m.setFechaInicio_M(rs.getString("fechaInicio_M"));
                m.setFechaFin_M(rs.getString("fechaFin_M"));
                m.setVigencia_M(rs.getBoolean("vigencia_M"));
                m.setObservacion_M(rs.getString("observacion_M"));
                m.setCosto_M(rs.getDouble("costo_M"));
                meses.add(m);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return meses;
    }
     
    public Mes leer(int id) throws Exception {
        Mes m = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM mes "
                    + " WHERE codigo_M = " + id + ";");
            while (rs.next() == true) {
                m = new Mes();
                m.setCodigo_CONT(rs.getInt("codigo_CONT"));
                m.setIntervaloT_M(rs.getString("intervaloT_M"));
                m.setFechaInicio_M(rs.getString("fechaInicio_M"));
                m.setFechaFin_M(rs.getString("fechaFin_M"));
                m.setVigencia_M(rs.getBoolean("vigencia_M"));
                m.setObservacion_M(rs.getString("observacion_M"));
                m.setCosto_M(rs.getDouble("costo_M"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return m;
    }
    
    
    public void modificar(Mes m) throws Exception {
        String sql = "UPDATE mes SET "
                + "codigo_CONT=" + m.getCodigo_CONT()+ " , "
                + "intervaloT_M='" + m.getIntervaloT_M()+ "', "
                + "fechaInicio_M='" + m.getFechaInicio_M()+ "', "
                + "fechaFin_M='" + m.getFechaFin_M()+ "', "
                + "vigencia_M =" + (m.getVigencia_M()== true ? "1" : "0") + ","
                + "observacion_M='" + m.getObservacion_M()+ "',"
                + "costo_M='" + m.getCosto_M()+ " "
                + " WHERE codigo_M=" + m.getCodigo_M()+ " ";
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
        String sql = "DELETE FROM mes "
                + "WHERE codigo_M=" + id + ";";
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
