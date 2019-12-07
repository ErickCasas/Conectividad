<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR TIPO CLIENTES</title>
    </head>
    <body>
        <h1>Lista de Tipo de Clientes</h1>
        <a href="TipoCliente?accion=crear">Nuevo Tipo Cliente</a>       
        <a href="TipoCliente?accion=crearBuscar">Buscar Tipo Cliente</a>
        
        <table>
            <tr>
                <td>N°</td>
                <td>Descripción</td>
            </tr>
            <c:forEach items="${cli}" var="tipocliente"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${tipocliente.descripcion_TC}"
                       default="No se encontró"/></td>
                                
                <td> <a href="TipoCliente?accion=editar&id=${tipocliente.codigo_TC}" > editar </a> o <a href="TipoCliente?accion=eliminar&id=${tipocliente.codigo_TC}" > eliminar </a></td>
            </tr>
            </c:forEach>
    </body>
</html>
