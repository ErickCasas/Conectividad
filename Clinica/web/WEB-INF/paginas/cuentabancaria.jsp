<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR CUENTA BANCARIA</title>
    </head>
    <body>
        <h1>Lista de Cuentas Bancarias</h1>
        <a href="CuentaBancaria?accion=crear">Nueva Cuenta Bancaria</a>       
        <a href="CuentaBancaria?accion=crearBuscar">Buscar Cuenta Bancaria</a>
        <table>
            <tr>
                <td>N°</td>
                <td>Codigo Proveedor</td>
                <td>Codigo Pago</td>
                <td>Nro Cuenta Bancaria</td>
                <td>Tipo Cuenta Bancaria</td>
                <td>Fecha de Vencimiento</td>
                <td>Clave</td>
                <td>Saldo</td>
            </tr>
            <c:forEach items="${cb}" var="cuentabancaria"  varStatus="iteracion">
                <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${cuentaBancaria.codigo_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${cuentaBancaria.codigo_P}"
                       default="No se encontró"/></td>
                <td><c:out value="${cuentaBancaria.numeroCuenta_B}"
                       default="No se encontró"/></td>
                <td><c:out value="${cuentaBancaria.tipocuenta_B}"
                       default="No se encontró"/></td>
                <td><c:out value="${cuentaBancaria.fechaVencimiento_B}"
                       default="No se encontró"/></td>
                <td><c:out value="${cuentaBancaria.clave_B}"
                       default="No se encontró"/></td>
                <td><c:out value="${cuentaBancaria.saldo_B}"
                       default="No se encontró"/></td>
                
                <td> <a href="CuentaBancaria?accion=editar&id=${cuentabancaria.codigo_B}" > editar </a> o <a href="CuentaBancaria?accion=eliminar&id=${cuentabancaria.codigo_B}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
