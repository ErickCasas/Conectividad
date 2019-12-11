/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import dao.DAOContrato;
import entidades.Contrato;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvContrato", urlPatterns = {"/contrato"})
public class SrvContrato extends HttpServlet {
    
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
            /*case "crearBuscar": this.crearBuscar(request, response); 
                            break;            
            case "buscar": this.buscar(request, response); 
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
        DAOContrato dao = new DAOContrato();
        List<Contrato> contratos = null;
              
        try {
            contratos = dao.listar();
            request.setAttribute("con", contratos);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/contrato.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar las clientes");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/clientenuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOContrato dao;
        Contrato co;
        try {
            dao = new DAOContrato();
            int id = Integer.parseInt(request.getParameter("id"));
            co = dao.leer(id);
            request.setAttribute("contrato", co);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarcontrato.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los contratos");
        }

    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOContrato dao;
        Contrato co;
        co = this.recuperarContrato(request);
        dao = new DAOContrato();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            co.setCodigo_C(id);
            dao.modificar(co);
            response.sendRedirect("contrato?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo modificar");
            request.setAttribute("contrato", co);
            this.presentarFormulario(request, response);
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOContrato dao;
        Contrato co;
        
        co = this.recuperarContrato(request);
        dao = new DAOContrato();
        try {
            dao.registrar(co);
            response.sendRedirect("contrato?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("contrato", co);
            
            this.presentarFormulario(request, response);
        }   
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOContrato dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOContrato();
            dao.eliminar(id);
            response.sendRedirect("contrato?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    /*private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
            getRequestDispatcher("/WEB-INF/paginas/buscarContrato.jsp").
            forward(request, response);
                         
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el contrato");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        DAOContrato dao = new DAOContrato();
        List<Contrato> contratos = null;
        String nroDoc;
        
        request.setAttribute("nroDocCl", request.getParameter("txtBuscar"));
        nroDoc = String.valueOf(request.getAttribute("nroDocCl"));
        try {
            contratos = dao.buscarNroDocumento(nroDoc);
            //este se usa pa enviar datos a editarPersona.jsp
            request.setAttribute("con", contratos);  
            request.setAttribute("ban", nroDoc);  
            crearBuscar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("Error", "No se pudo encontrar el contrato");
        }  
    }*/

    private Contrato recuperarContrato(HttpServletRequest request) {
        Contrato co = new Contrato();
        co.setCodigo_C(Integer.parseInt(request.getParameter("cboCodigoCliente")));
        co.setCodigo_S(Integer.parseInt(request.getParameter("cboCodigoServicio")));
        co.setFechaInicio_CONT(request.getParameter("txtFechaInicio"));
        co.setFechaFin_CONT(request.getParameter("txtFechaFin"));
        co.setTipoContrato_CONT(request.getParameter("cboTipoContrato"));
        if(request.getParameter("chkEstado")!= null){
            co.setEstado_CONT(true);
        }else{
            co.setEstado_CONT(false);
        }
        return co;
    }
}