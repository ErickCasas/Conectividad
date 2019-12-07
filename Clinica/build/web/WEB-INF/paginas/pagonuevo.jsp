<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NUEVO PAGO</title>
    </head>
    <body>
        <h1>NUEVO PAGO</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="Pago?accion=registrar" method="post">
            <div>Codigo Tipo de Pago    :  <input type="text" name="txtTipoPago" value="${pago.codigo_TP}"></div>
            <div>Codigo Comprobante     : <input type="text" name="txtCodigoComprobante" value="${pago.codigo_COMP}"></div>
            <div>Fecha Comprobante      : <input type="text" name="txtFechaComprobante" value="${pago.fecha_COMP}"></div>
            <div>Total Comprobante      : <input type="text" name="txtTotalComprobante" value="${pago.total_COMP}"></div>

            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
