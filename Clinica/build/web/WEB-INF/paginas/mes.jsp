<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA DEL MES</title>
    </head>
    <body>
        <h1>LISTA DEL MES</h1>
        <a href="Mes?accion=crear">Nuevo Mes</a>       
        <a href="Mes?accion=crearBuscar">Buscar Mes</a>
      
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Contrato/td>
                <td>Intervalo</td>
                <td>Fecha de Inicio</td>
                <td>Fecha Fin</td>
                <td>Costo</td>
                <td>Opciones</td>
            </tr>
            <c:forEach items="${mes}" var="mes"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${mes.codigo_CONT}"
                       default="No se encontró"/></td>
                <td><c:out value="${mes.intervaloT_M}"
                       default="No se encontró"/></td>
                <td><c:out value="${mes.fechaInicio_M}"
                       default="No se encontró"/></td>
                <td><c:out value="${mes.fechaFin_M}"
                       default="No se encontró"/></td>
                <td><c:out value="${mes.observacion_M}"
                       default="No se encontró"/></td>
                <td><c:out value="${mes.costo_M}"
                       default="No se encontró"/></td>
                
                <td> <a href="Mes?accion=editar&id=${mes.codigo_M}" > editar </a> o <a href="Mes?accion=eliminar&id=${Mes.codigo_M}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
