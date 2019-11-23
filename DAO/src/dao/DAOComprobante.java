package dao;
import accesodatos.conexion;
import entidades.Comprobante;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOComprobante extends conexion{
    public void registrar(Comprobante c) throws Exception {
        String sql = "INSERT INTO comprobante( codigo_CONT, codigo_TCO , monto_COMP, estado_COMP) "
                + " VALUES ( " + c.getCodigo_CONT()+ ", " + c.getCodigo_TCO()
                + "," + c.getMonto_COMP()+ ",'" + (c.isEstado_COMP()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<Comprobante> listar() throws Exception {
        List<Comprobante> comprobantes = null;
        Comprobante c;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT codigo_COMP, codigo_CONT, codigo_TCO , monto_COMP, estado_COMP "
                    + " FROM Comprobante C "
                    + "ORDER BY C.monto_COMP");
            comprobantes = new ArrayList<>();
            while (rs.next() == true) {
                c = new Comprobante();
                c.setCodigo_COMP(rs.getInt("codigo_COMP"));
                c.setCodigo_CONT(rs.getInt("codigo_CONT"));
                c.setCodigo_TCO(rs.getInt("codigo_TCO"));
                c.setMonto_COMP(rs.getDouble("monto_COMP"));
                c.setEstado_COMP(rs.getBoolean("estado_COMP"));
                comprobantes.add(c);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return comprobantes;
    }
     
    public Comprobante leer(int id) throws Exception {
        Comprobante c = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM Comprobante "
                    + " WHERE codigo_COMP = " + id + ";");
            while (rs.next() == true) {
                c = new Comprobante();
                c.setCodigo_COMP(rs.getInt("codigo_COMP"));
                c.setCodigo_CONT(rs.getInt("codigo_CONT"));
                c.setCodigo_TCO(rs.getInt("codigo_TCO"));
                c.setMonto_COMP(rs.getDouble("monto_COMP"));
                c.setEstado_COMP(rs.getBoolean("estado_COMP"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return c;
    }
     
    public void modificar(Comprobante c) throws Exception {
        String sql = "UPDATE comprobante SET "
                + "codigo_CONT=" + c.getCodigo_CONT()+ ", "
                + "codigo_TCO=" + c.getCodigo_TCO()+ ", "
                + "monto_COMP='" + c.getMonto_COMP()+ ", "
                + "estado_COMP =" + (c.isEstado_COMP()== true ? "1" : "0") + " "
                + " WHERE codigo_COMP=" + c.getCodigo_COMP()+ ";";
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
        String sql = "DELETE FROM comprobante "
                + "WHERE codigo_COMP=" + id + ";";
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
    
    
    public List<Comprobante> buscarNombre(String estado) throws Exception{
        List<Comprobante> comprobante = null;
        Comprobante c = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM servicio WHERE estado_COMP LIKE '%" + estado + "%'");
            
            comprobante = new ArrayList<>();
            while (rs.next() == true){
                c = new Comprobante();
                c.setCodigo_COMP(rs.getInt("codigo_COMP"));
                c.setCodigo_CONT(rs.getInt("codigo_CONT"));
                c.setCodigo_TCO(rs.getInt("codigo_TCO"));
                c.setMonto_COMP(rs.getDouble("monto_COMP"));
                c.setEstado_COMP(rs.getBoolean("estado_COMP"));
                comprobante.add(c);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return comprobante;
    }
}
