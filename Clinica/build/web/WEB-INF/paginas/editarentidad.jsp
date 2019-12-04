<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR ENTIDAD BANCARIA</title>
    </head>
    <body>
        <h1>Editar Entidad Bancaria - ${entidadBancaria.ruc_E}</h1> 
        <c:if test="${msje!=null}">
            <div>${msje}</div>
        </c:if>
        <form action="entidadBancaria?accion=modificar&id=${entidadBancaria.ruc_E}" method="post">
            <div>RUC          : <input type="text" name="txtRuc" value="${entidadBancaria.ruc_E}"></div>
            <div>Nombre       : <input type="text" name="txtNombre" value="${entidadBancaria.nombre_E}"></div>
            <div>Dirección    : <input type="text" name="txtApellido" value="${entidadBancaria.direccion_E}"></div>
            <div><input type="submit" name="btnRegistrar" value="EDITAR"></div>
            
        </form>
    </body>
</html>
