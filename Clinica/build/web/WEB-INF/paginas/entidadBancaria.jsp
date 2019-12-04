<%-- 
    Document   : entidadBancaria
    Created on : 03-dic-2019, 17:31:23
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Entidad Bancaria</h1>
        
        
         <a href="EntidadBancaria?accion=crear">Nueva Entidad Bancaria</a>      
      
        <table>
            <tr>
                <td>N°</td>
                
                <td>Ruc</td>
                <td>Nombre</td>
                <td>Direccion</td>
            </tr>
           
            <c:forEach items="${ENT}" var="entidadBancaria"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                
                <td><c:out value="${entidadBancaria.ruc_E}"
                       default="No se encontró"/></td>
                <td><c:out value="${entidadBancaria.nombre_E}"
                       default="No se encontró"/></td>
                <td><c:out value="${entidadBancaria.direccion_E}"
                       default="No se encontró"/></td>
                
                    <td> <a href="EntidadBancaria?accion=editar&id=${entidadBancaria.codigo_E}" > editar </a> o <a href="EntidadBancaria?accion=eliminar&id=${entidadBancaria.codigo_E}" > Cambiar Estado </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
