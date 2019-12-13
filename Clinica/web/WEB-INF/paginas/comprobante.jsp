<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA DE COMPROBANTES</title>
    </head>
    <body>
        <h1>LISTA DE COMPROBANTES</h1>
        <a href="Comprobante?accion=crear">Nuevo Comprobante</a>       
        <a href="Comprobante?accion=crearBuscar">Buscar Comprobante</a>
      
        <table>
            <tr>
                <td>N° 1</td>
                <td>Fecha Inicio Contrato |</td>
                <td>Tipo Comprobante |</td>
                <td>Monto |</td>
                <td>Estado |</td>
                <td>Opciones</td>
            </tr>
            <c:forEach items="${com}" var="comprobante"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td> 
                <td><c:out value="${comprobante.CONT.fechaInicio_CONT}"
                       default="No se encontró"/></td>
                <td><c:out value="${comprobante.CONT.fechaFin_CONT}"
                       default="No se encontró"/></td>
                <td><c:out value="${comprobante.TCO.descripcion_TCO}"
                       default="No se encontró"/></td>
                <td><c:out value="${comprobante.monto_TCC}"
                       default="No se encontró"/></td>
                
                <td> <a href="comprobante?accion=editar&id=${comprobante.codigo_COMP}" > editar </a> o <a href="comprobante?accion=eliminar&id=${comprobante.codigo_COMP}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
