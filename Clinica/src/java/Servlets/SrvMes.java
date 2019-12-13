package Servlets;

import dao.DAOMes;
import entidades.Mes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvMes", urlPatterns = {"/Mes"})
public class SrvMes extends HttpServlet {
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
        DAOMes dao = new DAOMes();
        List<Mes> mes = null;
              
        try {
            mes = dao.listar();
            request.setAttribute("mes", mes);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/mes.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar los meses");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/mesnuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOMes dao;
        Mes mes;
        
        mes = this.recuperarMes(request);
        dao = new DAOMes();
        try {
            dao.registrar(mes);
            response.sendRedirect("Mes?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("mes", mes);
            
            this.presentarFormulario(request, response);
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOMes dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOMes();
            dao.eliminar(id);
            response.sendRedirect("Mes?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    private Mes recuperarMes(HttpServletRequest request) {
        Mes mes = new Mes();
        mes.setCodigo_CONT(Integer.parseInt(request.getParameter("txtContrato")));
        mes.setIntervaloT_M(request.getParameter("txtIntervalo"));
        mes.setFechaInicio_M(request.getParameter("txtFechaInicio"));
        mes.setFechaFin_M(request.getParameter("txtFechaFin"));
        if(request.getParameter("chkEstado")!= null){
            mes.setVigencia_M(true);
        }else{
            mes.setVigencia_M(false);
        }
        mes.setObservacion_M(request.getParameter("txtObservacion"));
        mes.setCosto_M(Double.parseDouble(request.getParameter("txtCosto")));
        return mes;
    }

}
