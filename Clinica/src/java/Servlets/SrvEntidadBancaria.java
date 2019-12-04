/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dao.DAOEntidadBancaria;
import entidades.EntidadBancaria;
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
 * @author USUARIO
 */
@WebServlet(name = "SrvEntidadBancaria", urlPatterns = {"/EntidadBancaria"})
public class SrvEntidadBancaria extends HttpServlet {

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
            case "crearBuscar": 
                //this.crearBuscar(request, response); 
                            break;            
            case "buscar": 
                //this.buscar(request, response); 
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
        DAOEntidadBancaria dao = new DAOEntidadBancaria();
        List<EntidadBancaria> entidad = null;
              
        try {
            entidad = dao.listar();
            request.setAttribute("ENT", entidad);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/entidadBancaria.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar la lista de los proveedores");
        }
    }
    
    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao;
        EntidadBancaria PR;
        try {
            dao = new DAOEntidadBancaria();
            int id = Integer.parseInt(request.getParameter("id"));
            PR = dao.leer(id);
            request.setAttribute("Entidad", PR);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarentidadBancaria.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los Proveedores");
        }

    }
    
    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/entidadbancarianueva.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el Proveedor");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao;
        EntidadBancaria ent;
        
        ent = this.recuperarEntidad(request);
        dao = new DAOEntidadBancaria();
        try {
            dao.registrar(ent);
            response.sendRedirect("EntidadBancaria?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("Proveedor", ent);
            
            this.presentarFormulario(request, response);
        }   
    }    
    
    
     private void modificar(HttpServletRequest request, HttpServletResponse response) {
         
       DAOEntidadBancaria dao;
        EntidadBancaria ent;
        int id;
        ent = this.recuperarEntidad(request);
        dao = new DAOEntidadBancaria();
        try {
            id = Integer.parseInt(request.getParameter("id"));
            ent.setCodigo_E(id);
            dao.modificar(ent);
            response.sendRedirect("EntidadBancaria?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo Modificar.");
            request.setAttribute("Proveedor", ent);
            
            this.presentarFormulario(request, response);
        }   

    }
     
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao;
        int id;
        id = Integer.parseInt(request.getParameter("id"));
        try {
            dao = new DAOEntidadBancaria();
            dao.cambiarEstado(id);
            response.sendRedirect("EntidadBancaria?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            
        }
    }
       
    
    private EntidadBancaria recuperarEntidad(HttpServletRequest request) {
        EntidadBancaria PR = new EntidadBancaria();
        
        PR.setNombre_E(request.getParameter("txtNombre"));
        PR.setDireccion_E(request.getParameter("txtDireccion"));
        PR.setRuc_E(request.getParameter("txtRUC"));

        return PR;
    }
}
