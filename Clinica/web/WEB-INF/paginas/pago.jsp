<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR PAGOS</title>
    </head>
    <body>
        <h1>Lista de Pagos</h1>
        <a href="Pago?accion=crear">Nuevo Pago</a>       
        <a href="Pago?accion=crearBuscar">Buscar Pago</a>
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Tipo de Pago</td>
                <td>Codigo Comprobante</td>
                <td>Fecha Comprobante</td>
                <td>Total Comprobante</td>
            </tr>
            <c:forEach items="${cb}" var="pago"  varStatus="iteracion">
                <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${pago.codigo_TP}"
                       default="No se encontró"/></td>
                <td><c:out value="${pago.codigo_COMP}"
                       default="No se encontró"/></td>
                <td><c:out value="${pago.fecha_COMP}"
                       default="No se encontró"/></td>
                <td><c:out value="${pago.total_COMP}"
                       default="No se encontró"/></td>
                
                <td> <a href="Pago?accion=editar&id=${pago.codigo_P}" > editar </a> o <a href="Pago?accion=eliminar&id=${pago.codigo_P}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
