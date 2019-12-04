<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo Usuario</title>
    </head>
    <body>
        <h1>Tipo Usuario</h1>
        <c:if test="${msje!=null}">
            <div>${msje}</div>
        </c:if>
        <form action="TipoUsuario?accion=modificar&id=${TipoUsuario.codigo_TU}" method="post">
            <div>Descripcion : <input type="text" name="txtDescripcion" value="${TipoUsuario.descripcion_TU}"></div>      
            <div><input type="submit" name="btnRegistrar" value="EDITAR"></div>         
        </form>
    </body>
</html>
