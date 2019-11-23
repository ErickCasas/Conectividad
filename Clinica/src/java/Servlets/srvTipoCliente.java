/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dao.DAOComprobante;
import dao.DAOTipoCliente;
import entidades.TipoCliente;
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
@WebServlet(name = "srvTipoCliente", urlPatterns = {"/TipoCliente"})
public class srvTipoCliente extends HttpServlet {

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
        DAOTipoCliente dao = new DAOTipoCliente();
        List<TipoCliente> TipoCliente = null;
              
        try {
            TipoCliente = dao.listar();
            request.setAttribute("TC", TipoCliente);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/TipoCliente.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar el tipo cliente");
        }
    }

        private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/tipoClienteNuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

         private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoCliente dao;
        TipoCliente TC;
        try {
            dao = new DAOTipoCliente();
            int id = Integer.parseInt(request.getParameter("id"));
            TC = dao.leer(id);
            request.setAttribute("TipoCliente", TC);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarTipoCliente.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los tipo cliente");
        }

    }

        private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoCliente dao;
        TipoCliente TC;
        TC = this.recuperarTipoCliente(request);
        dao = new DAOTipoCliente();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            TC.setCodigo_TC(id);
            dao.modificar(TC);
            response.sendRedirect("TipoCliente?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo modificar");
            request.setAttribute("TipoCliente", TC);
            this.presentarFormulario(request, response);
        }
    }

        
        
      private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoCliente dao;
        TipoCliente TC;
        
        TC = this.recuperarTipoCliente(request);
        dao = new DAOTipoCliente();
        try {
            dao.registrar(TC);
            response.sendRedirect("TipoCliente?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("TipoCliente", TC);
            
            this.presentarFormulario(request, response);
        }   
    } 
      
           
      private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoCliente dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOTipoCliente();
            dao.eliminar(id);
            response.sendRedirect("TipoCliente?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }
        

 private TipoCliente recuperarTipoCliente(HttpServletRequest request) {
        TipoCliente TC = new TipoCliente();
        TC.setCodigo_TC(Integer.parseInt(request.getParameter("txtCodigo")));
        TC.setDescripcion_TC(request.getParameter("txtDescripcion"));
        
        
        
        if(request.getParameter("chkEstado")!= null){
            TC.setEstado_TC(true);
        }else{
            TC.setEstado_TC(false);
        }
        return TC;
    }        
        
        
        
}
