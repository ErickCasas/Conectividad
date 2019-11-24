/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dao.DAOProveedor;
import entidades.Proveedor;
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
@WebServlet(name = "srvProveedor", urlPatterns = {"/srvProveedor"})
public class srvProveedor extends HttpServlet {

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
        DAOProveedor dao = new DAOProveedor();
        List<Proveedor> Proveedor = null;
              
        try {
            Proveedor = dao.listar();
            request.setAttribute("PR", Proveedor);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/Proveedor.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar la lista de los proveedores");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/Proveedor.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el Proveedor");
        }
    }
    
     private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOProveedor dao;
        Proveedor PR;
        try {
            dao = new DAOProveedor();
            int id = Integer.parseInt(request.getParameter("id"));
            PR = dao.leer(id);
            request.setAttribute("Proveedor", PR);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarProveedor.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los Proveedores");
        }

    }
     
     
     private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOProveedor dao;
        Proveedor PR;
        PR = this.recuperarProveedor(request);
        dao = new DAOProveedor();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            PR.setCodigo_PR(id);
            dao.modificar(PR);
            response.sendRedirect("medico?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo modificar");
            request.setAttribute("Proveedor", PR);
            this.presentarFormulario(request, response);
        }
    }
       
    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOProveedor dao;
        Proveedor PR;
        
        PR = this.recuperarProveedor(request);
        dao = new DAOProveedor();
        try {
            dao.registrar(PR);
            response.sendRedirect("Proveedor?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("Proveedor", PR);
            
            this.presentarFormulario(request, response);
        }   
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOProveedor dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOProveedor();
            dao.eliminar(id);
            response.sendRedirect("Proveedor?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }
    
     private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
            getRequestDispatcher("/WEB-INF/paginas/buscarProveedor.jsp").
            forward(request, response);
                         
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar los Proveedores");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        DAOProveedor dao = new DAOProveedor();
        List<Proveedor> Proveedor = null;
        String nombre_PR;
        
        request.setAttribute("nombre_PR", request.getParameter("txtBuscar"));
        nombre_PR = String.valueOf(request.getAttribute("nombre_PR"));
        try {
            Proveedor = dao.buscarNombre(nombre_PR);
            //este se usa pa enviar datos a editarPersona.jsp
            request.setAttribute("PR", Proveedor);  
            request.setAttribute("NPR", nombre_PR);  
            crearBuscar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("Error", "No se pudo encontrar la mascota");
        }  
    }
    
    
       
    private Proveedor recuperarProveedor(HttpServletRequest request) {
        Proveedor PR = new Proveedor();
        
        PR.setRazonSocial_PR(request.getParameter("txtRazonSocial_PR"));
        PR.setNombre_PR(request.getParameter("txtNombre_PR"));
        PR.setRuc_PR(request.getParameter("txtRuc_PR"));
        PR.setDireccion_PR(request.getParameter("txtDireccion_PR"));
        PR.setTelefono_PR(request.getParameter("txtTelefono_PR"));
        
        if(request.getParameter("chkEstado")!= null){
            PR.setEstado_PR(true);
        }else{
            PR.setEstado_PR(false);
        }
        return PR;
    }
}
