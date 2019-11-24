package dao;
import accesodatos.conexion;
import entidades.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario extends conexion{
    public void registrar(Usuario U) throws Exception {
        String sql = "INSERT INTO usuario (codigo_TU, codigo_C, codigo_P, nombre_U, password_U, vigencia_U) "
                + " VALUES ( " + U.getCodigo_TU()+ ", " + U.getCodigo_C()+ ", " + U.getCodigo_P() + ", '" +  U.getNombre_U()+ "', '" + U.getPassword_U() + "', "  
                + (U.isVigencia_U()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<Usuario> listar() throws Exception {
        List<Usuario> usuario = null;
        Usuario U;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT codigo_U, codigo_TU, codigo_C, codigo_P, nombre_U, password_U, vigencia_U "
                    + " FROM usuario U "
                    + "ORDER BY U.nombre_U");
            usuario = new ArrayList<>();
            while (rs.next() == true) {
                U = new Usuario();
                U.setCodigo_U(rs.getInt("codigo_U"));
                U.setCodigo_TU(rs.getInt("codigo_TU"));
                U.setCodigo_C(rs.getInt("codigo_C"));
                U.setCodigo_P(rs.getInt("codigo_P"));
                U.setNombre_U(rs.getString("nombre_U"));
                U.setPassword_U(rs.getString("password_U"));
                U.setVigencia_U(rs.getBoolean("vigencia_U"));
                usuario.add(U);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return usuario;
    }
     
    public Usuario leer(int id) throws Exception {
        Usuario U = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM usuario "
                    + " WHERE codigo_U = " + id + ";");
            while (rs.next() == true) {
                U = new Usuario();
                U.setCodigo_U(rs.getInt("codigo_U"));
                U.setCodigo_TU(rs.getInt("codigo_TU"));
                U.setCodigo_C(rs.getInt("codigo_C"));
                U.setCodigo_P(rs.getInt("codigo_P"));
                U.setNombre_U(rs.getString("nombre_U"));
                U.setPassword_U(rs.getString("password_U"));
                U.setVigencia_U(rs.getBoolean("vigencia_U"));
               }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return U;
    }
       
    public void modificar(Usuario U) throws Exception {
        String sql = "UPDATE usuario SET "
                + "codigo_TU=" + U.getCodigo_TU()+ " , "
                + "codigo_C=" + U.getCodigo_C()+ " , "
                + "codigo_P=" + U.getCodigo_P()+ " , "
                + "nombre_U='" + U.getNombre_U()+ "' , "
                + "password_U='" + U.getPassword_U()+ "' , "
                + "vigencia_U=" + U.isVigencia_U()+ ";";
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
        String sql = "DELETE FROM usuario "
                + "WHERE codigo_U=" + id + ";";
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
    
    public List<Usuario> buscarNombre(String nombre) throws Exception{
        List<Usuario> usuarios = null;
        Usuario u = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM usuario WHERE codigo_U LIKE '%" + nombre + "%'");
            
            usuarios = new ArrayList<>();
            while (rs.next() == true){
                u = new Usuario();
                u.setCodigo_U(rs.getInt("codigo_U"));
                u.setCodigo_TU(rs.getInt("codigo_TU"));
                u.setCodigo_C(rs.getInt("codigo_C"));
                u.setCodigo_P(rs.getInt("codigo_P"));
                u.setNombre_U(rs.getString("nombre_U"));
                u.setPassword_U(rs.getString("password_U"));
                u.setVigencia_U(rs.getBoolean("vigencia_U"));
                usuarios.add(u);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return usuarios;
    }
}
