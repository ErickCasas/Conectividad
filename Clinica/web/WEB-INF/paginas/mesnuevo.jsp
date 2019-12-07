<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Mes</title>
    </head>
    <body>
        <h1>Mes Nuevo</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="Mes?accion=registrar" method="post">
            <div>Codigo Contrato: <input type="text" name="txtContrato" value="${mes.codigo_CONT}"></div>
            <div>Intervalo      : <input type="text" name="txtIntervalo" value="${mes.intervaloT_M}"></div>
            <div>Fecha Inicio   : <input type="text" name="txtFechaInicio" value="${mes.fechaInicio_M}"></div>
            <div>Fecha Fin      : <input type="text" name="txtFechaFin" value="${mes.fechaFin_M}"></div>
            <div>Observacion    : <input type="text" name="txtObservacion" value="${mes.observacion_M}"></div>
            <div>Costo          : <input type="text" name="txCosto" value="${mes.costo_M}"></div>
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
