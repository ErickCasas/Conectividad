package Servlets;

import dao.DAOComprobante;
import entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvMascota", urlPatterns = {"/medico"})
public class SrvMedico extends HttpServlet {
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
            case "crearBuscar": this.crearBuscar(request, response); 
                            break;            
            case "buscar": this.buscar(request, response); 
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
        DAOComprobante dao = new DAOComprobante();
        List<Medico> medicos = null;
              
        try {
            medicos = dao.listar();
            request.setAttribute("med", medicos);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/medico.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar las mascotas");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/mediconueva.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao;
        Medico me;
        try {
            dao = new DAOComprobante();
            int id = Integer.parseInt(request.getParameter("id"));
            me = dao.leer(id);
            request.setAttribute("medico", me);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarmedico.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar las mascotas");
        }

    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao;
        Medico me;
        me = this.recuperarMedico(request);
        dao = new DAOComprobante();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            me.setCodigo(id);
            dao.modificar(me);
            response.sendRedirect("medico?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo modificar");
            request.setAttribute("medico", me);
            this.presentarFormulario(request, response);
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao;
        Medico me;
        
        me = this.recuperarMedico(request);
        dao = new DAOComprobante();
        try {
            dao.registrar(me);
            response.sendRedirect("medico?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("medico", me);
            
            this.presentarFormulario(request, response);
        }   
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOComprobante();
            dao.eliminar(id);
            response.sendRedirect("medico?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
            getRequestDispatcher("/WEB-INF/paginas/buscarMedico.jsp").
            forward(request, response);
                         
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar la categoria");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        DAOComprobante dao = new DAOComprobante();
        List<Medico> medicos = null;
        String nombre;
        
        request.setAttribute("nombreMe", request.getParameter("txtBuscar"));
        nombre = String.valueOf(request.getAttribute("nombreMe"));
        try {
            medicos = dao.buscarNombre(nombre);
            //este se usa pa enviar datos a editarPersona.jsp
            request.setAttribute("med", medicos);  
            request.setAttribute("ban", nombre);  
            crearBuscar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("Error", "No se pudo encontrar la mascota");
        }  
    }

    private Medico recuperarMedico(HttpServletRequest request) {
        Medico me = new Medico();
        me.setNombre(request.getParameter("txtNombre"));
        me.setApellidoP(request.getParameter("txtApellidoP"));
        me.setApellidoM(request.getParameter("txtApellidoM"));
        me.setDNI(request.getParameter("txtDNI"));
        me.setCMP(request.getParameter("txtCMP"));
        me.setEspecialidad(request.getParameter("txtEspecialidad"));
        
        if(request.getParameter("chkVigencia")!= null){
            me.setVigencia(true);
        }else{
            me.setVigencia(false);
        }
        return me;
    }
}