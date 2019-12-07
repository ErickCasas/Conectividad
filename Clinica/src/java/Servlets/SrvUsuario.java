package Servlets;

import dao.DAOUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvUsuario", urlPatterns = {"/Usuario"})
public class SrvUsuario extends HttpServlet {
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
        DAOUsuario dao = new DAOUsuario();
        List<Usuario> usuario = null;
              
        try {
            usuario = dao.listar();
            request.setAttribute("usu", usuario);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/usuario.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar los usuarios");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/usuarionuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el Proveedor");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOUsuario dao;
        Usuario usu;
        
        usu = this.recuperarUsuario(request);
        dao = new DAOUsuario();
        try {
            dao.registrar(usu);
            response.sendRedirect("Usuario?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("Usuario", usu);
            
            this.presentarFormulario(request, response);
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOUsuario dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOUsuario();
            dao.eliminar(id);
            response.sendRedirect("Usuario?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    private Usuario recuperarUsuario(HttpServletRequest request) {
        Usuario usu = new Usuario();
        usu.setCodigo_TU(Integer.parseInt(request.getParameter("txtTipoUsuario")));
        usu.setCodigo_C(Integer.parseInt(request.getParameter("txtCliente")));
        usu.setCodigo_P(Integer.parseInt(request.getParameter("txtPago")));
        usu.setNombre_U(request.getParameter("txtNombre"));
        usu.setPassword_U(request.getParameter("txtContraseña"));
        if(request.getParameter("chkEstado")!= null){
            usu.setVigencia_U(true);
        }else{
            usu.setVigencia_U(false);
        }
        return usu;
    }
}
