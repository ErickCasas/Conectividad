/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Lorena
 */
import accesodatos.conexion;
import entidades.Proveedor;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOProveedor extends conexion{
public void Proveedor(Proveedor PR) throws Exception {
        String sql = "INSERT INTO Proveedor( razonSocial_PR, nombre_PR, ruc_PR, direccion_PR, telefono_PR, estado_PR) "
                + " VALUES ( '" + PR.getRazonSocial_PR()+ "', '" + PR.getNombre_PR()
                + "', '" + PR.getRuc_PR()+ "', '" + PR.getDireccion_PR()+ "', '" + PR.getTelefono_PR()+ "', "  
                + (PR.isEstado_PR()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public List<Proveedor> listar() throws Exception {
        List<Proveedor> Proveedor = null;
        Proveedor PR;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT PR.razonSocial_PR, PR.nombre_PR, PR_ruc_PR, PR_direccion_PR, PR_telefono_PR, PR_estado_PR "
                    + " FROM Proveedor PR "
                    + "ORDER BY PR.nombre_PR");
            Proveedor = new ArrayList<>();
            while (rs.next() == true) {
                
                PR = new Proveedor();
                
                PR.setRazonSocial_PR(rs.getString("razonSocial_PR"));           
                PR.setNombre_PR(rs.getString("nombre_PR"));
                PR.setRuc_PR(rs.getString("ruc_PR"));
                PR.setDireccion_PR(rs.getString("direccion_PR"));
                PR.setTelefono_PR(rs.getString("telefono_PR"));
                PR.setEstado_PR(rs.getBoolean("estado_PR"));
                
                Proveedor.add(PR);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return Proveedor;
    }

 public Proveedor leer(int id) throws Exception {
        Proveedor PR = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM Proveedor "
                    + " WHERE codigo_PR = " + id + ";");
            while (rs.next() == true) {
                PR = new Proveedor();
                
                PR.setRazonSocial_PR(rs.getString("razonSocial_PR"));           
                PR.setNombre_PR(rs.getString("nombre_PR"));
                PR.setRuc_PR(rs.getString("ruc_PR"));
                PR.setDireccion_PR(rs.getString("direccion_PR"));
                PR.setTelefono_PR(rs.getString("telefono_PR"));
                PR.setEstado_PR(rs.getBoolean("estado_PR"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return PR;
    }   
    
   public void modificar(Proveedor PR) throws Exception {
        String sql = "UPDATE Proveedor SET "
                + "razonSocial_PR='" + PR.getRazonSocial_PR()+ "', "
                + "nombre_PR='" + PR.getNombre_PR() + "', "
                + "ruc_PR'" + PR.getRuc_PR()+ "', "   
                + "direccion_PR='" + PR.getDireccion_PR()+ "', "
                + "telefono_PR='" + PR.getTelefono_PR()+ "', "
                + "estado_PR =" + (PR.isEstado_PR()== true ? "1" : "0") + " "
                + " WHERE codigo_PR=" + PR.getCodigo_PR()+ ";";
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
        String sql = "DELETE FROM Proveedor "
                + "WHERE Proveedor_PR=" + id + ";";
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
   
       
       public List<Proveedor> buscarNombre(String ruc_PR) throws Exception{
        List<Proveedor> Proveedor = null;
        Proveedor PR = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM Proveedor WHERE ruc_PR LIKE '%" + ruc_PR + "%'");
            
            Proveedor = new ArrayList<>();
            while (rs.next() == true){
                PR = new Proveedor();
                 PR.setCodigo_PR(rs.getInt("codigo_PR"));
                PR.setRazonSocial_PR(rs.getString("razonSocial_PR"));           
                PR.setNombre_PR(rs.getString("nombre_PR"));
               
                PR.setDireccion_PR(rs.getString("direccion_PR"));
                PR.setTelefono_PR(rs.getString("telefono_PR"));
                PR.setEstado_PR(rs.getBoolean("estado_PR"));
                Proveedor.add(PR);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return Proveedor;
    }
}
