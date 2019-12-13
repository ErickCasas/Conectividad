package Servlets;

import java.io.IOException;
import dao.DAOPago;
import entidades.Pago;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvPago", urlPatterns = {"/Pago"})
public class SrvPago extends HttpServlet {
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
        DAOPago dao = new DAOPago();
        List<Pago> pagos = null;
              
        try {
            pagos = dao.listar();
            request.setAttribute("pg", pagos);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/pago.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar los pagos");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/pagonuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOPago dao;
        Pago pg;
        
        pg = this.recuperarPago(request);
        dao = new DAOPago();
        try {
            dao.registrar(pg);
            response.sendRedirect("Pago?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("pago", pg);
            
            this.presentarFormulario(request, response);
        }   
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOPago dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOPago();
            dao.eliminar(id);
            response.sendRedirect("Cliente?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    private Pago recuperarPago(HttpServletRequest request) {
        Pago pg = new Pago();
        pg.setCodigo_TP(Integer.parseInt(request.getParameter("txtTipoCodigoTipoPago")));
        pg.setCodigo_COMP(Integer.parseInt(request.getParameter("txtCodigoComprobante")));
        pg.setFecha_COMP(request.getParameter("txtFecha"));
        pg.setTotal_COMP(Double.parseDouble(request.getParameter("txtApellido")));
        if(request.getParameter("chkEstado")!= null){
            pg.setEstado_COMP(true);
        }else{
            pg.setEstado_COMP(false);
        }
        return pg;
    }
}
