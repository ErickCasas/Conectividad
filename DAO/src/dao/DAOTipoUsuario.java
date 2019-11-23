package dao;
import accesodatos.conexion;
import entidades.TipoUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoUsuario extends conexion{
    public void registrar(TipoUsuario tu) throws Exception {
        String sql = "INSERT INTO tipousuario( descripcion_TU, estado_TU) "
                + " VALUES ( '" + tu.getDescripcion_TU() + "', " 
                + (tu.isEstado_TU()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<TipoUsuario> listar() throws Exception {
        List<TipoUsuario> tipousuarios = null;
        TipoUsuario tu;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT TU.codigo_TU, TU.descripcion_TU, TU.estado_TU "
                    + " FROM tipousuario TU "
                    + "ORDER BY TU.tipousuario");
            tipousuarios = new ArrayList<>();
            while (rs.next() == true) {
                tu = new TipoUsuario();
                tu.setCodigo_TU(rs.getInt("codigo_TU"));
                tu.setDescripcion_TU(rs.getString("descripcion_TU"));
                tu.setEstado_TU(rs.getBoolean("estado_TU"));
                tipousuarios.add(tu);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tipousuarios;
    }
    
    public TipoUsuario leer(int id) throws Exception {
        TipoUsuario tu = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM tipousuario "
                    + " WHERE codigo_TU = " + id + ";");
            while (rs.next() == true) {
                tu = new TipoUsuario();
                tu.setCodigo_TU(rs.getInt("codigo_TU"));
                tu.setDescripcion_TU(rs.getString("descripcion_TU"));
                tu.setEstado_TU(rs.getBoolean("estado_TU"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return tu;
    }   
    
    public void modificar(TipoUsuario tu) throws Exception {
        String sql = "UPDATE tipousuario SET "
                + "nombre_TU='" + tu.getDescripcion_TU() + "', "
                + "estado_TU =" + (tu.isEstado_TU()== true ? "1" : "0") + " "
                + " WHERE codigo_TU=" + tu.getCodigo_TU()+ ";";
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
        String sql = "DELETE FROM tipousuario "
                + "WHERE codigo_TU=" + id + ";";
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
    
    public List<TipoUsuario> buscarNombre(String descripcion) throws Exception{
        List<TipoUsuario> tipousuarios = null;
        TipoUsuario tu = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM tipousuario WHERE descripcion_TU LIKE '%" + descripcion + "%'");
            
            tipousuarios = new ArrayList<>();
            while (rs.next() == true){
                tu = new TipoUsuario();
                tu.setCodigo_TU(rs.getInt("codigo_TU"));
                tu.setDescripcion_TU(rs.getString("descripcion_TU"));
                tu.setEstado_TU(rs.getBoolean("estado_TU"));
                tipousuarios.add(tu);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return tipousuarios;
    }
}
