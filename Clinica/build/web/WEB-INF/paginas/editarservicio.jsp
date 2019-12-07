<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Servicio</title>
    </head>
    <body>
        <h1>Editar Servicio - ${Servicio.codigo_S}</h1>
        <c:if test="${msje!=null}">
            <div>${msje}</div>
        </c:if>
        <form action="srvServicio?accion=modificar&id=${Servicio.codigo_S}" method="post">
            <div>Codigo Tipo Servicio : <input type="text" name="txtTipoServicio" value="${Servicio.codigo_TS}"></div>
            <div>Codigo Proveedor : <input type="text" name="txtProveedor" value="${Servicio.codigo_PR}"></div>
            <div>Nombre       : <input type="text" name="txtNombre" value="${Servicio.nombre_S}"></div>
            <div>Descripcion  : <input type="text" name="txtDescripcion" value="${Servicio.descripcion_S}"></div>
            <div>Precio       : <input type="text" name="txtPrecio" value="${Servicio.precio_S}"></div>
            <div><input type="submit" name="btnRegistrar" value="EDITAR"></div>         
        </form>
    </body>
</html>
