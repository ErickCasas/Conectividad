<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NUEVA CUENTA BANCARIA</title>
    </head>
    <body>
        <h1>NUEVA CUENTA BANCARIA</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="CuentaBancaria?accion=registrar" method="post">
            <div>Codigo Proveedor       :  <input type="text" name="txtCodigoProveedor" value="${cuentabancaria.codigo_PR}"></div>
            <div>Codigo Pago            : <input type="text" name="txtCodigoPago" value="${cuentabancaria.codigo_P}"></div>
            <div>Nro Cuenta Bancaria    : <input type="text" name="txtNroCuentaBancaria" value="${cuentabancaria.numeroCuenta_B}"></div>
            <div>Tipo Cuenta Bancaria   : <input type="text" name="txtTipoCuentaBancaria" value="${cuentabancaria.tipocuenta_B}"></div>
            <div>Fecha de Vencimiento   : <input type="text" name="txtFechaVencimiento" value="${cuentabancaria.fechaVencimiento_B}"></div>
            <div>Clave                  : <input type="text" name="txtClave" value="${cuentabancaria.clave_B}"></div>
            <div>Saldo                  : <input type="text" name="txtSaldo" value="${cuentabancaria.saldo_B}"></div>
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
