<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <h1>Lista de Usuarios</h1>
        <a href="Usuario?accion=crear">Nuevo Servicio</a>       
        <a href="Usuario?accion=crearBuscar">Buscar Servicio</a>
      
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Tipo Usuario</td>
                <td>Codigo Cliente</td>
                <td>Codigo Pago</td>
                <td>Nombre</td>
                <td>Contraseña</td>     
                <td>Opciones</td>
            </tr>
            <c:forEach items="${usu}" var="usuario"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${usuario.codigo_TU}"
                       default="No se encontró"/></td>
                <td><c:out value="${usuario.codigo_C}"
                       default="No se encontró"/></td>
                <td><c:out value="${usuario.codigo_P}"
                       default="No se encontró"/></td>
                <td><c:out value="${usuario.nombre_U}"
                       default="No se encontró"/></td>
                <td><c:out value="${usuario.contraseña_U}"
                       default="No se encontró"/></td>
                
                <td> <a href="Usuario?accion=editar&id=${usuario.codigo_U}" > editar </a> o <a href="Usuario?accion=eliminar&id=${usuario.codigo_U}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
