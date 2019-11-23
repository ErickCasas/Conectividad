package dao;
import accesodatos.conexion;
import entidades.TipoCliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoCliente extends conexion{
    public void registrar(TipoCliente tc) throws Exception {
        String sql = "INSERT INTO tipocliente( descripcion_TC, estado_TC) "
                + " VALUES ( '" + tc.getDescripcion_TC()+ "', " 
                + (tc.isEstado_TC()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<TipoCliente> listar() throws Exception {
        List<TipoCliente> tipoclientes = null;
        TipoCliente tc;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT TC.codigo_TC, TC.descripcion_TC, TC.estado_TC "
                    + " FROM tipocliente TC "
                    + "ORDER BY TC.tipocliente");
            tipoclientes = new ArrayList<>();
            while (rs.next() == true) {
                tc = new TipoCliente();
                tc.setCodigo_TC(rs.getInt("codigo_TC"));
                tc.setDescripcion_TC(rs.getString("descripcion_TC"));
                tc.setEstado_TC(rs.getBoolean("estado_TC"));
                tipoclientes.add(tc);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tipoclientes;
    }
    
    public TipoCliente leer(int id) throws Exception {
        TipoCliente tc = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM tipocliente "
                    + " WHERE codigo_TC = " + id + ";");
            while (rs.next() == true) {
                tc = new TipoCliente();
                tc.setCodigo_TC(rs.getInt("codigo_TC"));
                tc.setDescripcion_TC(rs.getString("descripcion_TC"));
                tc.setEstado_TC(rs.getBoolean("estado_TC"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tc;
    }   
    
    public void modificar(TipoCliente tc) throws Exception {
        String sql = "UPDATE tipocliente SET "
                + "nombre_TC='" + tc.getDescripcion_TC() + "', "
                + "estado_TC =" + (tc.isEstado_TC()== true ? "1" : "0") + " "
                + " WHERE codigo_TC=" + tc.getCodigo_TC()+ ";";
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
        String sql = "DELETE FROM tipocliente "
                + "WHERE codigo_TC=" + id + ";";
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
    
    public List<TipoCliente> buscarNombre(String descripcion) throws Exception{
        List<TipoCliente> tipoclientes = null;
        TipoCliente tc = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM tipocliente WHERE descripcion_TC LIKE '%" + descripcion + "%'");
            
            tipoclientes = new ArrayList<>();
            while (rs.next() == true){
                tc = new TipoCliente();
                tc.setCodigo_TC(rs.getInt("codigo_TC"));
                tc.setDescripcion_TC(rs.getString("descripcion_TC"));
                tc.setEstado_TC(rs.getBoolean("estado_TC"));
                tipoclientes.add(tc);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return tipoclientes;
    }
}
