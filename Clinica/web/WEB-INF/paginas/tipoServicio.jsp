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
        <a href="tiposervicio?accion=crear">Nuevo Tipo Servicio</a>       
        <a href="tiposervicio?accion=crearBuscar">Buscar Tipo Servicio</a>
        
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Tipo Servicio</td>
                <td>Estado</td>    
                <td>Opciones</td>
            </tr>
            <c:forEach items="${ts}" var="tiposervicio"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${tiposervicio.codigo_TS}"
                       default="No se encontró"/></td>
                <td><c:out value="${tiposervicio.descripcion_TS}"
                       default="No se encontró"/></td>
                <td><c:out value="${tiposervicio.estado_TS}"
                       default="No se encontró"/></td>
                
                <td><a href="tiposervicio?accion=editar&id=${tipousuario.codigo_TS}" > editar </a> o <a href="tiposervicio?accion=eliminar&id=${tiposervicio.codigo_TS}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
