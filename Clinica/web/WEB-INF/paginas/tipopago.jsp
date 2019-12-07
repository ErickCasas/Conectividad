<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR TIPO PAGO</title>
    </head>
    <body>
        <h1>Lista de Tipo de Pagos</h1>
        <a href="TipoPago?accion=crear">Nuevo Tipo Pago</a>       
        <a href="TipoPago?accion=crearBuscar">Buscar Tipo Pago</a>
        
        <table>
            <tr>
                <td>N°</td>
                <td>Descripción</td>
            </tr>
            <c:forEach items="${tp}" var="tipopago"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${tipopago.descripcion_TP}"
                       default="No se encontró"/></td>
                                
                <td> <a href="TipoPago?accion=editar&id=${tipopago.codigo_TP}" > editar </a> o <a href="TipoPago?accion=eliminar&id=${tipopago.codigo_TP}" > eliminar </a></td>
            </tr>
            </c:forEach>
    </body>
</html>
