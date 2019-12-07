package dao;
import accesodatos.conexion;
import entidades.TipoComprobante;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoComprobante extends conexion {
    public void registrar(TipoComprobante TCO) throws Exception {
        String sql = "INSERT INTO tipocomprobante( descripcion_TCO, estado_TCO) "
                + " VALUES ( '" + TCO.getDescripcion_TCO()
                + "', " + (TCO.isEstado_TCO()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public List<TipoComprobante> listar() throws Exception {
        List<TipoComprobante> tipocomprobante = null;
        TipoComprobante tco;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT codigo_TCO, descripcion_TCO, estado_TCO "
                    + " FROM tipocomprobante TCO "
                    + "ORDER BY descripcion_TCO");
            tipocomprobante = new ArrayList<>();
            while (rs.next() == true) {
                tco = new TipoComprobante();
                tco.setCodigo_TCO(rs.getInt("codigo_TCO"));
                tco.setDescripcion_TCO(rs.getString("descripcion_TCO"));
                tco.setEstado_TCO(rs.getBoolean("estado_TCO"));
                tipocomprobante.add(tco);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tipocomprobante;
    }
     
    public TipoComprobante leer(int id) throws Exception {
        TipoComprobante tco = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM tipocomprobante "
                    + " WHERE codigo_TCO = " + id + ";");
            while (rs.next() == true) {
                tco = new TipoComprobante();
                tco.setCodigo_TCO(rs.getInt("codigo_TCO"));
                tco.setDescripcion_TCO(rs.getString("descripcion_TCO"));
                tco.setEstado_TCO(rs.getBoolean("estado_TCO"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tco;
    }
         
    public void modificar(TipoComprobante tco) throws Exception {
        String sql = "UPDATE tipocomprobante SET "
                + "nombre_TCO='" + tco.getDescripcion_TCO() + "', "
                + "estado_TCO =" + (tco.isEstado_TCO()== true ? "1" : "0") + " "
                + " WHERE codigo_TCO=" + tco.getCodigo_TCO()+ ";";
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
        String sql = "DELETE FROM tipocomprobante "
                + "WHERE codigo_TCO=" + id + ";";
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
       
    public List<TipoComprobante> buscarNombre(String estado) throws Exception{
        List<TipoComprobante> tipocomprobante = null;
        TipoComprobante tco = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM tipocomprobante WHERE estado_TCO LIKE '%" + estado + "%'");
            
            tipocomprobante = new ArrayList<>();
            while (rs.next() == true){
                tco = new TipoComprobante();
                tco.setCodigo_TCO(rs.getInt("codigo_TCO"));
                tco.setDescripcion_TCO(rs.getString("descripcion_TCO"));
                tco.setEstado_TCO(rs.getBoolean("estado_TCO"));
                tipocomprobante.add(tco);             
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return tipocomprobante;
    } 
       
}
