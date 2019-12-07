<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NUEVO TIPO SERVICIO</title>
    </head>
    <body>
        <h1>NUEVO TIPO SERVICIO</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="TipoServicio?accion=registrar" method="post">
            <div>Descripcion: <input type="text" name="txtDescripcion" value="${tiposervicio.descripcion_TS}"></div>
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>