/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import dao.DAOEntidadBancaria;
import entidades.EntidadBancaria;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author STEVEN ANTONY
 */
@WebServlet(name = "SrvEntidadBancaria", urlPatterns = {"/entidadBancaria"})
public class SrvEntidadBancaria extends HttpServlet {
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
        DAOEntidadBancaria dao = new DAOEntidadBancaria();
        List<EntidadBancaria> entidades = null;
              
        try {
            entidades = dao.listar();
            request.setAttribute("ent", entidades);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/entidades.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar las entidades bancarias.");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/entidadnueva.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao;
        EntidadBancaria eb;
        try {
            dao = new DAOEntidadBancaria();
            int id = Integer.parseInt(request.getParameter("id"));
            eb = dao.leer(id);
            request.setAttribute("entidadBancaria", eb);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarentidad.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar las entidades");
        }

    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao;
        EntidadBancaria eb;
        eb = this.recuperarEntidadBancaria(request);
        dao = new DAOEntidadBancaria();
        try {
            String id = request.getParameter("id");
            eb.setRuc_E(id);
            dao.modificar(eb);
            response.sendRedirect("entidadBancaria?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo modificar");
            request.setAttribute("entidadBancaria", eb);
            this.presentarFormulario(request, response);
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao;
        EntidadBancaria eb;
        
        eb = this.recuperarEntidadBancaria(request);
        dao = new DAOEntidadBancaria();
        try {
            dao.registrar(eb);
            response.sendRedirect("entidadBancaria?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("entidadBancaria", eb);
            
            this.presentarFormulario(request, response);
        }   
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOEntidadBancaria();
            dao.eliminar(id);
            response.sendRedirect("entidadBancaria?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
            getRequestDispatcher("/WEB-INF/paginas/buscarEntidad.jsp").
            forward(request, response);
                         
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar la categoria");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        DAOEntidadBancaria dao = new DAOEntidadBancaria();
        List<EntidadBancaria> entidades = null;
        String ruc_E;
        
        request.setAttribute("ruc_E", request.getParameter("txtBuscar"));
        ruc_E = String.valueOf(request.getAttribute("ruc_E"));
        try {
            entidades = dao.buscarRucEntidadBancaria(ruc_E);
            //este se usa pa enviar datos a editarPersona.jsp
            request.setAttribute("ent", entidades);  
            request.setAttribute("ban", ruc_E);  
            crearBuscar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("Error", "No se pudo encontrar el entidad bancaria");
        }  
    }

    private EntidadBancaria recuperarEntidadBancaria(HttpServletRequest request) {
        EntidadBancaria eb = new EntidadBancaria();
        eb.setNombre_E(request.getParameter("txtNombre"));
        eb.setDireccion_E(request.getParameter("txtDireccion"));
        eb.setRuc_E(request.getParameter("txtRuc"));
        return eb;
    }
}
