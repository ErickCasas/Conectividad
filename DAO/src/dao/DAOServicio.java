package dao;

import accesodatos.conexion;
import entidades.Proveedor;
import entidades.Servicio;
import entidades.TipoServicio;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOServicio extends conexion{
    public void registrar(Servicio S) throws Exception {
        String sql = "INSERT INTO servicio( codigo_TS, codigo_PR, nombre_S, descripcion_S, precio_S, estado_S) "
                + " VALUES ( " + S.getCodigo_TS() + ", " + S.getCodigo_PR() + ", '" + S.getNombre_S()+ "', '" + S.getDescripcion_S() + "', '" + S.getPrecio_S() + "',1)";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<Servicio> listar() throws Exception {
        List<Servicio> servicios = null;
        Servicio S;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * FROM servicio S INNER JOIN tiposervicio TS "
                    + " ON S.codigo_TS = TS.codigo_TS"
                    + " INNER JOIN proveedor P ON P.codigo_PR = S.codigo_PR");
            servicios = new ArrayList<>();
            while (rs.next() == true) {
                S = new Servicio();
                S.setCodigo_S(rs.getInt("codigo_S"));
                S.setCodigo_TS(rs.getInt("codigo_TS"));
                S.setCodigo_PR(rs.getInt("codigo_PR"));
                S.setNombre_S(rs.getString("nombre_S"));
                S.setDescripcion_S(rs.getString("descripcion_S"));
                S.setPrecio_S(rs.getString("precio_S"));
                S.setEstado(rs.getBoolean("estado_S"));
                S.setTS(new TipoServicio());
                S.setPR(new Proveedor());
                S.getTS().setDescripcion_TS(rs.getString("descripcion_TS"));
                S.getPR().setRazonSocial_PR(rs.getString("razonSocial_PR"));
                servicios.add(S);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return servicios;
    }
     
    public Servicio leer(int id) throws Exception {
        Servicio S = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM servicio "
                    + " WHERE codigo_S = " + id + ";");
            while (rs.next() == true) {
                S = new Servicio();
                S.setCodigo_S(rs.getInt("codigo_S"));
                S.setCodigo_TS(rs.getInt("codigo_TS"));
                S.setCodigo_PR(rs.getInt("codigo_PR"));
                S.setNombre_S(rs.getString("nombre_S"));
                S.setDescripcion_S(rs.getString("descripcion_S"));
                S.setPrecio_S(rs.getString("precio_S"));
                S.setEstado(rs.getBoolean("estado_S"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return S;
    }   
    
    public void modificar(Servicio S) throws Exception {
        String sql = "UPDATE servicio SET "
                + "codigo_TS=" + S.getCodigo_TS() + ", "
                + "codigo_PR=" + S.getCodigo_PR() + ", "
                + "nombre_S='" + S.getNombre_S() + "', "
                + "descripcion_S='" + S.getDescripcion_S() + "', "
                + "precio_S='" + S.getPrecio_S() + "' "               
                + " WHERE codigo_S=" + S.getCodigo_S()+ ";";
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
        String sql = "DELETE FROM servicio "
                + "WHERE codigo_S=" + id + ";";
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
        String sql = "UPDATE servicio SET estado_S = 0 WHERE codigo_S= "+id+";";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }   
    
    public List<Servicio> buscarNombre(String nombre) throws Exception{
        List<Servicio> servicios = null;
        Servicio S = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM servicio WHERE nombre_S LIKE '%" + nombre + "%'");
            
            servicios = new ArrayList<>();
            while (rs.next() == true){
                S = new Servicio();
                S.setCodigo_S(rs.getInt("codigo_S"));
                S.setCodigo_TS(rs.getInt("codigo_TS"));
                S.setCodigo_PR(rs.getInt("codigo_PR"));
                S.setNombre_S(rs.getString("nombre_S"));
                S.setDescripcion_S(rs.getString("descripcion_S"));
                S.setPrecio_S(rs.getString("precio_S"));
                S.setEstado(rs.getBoolean("estado_S"));
                servicios.add(S);               
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return servicios;
    }
}
