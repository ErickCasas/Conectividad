package dao;

import accesodatos.conexion;
import entidades.Cliente;
import entidades.TipoCliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends conexion{
    public void registrar(Cliente c) throws Exception {
        String sql = "INSERT INTO cliente(codigo_TC, nroDocumento_C, nombre_C, apellido_C, direccion_C, telefono_C, estado_C) "
                + " VALUES ( '" + c.getCodigo_TC() + "', '" + c.getNroDocumento_C() + "', '" + c.getNombre_C()
                + "', '" + c.getApellido_C() + "', '" + c.getDireccion_C() + "','" + c.getTelefono_C() + "', "  
                + (c.isEstado_C()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<Cliente> listar() throws Exception {
        List<Cliente> clientes = null;
        Cliente c;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * FROM cliente C INNER JOIN tipocliente TC "
            + " ON C.codigo_TC = TC.codigo_TC");
            clientes = new ArrayList<>();
            while (rs.next() == true) {
                c = new Cliente();
                c.setCodigo_C(rs.getInt("codigo_C"));
                c.setCodigo_TC(rs.getInt("codigo_TC"));
                c.setNroDocumento_C(rs.getString("nroDocumento_C"));
                c.setNombre_C(rs.getString("nombre_C"));
                c.setApellido_C(rs.getString("apellido_C"));
                c.setDireccion_C(rs.getString("direccion_C"));
                c.setTelefono_C(rs.getString("telefono_C"));
                c.setEstado_C(rs.getBoolean("estado_C"));
                c.setTC(new TipoCliente());
                c.getTC().setDescripcion_TC(rs.getString("descripcion_TC"));
                clientes.add(c);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return clientes;
    }
     
    public Cliente leer(int id) throws Exception {
        Cliente c = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM cliente "
                    + " WHERE nroDocumento_C = " + id + ";");
            while (rs.next() == true) {
                c = new Cliente();
                c.setCodigo_C(rs.getInt("codigo_C"));
                c.setCodigo_TC(rs.getInt("codigo_TC"));
                c.setNroDocumento_C(rs.getString("nroDocumento_C"));
                c.setNombre_C(rs.getString("nombre_C"));
                c.setApellido_C(rs.getString("apellido_C"));
                c.setDireccion_C(rs.getString("direccion_C"));
                c.setTelefono_C(rs.getString("telefono_C"));
                c.setEstado_C(rs.getBoolean("estado_C"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return c;
    }   
    
    public void modificar(Cliente c) throws Exception {
        String sql = "UPDATE cliente SET "
                + "codigo_TC='" + c.getCodigo_TC() + "', "
                + "nroDocumento_C='" + c.getNroDocumento_C()+ "', "
                + "nombre_C='" + c.getNombre_C() + "', "
                + "apellido_C='" + c.getApellido_C() + "', "
                + "direccion_C='" + c.getDireccion_C() + "', "
                + "telefono_C='" + c.getTelefono_C() + "' "
                + " WHERE nroDocumento_C=" + c.getNroDocumento_C()+ ";";
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
        String sql = "DELETE FROM cliente "
                + "WHERE nroDocumento_C=" + id + ";";
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
    
    public List<Cliente> buscarNroDocumento(String nombre) throws Exception{
        List<Cliente> clientes = null;
        Cliente c = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM cliente WHERE nroDocumento_C LIKE '%" + nombre + "%'");
            
            clientes = new ArrayList<>();
            while (rs.next() == true){
                c = new Cliente();
                c.setCodigo_TC(rs.getInt("codigo_TC"));
                c.setCodigo_TC(rs.getInt("nroDocumento_C"));
                c.setNombre_C(rs.getString("nombre_C"));
                c.setApellido_C(rs.getString("apellido_C"));
                clientes.add(c);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return clientes;
    }
}