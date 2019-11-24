package dao;
import accesodatos.conexion;
import entidades.TipoServicio;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoServicio extends conexion{
    public void registrar(TipoServicio ts) throws Exception {
        String sql = "INSERT INTO tiposervicio( descripcion_TS, estado_TS) "
                + " VALUES ( '" + ts.getDescripcion_TS() + "', " 
                + (ts.isEstado_TS()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<TipoServicio> listar() throws Exception {
        List<TipoServicio> tiposervicios = null;
        TipoServicio ts;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT TS.codigo_TS, TS.descripcion_TS, TS.estado_TS "
                    + " FROM tiposervicio TS "
                    + "ORDER BY TP.tiposervicio");
            tiposervicios = new ArrayList<>();
            while (rs.next() == true) {
                ts = new TipoServicio();
                ts.setCodigo_TS(rs.getInt("codigo_TS"));
                ts.setDescripcion_TS(rs.getString("descripcion_TS"));
                ts.setEstado_TS(rs.getBoolean("estado_TS"));
                tiposervicios.add(ts);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tiposervicios;
    }
    
    public TipoServicio leer(int id) throws Exception {
        TipoServicio ts = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM tiposervicio "
                    + " WHERE codigo_TS = " + id + ";");
            while (rs.next() == true) {
                ts = new TipoServicio();
                ts.setCodigo_TS(rs.getInt("codigo_TS"));
                ts.setDescripcion_TS(rs.getString("descripcion_TS"));
                ts.setEstado_TS(rs.getBoolean("estado_TS"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return ts;
    }   
    
    public void modificar(TipoServicio ts) throws Exception {
        String sql = "UPDATE tiposervicio SET "
                + "nombre_TS='" + ts.getDescripcion_TS() + "', "
                + "estado_TS =" + (ts.isEstado_TS()== true ? "1" : "0") + " "
                + " WHERE codigo_TS=" + ts.getCodigo_TS()+ ";";
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
        String sql = "DELETE FROM tiposervicio "
                + "WHERE codigo_TS=" + id + ";";
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
    
    public List<TipoServicio> buscarNombre(String descripcion) throws Exception{
        List<TipoServicio> tiposervicios = null;
        TipoServicio ts = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM tiposervicio WHERE descripcion_TS LIKE '%" + descripcion + "%'");
            
            tiposervicios = new ArrayList<>();
            while (rs.next() == true){
                ts = new TipoServicio();
                ts.setCodigo_TS(rs.getInt("codigo_TS"));
                ts.setDescripcion_TS(rs.getString("descripcion_TS"));
                ts.setEstado_TS(rs.getBoolean("estado_TS"));
                tiposervicios.add(ts);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return tiposervicios;
    }
}
    

