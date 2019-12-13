package Servlets;

import dao.DAOProveedor;
import dao.DAOServicio;
import dao.DAOTipoServicio;
import entidades.Proveedor;
import entidades.Servicio;
import entidades.TipoServicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "srvServicio", urlPatterns = {"/srvServicio"})
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
        DAOServicio dao = new DAOServicio();
        List<Servicio> servicio = null;
              
        try {
            servicio = dao.listar();
            request.setAttribute("SER", servicio);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/servicio.jsp").
                    forward(request, response);
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
            request.setAttribute("Error", "No se pudo listar la lista de los servicios");
        }
    }
                
    private void presentarFormularioEditar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao;
        Servicio S;
        int id = Integer.parseInt(request.getParameter("id"));
            
        try {
            dao = new DAOServicio();
            S = dao.leer(id);
            request.setAttribute("Servicio", S);
            this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/paginas/editarservicio.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            request.setAttribute("error", "no se pudo listar los servicios");
        }
    }
    
    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {
        DAOTipoServicio dao = new DAOTipoServicio();
        DAOProveedor daoP = new DAOProveedor();
        List<TipoServicio> lista;
        List<Proveedor> listaP;
        try {
            lista = dao.listar();
            listaP = daoP.listar();
            request.setAttribute("tipoS", lista);
            request.setAttribute("proveedor", listaP);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/WEB-INF/paginas/servicioNuevo.jsp").
                    forward(request, response);
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar la lista de servicio");
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao;
        Servicio S;
        
        S = this.recuperarServicio(request);
        dao = new DAOServicio();
        try {
            dao.registrar(S);
            response.sendRedirect("srvServicio?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo registrar.");
            request.setAttribute("Servicio", S);
            
            this.presentarFormulario(request, response);
        }   
    }     
       
    private void modificar(HttpServletRequest request, HttpServletResponse response) {         
        DAOServicio dao;
        Servicio S;
        int id;
        S = this.recuperarServicio(request);
        dao = new DAOServicio();
        try {
            id = Integer.parseInt(request.getParameter("id"));
            S.setCodigo_S(id);
            dao.modificar(S);
            response.sendRedirect("srvServicio?accion=listar");
        }catch(Exception e){
            request.setAttribute("msje", "No se pudo Modificar.");
            request.setAttribute("Servicio", S);
            
            this.presentarFormulario(request, response);
        }   
    }
        
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao;
        int id;
        id = Integer.parseInt(request.getParameter("id"));
        try {
            dao = new DAOServicio();
            dao.cambiarEstado(id);
            response.sendRedirect("srvServicio?accion=listar");
        } catch (Exception e) {
            request.setAttribute("msje", "no se pudo Eliminar");          
        }
    }
        
    private Servicio recuperarServicio(HttpServletRequest request) {
        Servicio S = new Servicio();
        
        S.setCodigo_TS(Integer.parseInt(request.getParameter("cboTipoServicio")));
        S.setCodigo_PR(Integer.parseInt(request.getParameter("cboProveedor")));
        S.setNombre_S(request.getParameter("txtNombre"));
        S.setDescripcion_S(request.getParameter("txtDescripcion"));
        S.setPrecio_S(request.getParameter("txtPrecio"));
            
        return S;
    }

    private void crearBuscar(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().
            getRequestDispatcher("/WEB-INF/paginas/buscarservicio.jsp").
            forward(request, response);                       
        } catch(Exception e){
            request.setAttribute("Error", "No se pudo mostrar los servicios");
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        DAOServicio dao = new DAOServicio();
        List<Servicio> servicio = null;
        String nombre;
        
        request.setAttribute("nombre", request.getParameter("txtBuscar"));
        nombre = String.valueOf(request.getAttribute("nombre"));
        try {
            servicio = dao.buscarNombre(nombre);
            //este se usa pa enviar datos a editarPersona.jsp
            request.setAttribute("ser", servicio);  
            request.setAttribute("ban", nombre);  
            crearBuscar(request, response);          
        } catch (Exception e) {
            request.setAttribute("Error", "No se pudo encontrar el cliente");
        } 
    }
}  
   
  