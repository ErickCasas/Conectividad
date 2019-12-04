<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo Usuario</title>
    </head>
    <body>
        <h1>Tipo Usuario</h1>
        <a href="tipousuario?accion=crear">Nuevo Tipo Usuario</a>       
        <a href="tipousuario?accion=crearBuscar">Buscar Tipo Usuario</a>
        
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Tipo Usuario</td>
                <td>Estado</td>    
                <td>Opciones</td>
            </tr>
            <c:forEach items="${tu}" var="tipousuario"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${tipousuario.codigo_TU}"
                       default="No se encontró"/></td>
                <td><c:out value="${tipousuario.descripcion_TU}"
                       default="No se encontró"/></td>
                <td><c:out value="${tipousuario.estado_TU}"
                       default="No se encontró"/></td>
                
                <td><a href="tipousuario?accion=editar&id=${tipousuario.codigo_TU}" > editar </a> o <a href="tipousuario?accion=eliminar&id=${tipousuario.codigo_TU}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
