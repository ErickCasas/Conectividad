package Servlets;

import dao.DAOComprobante;
import entidades.Comprobante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvComprobante", urlPatterns = {"/Comprobante"})
public class SrvComprobante extends HttpServlet {
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
        DAOComprobante dao = new DAOComprobante();
        List<Comprobante> comprobante = null;
              
        try {
            comprobante = dao.listar();
            request.setAttribute("com", comprobante);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/comprobante.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar los comprobantes");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/comprobantenuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    /*private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao;
        Comprobante cl;
        try {
            dao = new DAOComprobante();
            int id = Integer.parseInt(request.getParameter("id"));
            cl = dao.leer(id);
            request.setAttribute("Comprobante", cl);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarcomprobante.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los comprobantes");
        }
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        
    }*/

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao;
        Comprobante com;
        
        com = this.recuperarCliente(request);
        dao = new DAOComprobante();
        try {
            dao.registrar(com);
            response.sendRedirect("Comprobante?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("comprobante", com);
            
            this.presentarFormulario(request, response);
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOComprobante();
            dao.eliminar(id);
            response.sendRedirect("Comprobante?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    /*private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        
    }*/

    private Comprobante recuperarCliente(HttpServletRequest request) {
        Comprobante com = new Comprobante();
        com.setCodigo_CONT(Integer.parseInt(request.getParameter("txtContrato")));
        com.setCodigo_TCO(Integer.parseInt(request.getParameter("txtTipoContrato")));
        com.setMonto_COMP(Double.parseDouble(request.getParameter("txtMonto")));
        if(request.getParameter("chkEstado")!= null){
            com.setEstado_COMP(true);
        }else{
            com.setEstado_COMP(false);
        }
        return com;    
    }
}
