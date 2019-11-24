<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Servicio</title>
    </head>
    <body>
        <h1>Buscar Servicio</h1>
        <form action="servicio?accion=buscar" method="post">
            <div>Codigo Servicio: <input type="text" name="txtBuscar" value="${ban}"> </div>
            <div><input type="submit" name="btnBuscar" value="Buscar"> </div>
        </form>
        <br>
        
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Tipo Servicio</td>
                <td>Codigo Proveedor</td>
                <td>Nombre de Servicio</td>
                <td>Descripcion de Servicio/td>
                <td>Precio Servicio</td>     
                <td>Opciones</td>
            </tr>
            <c:forEach items="${ser}" var="servicio"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>  
                <td><c:out value="${servicio.codigo_TS}"
                       default="No se encontró"/></td>
                <td><c:out value="${servicio.codigo_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${servicio.nombre_S}"
                       default="No se encontró"/></td>
                <td><c:out value="${servicio.descripcion_S}"
                       default="No se encontró"/></td>
                <td><c:out value="${servicio.precio_S}"
                       default="No se encontró"/></td>
                
                    <td> <a href="servicio?accion=editar&id=${servicio.codigo_S}" > editar </a> o <a href="servicio?accion=eliminar&id=${sevicio.codigo_S}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
                
        <br><br>
        <div><a href="servicio?accion=listar">Regresar</a></div>
    </body>
</html>
