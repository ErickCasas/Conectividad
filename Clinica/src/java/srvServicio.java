/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.DAOServicio;
import entidades.Servicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lorena
 */
@WebServlet(urlPatterns = {"/srvServicio"})
public class srvServicio extends HttpServlet {

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
        DAOServicio dao = new DAOServicio();
        List<Servicio> Servicio = null;
              
        try {
            Servicio = dao.listar();
            request.setAttribute("S", Servicio);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/servicio.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar los servicios");
        }
    }
    

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/nuevoServicio.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }
    
    
    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao;
        Servicio S;
        try {
            dao = new DAOServicio();
            int id = Integer.parseInt(request.getParameter("id"));
            S = dao.leer(id);
            request.setAttribute("Servicio", S);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarServicio.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los servicios");
        }

    }
    
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao;
        Servicio S;
        S = this.recuperarServicio(request);
        dao = new DAOServicio();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            S.setCodigo_S(id);
            dao.modificar(S);
            response.sendRedirect("servicio?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo modificar");
            request.setAttribute("servicio", S);
            this.presentarFormulario(request, response);
        }
    }
    
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao;
        Servicio S;
        
        S = this.recuperarServicio(request);
        dao = new DAOServicio();
        try {
            dao.registrar(S);
            response.sendRedirect("Servicio?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("Servicio", S);
            
            this.presentarFormulario(request, response);
        }   
    }
    
     private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOServicio();
            dao.eliminar(id);
            response.sendRedirect("Servicio?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }
    
     private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
            getRequestDispatcher("/WEB-INF/paginas/buscarServicio.jsp").
            forward(request, response);
                         
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el Servicio");
        }
    }
     
     
     private void buscar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao = new DAOServicio();
        List<Servicio> Servicio = null;
        String nombre;
        
        request.setAttribute("nombre_S", request.getParameter("txtBuscar"));
        nombre = String.valueOf(request.getAttribute("nombre_S"));
        try {
            Servicio = dao.buscarNombre(nombre);
            //este se usa pa enviar datos a editarPersona.jsp
            request.setAttribute("S", Servicio);  
            request.setAttribute("ban", nombre);  
            crearBuscar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("Error", "No se pudo encontrar el servicio");
        }  
    }
     
     private Servicio recuperarServicio(HttpServletRequest request) {
        Servicio S = new Servicio();
        S.setCodigo_S(Integer.getInteger(request.getParameter("txtCodigo_S")));
        S.setCodigo_TS(Integer.getInteger(request.getParameter("txtCodigo_TS")));
        S.setCodigo_TS(Integer.getInteger(request.getParameter("txtCodigo_PR")));
        S.setNombre_S(request.getParameter("txtNombre_S"));
        S.setDescripcion_S(request.getParameter("txtDescripcion_S"));
        S.setPrecio_S(request.getParameter("txtPrecio_S"));
        
        if(request.getParameter("chkEstado")!= null){
            S.setEstado(true);
        }else{
            S.setEstado(false);
        }
        return S;
    }
     
}
