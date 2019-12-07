<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Servicio Nuevo</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="srvServicio?accion=registrar" method="post">
            <div>CODIGO TS    : <input type="text" name="txtTipoServicio" value="${servicio.codigo_TS}"></div>
            <div>CODIGO PR    : <input type="text" name="txtProveedor" value="${servicio.codigo_PR}"></div>
            <div>NOMBRE       : <input type="text" name="txtNombre" value="${servicio.nombre_S}"></div>
            <div>DESCRIPCION  : <input type="text" name="txtDescripcion" value="${servicio.descripcion_S}"></div>
            <div>PRECIO       : <input type="text" name="txtPrecio" value="${servicio.precio_S}"></div>
                        
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
