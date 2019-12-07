<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR CLIENTES</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <a href="cliente?accion=crear">Nuevo Cliente</a>       
        <a href="cliente?accion=crearBuscar">Buscar Cliente</a>
      
        <div class="main-card mb-3 card">
           <div class="card-body"><h5 class="card-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Filas de cuadrícula</font></font></h5>
                <form class="">
                     <div class="form-row">
                          <div class="col-md-6">
                              <div class="position-relative form-group"><label for="exampleEmail11" class=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Email</font></font></label><input name="email" id="exampleEmail11" placeholder="with a placeholder" type="email" class="form-control"></div>
                                 </div>
                                    <div class="col-md-6">
                                       <div class="position-relative form-group"><label for="examplePassword11" class=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Contraseña</font></font></label><input name="password" id="examplePassword11" placeholder="password placeholder" type="password" class="form-control"></div>
                                    </div>
                              </div>
         <div class="position-relative form-group"><label for="exampleAddress" class=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Dirección</font></font></label><input name="address" id="exampleAddress" placeholder="1234 Main St" type="text" class="form-control"></div>
             <div class="position-relative form-group"><label for="exampleAddress2" class=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Dirección 2</font></font></label><input name="address2" id="exampleAddress2" placeholder="Apartment, studio, or floor" type="text" class="form-control">
         </div>
        <div class="form-row">
          <div class="col-md-6">
             <div class="position-relative form-group"><label for="exampleCity" class=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Ciudad</font></font></label><input name="city" id="exampleCity" type="text" class="form-control"></div>
        </div>
                                                <div class="col-md-4">
                                                    <div class="position-relative form-group"><label for="exampleState" class=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Estado</font></font></label><input name="state" id="exampleState" type="text" class="form-control"></div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="position-relative form-group"><label for="exampleZip" class=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Cremallera</font></font></label><input name="zip" id="exampleZip" type="text" class="form-control"></div>
                                                </div>
                                            </div>
                                            <div class="position-relative form-check"><input name="check" id="exampleCheck" type="checkbox" class="form-check-input"><label for="exampleCheck" class="form-check-label"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Me echa un vistazo</font></font></label></div>
                                            <button class="mt-2 btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Registrarse</font></font></button>
                                        </form>
                                    </div>
                                </div>
        
        
     
            <c:forEach items="${cli}" var="cliente"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${cliente.codigo_TC}"
                       default="No se encontró"/></td>
                <td><c:out value="${cliente.nroDocumento_C}"
                       default="No se encontró"/></td>
                <td><c:out value="${cliente.nombre_C}"
                       default="No se encontró"/></td>
                <td><c:out value="${cliente.apellido_C}"
                       default="No se encontró"/></td>
                
                <td> <a href="cliente?accion=editar&id=${cliente.codigo_C}" > editar </a> o <a href="cliente?accion=eliminar&id=${cliente.codigo_C}" > eliminar </a></td>
            </tr>
            </c:forEach>
        
    </body>
</html>
