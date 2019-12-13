package Servlets;

import java.io.IOException;
import dao.DAOCliente;
import entidades.Cliente;
import dao.DAOTipoCliente;
import entidades.TipoCliente;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SrvCliente", urlPatterns = {"/Cliente"})
public class SrvCliente extends HttpServlet {
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
                this.crearBuscar(request, response); 
                break;            
            case "buscar":
                this.buscar(request, response); 
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
        DAOCliente dao = new DAOCliente();
        List<Cliente> clientes = null;
              
        try {
            clientes = dao.listar();
            request.setAttribute("cli", clientes);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/cliente.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar los clientes");
        }
    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoCliente dao = new DAOTipoCliente();
        List<TipoCliente> lista = null;
        
        try {
            lista = dao.listar();
            request.setAttribute("tipoC", lista);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/clientenuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar el formulario");
        }
    }

    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOCliente dao;
        Cliente cl;
        try {
            dao = new DAOCliente();
            int id = Integer.parseInt(request.getParameter("id"));
            cl = dao.leer(id);
            request.setAttribute("Cliente", cl);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarcliente.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar las mascotas");
        }
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        DAOCliente dao;
        Cliente cl;
        cl = this.recuperarCliente(request);
        dao = new DAOCliente();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            cl.setCodigo_C(id);
            dao.modificar(cl);
            response.sendRedirect("Cliente?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo modificar");
            request.setAttribute("cliente", cl);
            this.presentarFormulario(request, response);
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOCliente dao;
        Cliente cl;
        
        cl = this.recuperarCliente(request);
        dao = new DAOCliente();
        try {
            dao.registrar(cl);
            response.sendRedirect("Cliente?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("cliente", cl);
            
            this.presentarFormulario(request, response);
        }   
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOCliente dao;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao = new DAOCliente();
            dao.eliminar(id);
            response.sendRedirect("Cliente?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");
            this.presentarFormulario(request, response);
        }
    }

    private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
            getRequestDispatcher("/WEB-INF/paginas/buscarCliente.jsp").
            forward(request, response);
                         
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar la categoria");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        DAOCliente dao = new DAOCliente();
        List<Cliente> clientes = null;
        String nroDoc;
        
        request.setAttribute("nroDocCl", request.getParameter("txtBuscar"));
        nroDoc = String.valueOf(request.getAttribute("nroDocCl"));
        try {
            clientes = dao.buscarNroDocumento(nroDoc);
            //este se usa pa enviar datos a editarPersona.jsp
            request.setAttribute("cli", clientes);  
            request.setAttribute("ban", nroDoc);  
            crearBuscar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("Error", "No se pudo encontrar el cliente");
        }  
    }

    private Cliente recuperarCliente(HttpServletRequest request) {
        Cliente cl = new Cliente();
        cl.setCodigo_TC(Integer.parseInt(request.getParameter("cboTipoCliente")));
        cl.setNroDocumento_C(request.getParameter("txtNroDocumento"));
        cl.setNombre_C(request.getParameter("txtNombre"));
        cl.setApellido_C(request.getParameter("txtApellido"));
        cl.setDireccion_C(request.getParameter("txtDireccion"));
        cl.setTelefono_C(request.getParameter("txtTelefono"));
        if(request.getParameter("chkEstado")!= null){
            cl.setEstado_C(true);
        }else{
            cl.setEstado_C(false);
        }
        return cl;
    }
}
