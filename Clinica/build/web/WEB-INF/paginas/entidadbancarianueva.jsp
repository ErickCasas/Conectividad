<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Entidad Bancaria</title>
    </head>
    <body>
        <h1>Nueva Entidad Bancaria</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="EntidadBancaria?accion=registrar" method="post">
            <div>Nombre    : <input type="text" name="txtNombre" value="${entidadbancaria.nombre_E}"></div>
            <div>Dirección : <input type="text" name="txtDireccion" value="${entidadbancaria.direccion_E}"></div>
            <div>RUC       : <input type="text" name="txtRUC" value="${entidadbancaria.ruc_E}"></div>
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
