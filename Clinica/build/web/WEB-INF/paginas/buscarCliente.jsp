<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUSCAR CLIENTE</title>
    </head>
    <body>
        <h1>INGRESE NOMBRE DEL CLIENTE A BUSCAR</h1>
        <form action="cliente?accion=buscar" method="post">
            <div>Nro Documento: <input type="text" name="txtBuscar" value="${ban}"> </div>
            <div><input type="submit" name="btnBuscar" value="Buscar"> </div>
        </form>
        <br>
        
        <table>
            <tr>
                <td>N°</td>
                <td>Nro Documento</td>
                <td>Nombre</td>
                <td>Apellidos</td>     
                <td>Opciones</td>
            </tr>
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
                
                    <td> <a href="cliente?accion=editar&id=${cliente.nroDocumento_C}" > editar </a> o <a href="cliente?accion=eliminar&id=${cliente.nroDocumento_C}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
                
        <br><br>
        <div><a href="Cliente?accion=listar">Regresar</a></div>
    </body>
</html>
