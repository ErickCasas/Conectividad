<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Comprobante</title>
    </head>
    <body>
        <h1>Comprobante Nuevo</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="Comprobante?accion=registrar" method="post">
            <div>Codigo Contrato        : <select name="cboContrato">                               
                                    <c:forEach items="${con}" var="contrato"  varStatus="iteracion">
                                        <option value="${contrato.codigo_CONT}">${contrato.fechaInicio_CONT} ${contrato.fechaFin_CONT}</option>
                                    </c:forEach>
                                </select>
            </div>
            <div>Codigo Tipo Comprobante: <select name="cboTipoComprobante">                                 
                                    <c:forEach items="${tco}" var="tipocomprobante"  varStatus="iteracion">
                                        <option value="${tipocomprobante.codigo_TCO}">${tipocomprobante.descripcion_TCO}</option>
                                    </c:forEach>
                                </select>
            <div>Codigo Contrato        :  <input type="text" name="txtContrato" value="${comprobante.codigo_COMP}"></div>
            <div>Codigo Tipo Comprobante: <input type="text" name="txtTipoComprobante" value="${comprobante.codigo_TCO}"></div>
            <div>Monto                  : <input type="text" name="txtMonto" value="${comprobante.monto_COMP}"></div>
      
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
