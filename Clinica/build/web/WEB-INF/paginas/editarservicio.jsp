<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Servicio</title>
    </head>
    <body>
        <h1>Editar Servicio - ${servicio.codigo_S}</h1>
        <c:if test="${msje!=null}">
            <div>${msje}</div>
        </c:if>
        <form action="servicio?accion=modificar&id=${servicio.codigo_S}" method="post">
            <div>Codigo Tipo Servicio : <input type="text" name="txtTipoServicio" value="${servicio.codigo_TS}"></div>
            <div>Codigo Proveedor : <input type="text" name="txtCodigoProveedor" value="${servicio.codigo_TS}"></div>
            <div>Nombre       : <input type="text" name="txtNombre" value="${servicio.nombre_S}"></div>
            <div>Descripcion  : <input type="text" name="txtDescripcion" value="${servicio.descripcion_S}"></div>
            <div>Precio       : <input type="text" name="txtPrecio" value="${servicio.precio_S}"></div>
            <div>Estado       : <input type="checkbox" name="chkEstado" 
                                 ${servicio.estado_S == true?'checked':'unchecked'}></div>
            <div><input type="submit" name="btnRegistrar" value="EDITAR"></div>         
        </form>
    </body>
</html>
