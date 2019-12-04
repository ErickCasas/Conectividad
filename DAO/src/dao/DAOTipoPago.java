package dao;
import accesodatos.conexion;
import entidades.TipoPago;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoPago extends conexion{
    public void registrar(TipoPago tp) throws Exception {
        String sql = "INSERT INTO tipopago( descripcion_TP, estado_TP) "
                + " VALUES ( '" + tp.getDescripcion_TP() + "', " 
                + (tp.isEstado_TP()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<TipoPago> listar() throws Exception {
        List<TipoPago> tipopagos = null;
        TipoPago tp;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT codigo_TP, descripcion_TP, estado_TP "
                    + " FROM tipopago TP "
                    + "ORDER BY descripcion_TP");
            tipopagos = new ArrayList<>();
            while (rs.next() == true) {
                tp = new TipoPago();
                tp.setCodigo_TP(rs.getInt("codigo_TP"));
                tp.setDescripcion_TP(rs.getString("descripcion_TP"));
                tp.setEstado_TP(rs.getBoolean("estado_TP"));
                tipopagos.add(tp);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tipopagos;
    }
    
    public TipoPago leer(int id) throws Exception {
        TipoPago tp = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM tipopago "
                    + " WHERE codigo_TP = " + id + ";");
            while (rs.next() == true) {
                tp = new TipoPago();
                tp.setCodigo_TP(rs.getInt("codigo_TP"));
                tp.setDescripcion_TP(rs.getString("descripcion_TP"));
                tp.setEstado_TP(rs.getBoolean("estado_TP"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tp;
    }   
    
    public void modificar(TipoPago tp) throws Exception {
        String sql = "UPDATE tipopago SET "
                + "nombre_TP='" + tp.getDescripcion_TP() + "', "
                + "estado_TP =" + (tp.isEstado_TP()== true ? "1" : "0") + " "
                + " WHERE codigo_TP=" + tp.getCodigo_TP()+ ";";
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
        String sql = "DELETE FROM tipopago "
                + "WHERE codigo_TP=" + id + ";";
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
    
    public List<TipoPago> buscarNombre(String descripcion) throws Exception{
        List<TipoPago> tipopagos = null;
        TipoPago tp = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM tipopago WHERE descripcion_TP LIKE '%" + descripcion + "%'");
            
            tipopagos = new ArrayList<>();
            while (rs.next() == true){
                tp = new TipoPago();
                tp.setCodigo_TP(rs.getInt("codigo_TP"));
                tp.setDescripcion_TP(rs.getString("descripcion_TP"));
                tp.setEstado_TP(rs.getBoolean("estado_TP"));
                tipopagos.add(tp);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return tipopagos;
    }
}
