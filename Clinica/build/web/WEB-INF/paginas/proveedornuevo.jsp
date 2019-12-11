<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedor Nuevo</title>
    </head>
    <body>
        <h1>Proveedor NuevoS</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="Proveedor?accion=registrar" method="post">
            <div>Razon Social : <input type="text" name="txtRazonSocial" value="${proveedor.razonSocial_PR}"></div>
            <div>Nombre       : <input type="text" name="txtNombre" value="${proveedor.nombre_PR}"></div>
            <div>RUC          : <input type="text" name="txtRuc" value="${proveedor.ruc_PR}"></div>
            <div>Dirección    : <input type="text" name="txtDireccion" value="${proveedor.direccion_PR}"></div>
            <div>Teléfono     : <input type="text" name="txtTelefono" value="${proveedor.telefono_PR}"></div>
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
