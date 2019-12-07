<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTRATO NUEVO</title>
    </head>
    <body>
        <h1>Contrato Nuevo</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="Contrato?accion=registrar" method="post">
            <div>CODIGO DE CLIENTE : <input type="text" name="cboCodigoCliente" value="${Contrato.codigo_C}"></div>
            <div>CODIGO DE SERVICIO: <input type="text" name="cboCodigoServicio" value="${Contrato.codigo_S}"></div>
            <div>FECHA DE INICIO   : <input type="text" name="txtFechaInicio" value="${Contrato.fechaInicio_CONT}"></div>
            <div>FECHA FIN         : <input type="text" name="txtFechaFin" value="${Contrato.fechaFin_CONT}"></div>
            <div>TIPO DE CONTRATO  : <input type="text" name="cboTipoContrato" value="${Contrato.tipoContrato_CONT}"></div>
            
            
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
