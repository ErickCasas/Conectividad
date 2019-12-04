package dao;

import accesodatos.conexion;
import entidades.CuentaBancaria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCuentaBancaria extends conexion{
    public void registrar(CuentaBancaria CB) throws Exception{  
        String sql = "INSERT INTO CuentaBancaria (codigo_PR, codigo_P, numeroCuenta_B, tipoCuenta_B, fechaVencimiento_B, clave_B, estado_B, saldo_B) "  
                + " VALUES ( " + CB.getCodigo_PR() + ", " + CB.getCodigo_P()
                + ", '" + CB.getNumeroCuenta_B() + "', '" + CB.getTipoCuenta_B() + "','" + CB.getFechaVencimiento_B() + "',"
                + "'" + CB.getClave_B() + "', " + (CB.getEstado_B()== true ? "1" : "0") + ", " + CB.getSaldo_B() + ", )";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
          
    public List<CuentaBancaria> listar() throws Exception {
        List<CuentaBancaria> CuentaBancaria = null;
        CuentaBancaria CB;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT codigo_B, codigo_PR, codigo_P, numeroCuenta_B, tipoCuenta_B, fechaVencimiento_B, clave_B, estado_B, saldo_B "
                    + " FROM CuentaBancaria CB "
                    + "ORDER BY tipoCuenta_B");
            CuentaBancaria = new ArrayList<>();
            while (rs.next() == true) {
                CB = new CuentaBancaria();
                CB.setCodigo_B(rs.getInt("codigo_B"));
                CB.setCodigo_PR(rs.getInt("codigo_PR"));
                CB.setCodigo_P(rs.getInt("codigo_P"));
                CB.setNumeroCuenta_B(rs.getString("numeroCuenta_B"));
                CB.setTipoCuenta_B(rs.getString("tipoCuenta_B"));
                CB.setFechaVencimiento_B(rs.getString("fechaVencimiento_B"));
                CB.setClave_B(rs.getString("clave_B"));
                CB.setEstado_B(rs.getBoolean("estado_B"));
                CB.setSaldo_B(rs.getDouble("saldo_B"));
                
                CuentaBancaria.add(CB);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return CuentaBancaria;
    }  
     
    public CuentaBancaria leer(int id) throws Exception {
        CuentaBancaria CB = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM CuentaBancaria "
                    + " WHERE codigo_B = " + id + ";");
            while (rs.next() == true) {
                CB = new CuentaBancaria();
                CB.setCodigo_B(rs.getInt("codigo_B"));
                CB.setCodigo_PR(rs.getInt("codigo_PR"));
                CB.setCodigo_P(rs.getInt("codigo_P"));
                CB.setNumeroCuenta_B(rs.getString("numeroCuenta_B"));
                CB.setTipoCuenta_B(rs.getString("tipoCuenta_B"));
                CB.setFechaVencimiento_B(rs.getString("fechaVencimiento_B"));
                CB.setClave_B(rs.getString("clave_B"));
                CB.setEstado_B(rs.getBoolean("estado_B"));                
                CB.setSaldo_B(rs.getDouble("saldo_B"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return CB;
    }
          
    public void modificar(CuentaBancaria CB) throws Exception {
        String sql = "UPDATE CuentaBancaria SET "
                + "codigo_PR=" + CB.getCodigo_PR() + ", "
                + "codigo_P=" + CB.getCodigo_P() + ", "
                + "numeroCuenta_B'" + CB.getNumeroCuenta_B()+ "', "
                + "tipoCuenta_B='" + CB.getTipoCuenta_B()+ "', "
                + "fechaVencimiento_B='" + CB.getFechaVencimiento_B()+ "', "
                + "clave_B='" + CB.getClave_B()+ "', "
                + "estado_B =" + (CB.getEstado_B()== true ? "1" : "0") + " "
                + "saldo_B=" + CB.getSaldo_B()+ ", "
                + " WHERE codigo_B=" + CB.getCodigo_B()+ ";";
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
        String sql = "DELETE FROM CuentaBancaria "
                + "WHERE codigo_B=" + id + ";";
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
           
    public List<CuentaBancaria> buscarNombre(String numeroCuenta) throws Exception{
        List<CuentaBancaria> CuentaBancaria = null;
        CuentaBancaria CB = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM servicio WHERE numeroCuenta_B LIKE '%" + numeroCuenta + "%'");
            
            CuentaBancaria = new ArrayList<>();
            while (rs.next() == true){
                CB.setCodigo_B(rs.getInt("codigo_B"));
                CB.setCodigo_PR(rs.getInt("codigo_PR"));
                CB.setCodigo_P(rs.getInt("codigo_P"));
                CB.setNumeroCuenta_B(rs.getString("numeroCuenta_B"));           
                CuentaBancaria.add(CB);
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return CuentaBancaria;
    }
 }


