
package Servlets;

import java.io.IOException;
import dao.DAOCuentaBancaria;
import entidades.CuentaBancaria;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvCuentaBancaria", urlPatterns = {"/CuentaBancaria"})
public class SrvCuentaBancaria extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch(accion){
            case "listar": 
                this.listar(request, response);
                break;
            case "crear": 
                this.presentarFormulario(request, response);
                break;
            /*case "editar":
                this.presentarFormularioEditar(request, response);
                break;
            case "modificar":
                this.modificar(request, response);
                break;*/
            case "registrar": 
                this.registrar(request, response);
                break;
            case "eliminar":
                this.eliminar(request, response);
                break;
            /*case "crearBuscar":
                this.crearBuscar(request, response); 
                break;            
            case "buscar":
                this.buscar(request, response); 
                break;*/
        }    
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        DAOCuentaBancaria dao = new DAOCuentaBancaria();
        List<CuentaBancaria> cuentasbancarias = null;
              
        try {
            cuentasbancarias = dao.listar();
            request.setAttribute("cb", cuentasbancarias);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/cuentabancaria.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar las cuentas bancarias");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/cuentabancarianuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOCuentaBancaria dao;
        CuentaBancaria cb;
        
        cb = this.recuperarCuentaBancaria(request);
        dao = new DAOCuentaBancaria();
        try {
            dao.registrar(cb);
            response.sendRedirect("CuentaBancaria?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("CuentaBancaria", cb);
            
            this.presentarFormulario(request, response);
        }   
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
         DAOCuentaBancaria dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOCuentaBancaria();
            dao.eliminar(id);
            response.sendRedirect("CuentaBancaria?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }
    
    private CuentaBancaria recuperarCuentaBancaria(HttpServletRequest request) {
        CuentaBancaria cb = new CuentaBancaria();
        cb.setCodigo_PR(Integer.parseInt(request.getParameter("txtCodigoProveedor")));
        cb.setCodigo_P(Integer.parseInt(request.getParameter("txtCodigoPago")));
        cb.setNumeroCuenta_B(request.getParameter("txtNumeroCuenta"));
        cb.setTipoCuenta_B(request.getParameter("txtTipoCuenta"));
        cb.setFechaVencimiento_B(request.getParameter("txtFechaVencimiento"));
        cb.setClave_B(request.getParameter("txtClave"));
        cb.setSaldo_B(Double.parseDouble(request.getParameter("txtSaldo")));
        if(request.getParameter("chkEstado")!= null){
            cb.setEstado_B(true);
        }else{
            cb.setEstado_B(false);
        }
        return cb;
    }
}
