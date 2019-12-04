package Servlets;

import dao.DAOTipoUsuario;
import entidades.TipoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvTipoUsuario", urlPatterns = {"/TipoUsuario"})
public class SrvTipoUsuario extends HttpServlet {
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
            case "editar":
                this.presentarFormularioEditar(request, response);
                break;
            case "modificar":
                this.modificar(request, response);
                break;
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
        DAOTipoUsuario dao = new DAOTipoUsuario();
        List<TipoUsuario> entidad = null;
              
        try {
            entidad = dao.listar();
            request.setAttribute("tu", entidad);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/tipoUsuario.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar la lista de tipos de usuarios");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/tipousuarionuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar los tipo de usuarios");
        }
    }

    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoUsuario dao;
        TipoUsuario tu;
        int id = Integer.parseInt(request.getParameter("id"));
            
        try {
            dao = new DAOTipoUsuario();
            tu = dao.leer(id);
            request.setAttribute("TipoUsuario", tu);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editartipousuario.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los tipos de usuarios");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoUsuario dao;
        TipoUsuario tu;
        
        tu = this.recuperarEntidad(request);
        dao = new DAOTipoUsuario();
        try {
            dao.registrar(tu);
            response.sendRedirect("TipoUsuario?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("Proveedor", tu);
            
            this.presentarFormulario(request, response);
        }   
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoUsuario dao;
        TipoUsuario tu;
        int id;
        tu = this.recuperarEntidad(request);
        dao = new DAOTipoUsuario();
        try {
            id = Integer.parseInt(request.getParameter("id"));
            tu.setCodigo_TU(id);
            dao.modificar(tu);
            response.sendRedirect("TipoUsuario?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo Modificar");
            request.setAttribute("Proveedor", tu);
            
            this.presentarFormulario(request, response);
        }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoUsuario dao;
        int id;
        id = Integer.parseInt(request.getParameter("id"));
        try {
            dao = new DAOTipoUsuario();
            dao.cambiarEstado(id);
            response.sendRedirect("EntidadBancaria?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");          
        }
    }

    private TipoUsuario recuperarEntidad(HttpServletRequest request) {
        TipoUsuario tu = new TipoUsuario();
        
        tu.setDescripcion_TU(request.getParameter("txtDescripcion"));
        
        return tu;
    }
}
