/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesodatos.conexion;
import entidades.EntidadBancaria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DAOEntidadBancaria extends conexion{
    
   public void registrar(EntidadBancaria EB) throws Exception {
        String sql = "INSERT INTO entidadbancaria( nombre_E, direccion_E, ruc_E) "
                + " VALUES ( '" + EB.getNombre_E() + "', '" + EB.getDireccion_E()
                + "', '" + EB.getRuc_E() + "' )";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
   
   
   
    public List<EntidadBancaria> listar() throws Exception {
        List<EntidadBancaria> EntidadBancaria = null;
        EntidadBancaria EB;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT  EB.nombre_E, EB.direccion_E, EB.ruc_E "
                    + " FROM EntidadBancaria EB "
                    + "ORDER BY EB.nombre_E");
            EntidadBancaria = new ArrayList<>();
            while (rs.next() == true) {
                EB = new EntidadBancaria();
                EB.setNombre_E(rs.getString("nombre_E"));
                EB.setDireccion_E(rs.getString("direccion_E"));
                EB.setRuc_E(rs.getString("ruc_E"));
                
                EntidadBancaria.add(EB);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return EntidadBancaria;
        
    }
    
       public EntidadBancaria leer(int id) throws Exception {
        EntidadBancaria EB = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM EntidadBancaria "
                    + " WHERE ruc_E = " + id + ";");
            while (rs.next() == true) {
                EB = new EntidadBancaria();
                EB.setNombre_E(rs.getString("nombre_E"));
                EB.setDireccion_E(rs.getString("direccion_E"));
                EB.setRuc_E(rs.getString("ruc_E"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return EB;
    }  
    
    public void modificar(EntidadBancaria EB) throws Exception {
        String sql = "UPDATE EntidadBancaria SET "
               
                + "nombre_E'" + EB.getNombre_E() + "', "
                + "dreccion_E='" + EB.getDireccion_E()+ "', "
                + "ruc_E='" + EB.getRuc_E()+ "', "
           
                + " WHERE ruc_E=" + EB.getRuc_E()+ ";";
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
        String sql = "DELETE FROM EntidadBancaria "
                + "WHERE ruc_E=" + id + ";";
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
    
    public void cambiarEstado(int id) throws Exception {
        String sql = "UPDATE EntidadBancaria SET estado_E = 0 WHERE codigo_E= "+id+";";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
        
      
        public List<EntidadBancaria> buscarRucEntidadBancaria(String ruc_E) throws Exception{
        List<EntidadBancaria> EntidadBancaria = null;
        EntidadBancaria EB = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM EntidadBancaria WHERE ruc_E LIKE '%" + ruc_E + "%'");
            
            EntidadBancaria = new ArrayList<>();
            while (rs.next() == true){
                EB = new EntidadBancaria();
               
                EB.setNombre_E(rs.getString("nombre_E"));
                EB.setDireccion_E(rs.getString("direccion_E"));
                EB.setRuc_E(rs.getString("ruc_E"));
                
                EntidadBancaria.add(EB);
                            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return EntidadBancaria;
    }
        
}
