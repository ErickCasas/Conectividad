/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesodatos.conexion;
import entidades.Pago;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lorena
 */
public class DAOPago extends conexion{
 
    public void registrar(Pago P) throws Exception {
        String sql = "INSERT INTO Pago( codigo_TP, codigo_COMP, fecha_COMP, total_COMP, estado_COMP) "
                + " VALUES ( '" + P.getCodigo_TP() + "', '" + P.getCodigo_COMP()
                + "', '" + P.getFecha_COMP()+ "', '" + P.getTotal_COMP()+ "', "  
                + (P.getEstado_COMP()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    
        public List<Pago> listar() throws Exception {
        List<Pago> Pago = null;
        Pago P;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT P.codigo_TP, P.codigo_COMP, P.fecha_COMP, P.total_COMP, P.estado_COMP "
                    + " FROM Pago P "
                    + "ORDER BY P.estado_COMP");
            Pago = new ArrayList<>();
            while (rs.next() == true) {
                P = new Pago();
                P.setCodigo_TP(rs.getInt("codigo_TP"));
                P.setCodigo_COMP(rs.getInt("codigo_COMP"));
                P.setFecha_COMP(rs.getString("fecha_COMP"));
                P.setTotal_COMP(rs.getDouble("total_COMP"));             
                P.setEstado_COMP(rs.getBoolean("estado_COMP"));
                Pago.add(P);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return Pago;
    }
    
    public Pago leer(int id) throws Exception {
        Pago P = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM Pago "
                    + " WHERE codigo_P = " + id + ";");
            while (rs.next() == true) {
                P = new Pago();
                P.setCodigo_TP(rs.getInt("codigo_TP"));
                P.setCodigo_COMP(rs.getInt("codigo_COMP"));
                P.setFecha_COMP(rs.getString("fecha_COMP"));
                P.setTotal_COMP(rs.getDouble("total_COMP"));            
                P.setEstado_COMP(rs.getBoolean("estado_COMP"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return P;
    }  
    
    
        public void modificar(Pago P) throws Exception {
        String sql = "UPDATE PAGO SET "
                + "codigo_TP='" + P.getCodigo_TP() + "', "
                + "codigo_COMP='" + P.getCodigo_COMP() + "', "
                + "fecha_COMP'" + P.getFecha_COMP() + "', "
                + "total_COMP='" + P.getTotal_COMP()+ "', "            
                + "estado_COMP =" + (P.getEstado_COMP()== true ? "1" : "0") + " "
                + " WHERE codigo_P=" + P.getCodigo_P()+ ";";
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
        String sql = "DELETE FROM Pago "
                + "WHERE Pago_P=" + id + ";";
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
      
       
      public List<Pago> buscarNombre(String fecha) throws Exception{
        List<Pago> Pago = null;
        Pago P = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM servicio WHERE fecha_P LIKE '%" + fecha + "%'");
            
            Pago = new ArrayList<>();
            while (rs.next() == true){
                P = new Pago();
               P.setCodigo_TP(rs.getInt("codigo_TP"));
                P.setCodigo_COMP(rs.getInt("codigo_COMP"));
                P.setFecha_COMP(rs.getString("fecha_COMP"));
                P.setTotal_COMP(rs.getDouble("total_COMP"));  
                P.setEstado_COMP(rs.getBoolean("estado_COMP"));
               Pago.add(P);
               
          
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return Pago;
    }
}
