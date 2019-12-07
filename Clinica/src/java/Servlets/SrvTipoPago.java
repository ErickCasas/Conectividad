package Servlets;

import java.io.IOException;
import dao.DAOTipoPago;
import entidades.TipoPago;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SrvTipoPago", urlPatterns = {"/TipoPago"})
public class SrvTipoPago extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        DAOTipoPago dao = new DAOTipoPago();
        List<TipoPago> entidad = null;
              
        try {
            entidad = dao.listar();
            request.setAttribute("tp", entidad);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/tipopago.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar la lista de tipos de pagos");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/tipopago.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar los tipo de pagos");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoPago dao;
        TipoPago tp;
        
        tp = this.recuperarEntidad(request);
        dao = new DAOTipoPago();
        try {
            dao.registrar(tp);
            response.sendRedirect("TipoPago?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("TipoPago", tp);
            
            this.presentarFormulario(request, response);
        }   
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoPago dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOTipoPago();
            dao.eliminar(id);
            response.sendRedirect("Comprobante?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }
    
    private TipoPago recuperarEntidad(HttpServletRequest request) {
        TipoPago tp = new TipoPago();
        
        tp.setDescripcion_TP(request.getParameter("txtDescripcion"));
        
        return tp;
    }
    
}
