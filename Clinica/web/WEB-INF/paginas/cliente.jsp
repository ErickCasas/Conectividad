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
      
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Tipo Cliente</td>
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
                
                    <td> <a href="cliente?accion=editar&id=${cliente.codigo_C}" > editar </a> o <a href="cliente?accion=eliminar&id=${cliente.codigo_C}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
