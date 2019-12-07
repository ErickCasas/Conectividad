<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Contratos</title>
    </head>
    <body>
        <h1>Lista de Servicios</h1>
        <a href="Contrato?accion=crear">Nuevo Contrato</a>
      
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Cliente</td>
                <td>Codigo Servicio</td>
                <td>Fecha Inicio</td>
                <td>Fecha Fin</td>
                <td>Tipo Contrato</td>     
                <td>Opciones</td>
            </tr>
            <c:forEach items="${con}" var="Contrato"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${contrato.codigo_C}"
                       default="No se encontró"/></td>
                <td><c:out value="${contrato.codigo_S}"
                       default="No se encontró"/></td>
                <td><c:out value="${contrato.fechaInicio_CONT}"
                       default="No se encontró"/></td>
                <td><c:out value="${contrato.fechaFin_CONT}"
                       default="No se encontró"/></td>
                <td><c:out value="${contrato.tipoContrato_CONT}"
                       default="No se encontró"/></td>
                
                <td> <a href="Contrato?accion=editar&id=${contrato.codigo_CONT}" > editar </a> o <a href="Contrato?accion=eliminar&id=${contrato.codigo_CONT}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
