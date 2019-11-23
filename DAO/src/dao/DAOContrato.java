package dao;
import accesodatos.conexion;
import entidades.Contrato;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOContrato extends conexion{
    public void registrar(Contrato c) throws Exception {
        String sql = "INSERT INTO contrato( codigo_CONT, codigo_C, codigo_S, fechaInicio_CONT, fechaFin_CONT, tipoContrato_CONT, estado_CONT) "
                + " VALUES ( " + c.getCodigo_C()+ ", " + c.getCodigo_S()
                + ", '" + c.getFechaInicio_CONT()+ "', '" + c.getFechaFin_CONT()+ "','" + c.getTipoContrato_CONT()+ "', "  
                + (c.isEstado_CONT()== true ? "1" : "0") + ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public List<Contrato> listar() throws Exception {
        List<Contrato> contratos = null;
        Contrato c;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT C.codigo_CONT, C.codigo_C, C.codigo_S, C.fechaInicio_CONT, C.fechaFin_CONT "
                    + " FROM contrato C "
                    + "ORDER BY C.codigo_C");
            contratos = new ArrayList<>();
            while (rs.next() == true) {
                c = new Contrato();
                c.setCodigo_CONT(rs.getInt("codigo_CONT"));
                c.setCodigo_C(rs.getInt("codigo_C"));
                c.setCodigo_S(rs.getInt("codigo_S"));
                c.setFechaInicio_CONT(rs.getString("fechaInicio_CONT"));
                c.setFechaFin_CONT(rs.getString("fechaFin_CONT"));
                c.setTipoContrato_CONT(rs.getString("tipoContrato_CONT"));
                c.setEstado_CONT(rs.getBoolean("estado_CONT"));
                contratos.add(c);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return contratos;
    }
    
    public Contrato leer(int id) throws Exception {
        Contrato c = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM contrato "
                    + " WHERE codigo_CONT = " + id + ";");
            while (rs.next() == true) {
                c = new Contrato();
                c.setCodigo_CONT(rs.getInt("codigo_CONT"));
                c.setCodigo_C(rs.getInt("codigo_C"));
                c.setCodigo_S(rs.getInt("codigo_S"));
                c.setFechaInicio_CONT(rs.getString("fechaInicio_CONT"));
                c.setFechaFin_CONT(rs.getString("fechaFin_CONT"));
                c.setTipoContrato_CONT(rs.getString("tipoContrato_CONT"));
                c.setEstado_CONT(rs.getBoolean("estado_CONT"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return c;
    }
    
    public void modificar(Contrato c) throws Exception {
        String sql = "UPDATE cliente SET "
                + "codigo_C=" + c.getCodigo_C() + ", "
                + "codigo_S=" + c.getCodigo_S() + ", "
                + "fechaInicio_CONT='" + c.getFechaInicio_CONT()+ "', "
                + "fechaFin_CONT='" + c.getFechaFin_CONT()+ "', "
                + "tipoContrato_CONT='" + c.getTipoContrato_CONT()+ "', "
                + "estado_CONT =" + (c.isEstado_CONT()== true ? "1" : "0") + " "
                + " WHERE codigo_C=" + c.getCodigo_C()+ ";";
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
        String sql = "DELETE FROM contrato "
                + "WHERE codigo_CONT=" + id + ";";
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
    
    public List<Contrato> buscarNombre(String codigo) throws Exception{
        List<Contrato> contratos = null;
        Contrato c = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM contrato WHERE codigo_CONT LIKE '%" + codigo + "%'");
            
            contratos = new ArrayList<>();
            while (rs.next() == true){
                c = new Contrato();
                c.setCodigo_CONT(rs.getInt("codigo_CONT"));
                c.setCodigo_C(rs.getInt("codigo_C"));
                c.setCodigo_S(rs.getInt("codigo_S"));
                c.setFechaInicio_CONT(rs.getString("fechaInicio_CONT"));
                c.setFechaFin_CONT(rs.getString("fechaFin_CONT"));
                contratos.add(c);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return contratos;
    }
}
