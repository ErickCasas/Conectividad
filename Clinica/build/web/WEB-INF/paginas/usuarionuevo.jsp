<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario Nuevo</title>
    </head>
    <body>
        <h1>Nuevo Usuario</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="Usuario?accion=registrar" method="post">
            <div>Codigo Tipo Usuario: <input type="text" name="txtTipoUsuario" value="${usuario.codigo_TU}"></div>
            <div>Codigo Cliente     : <input type="text" name="txtCliente" value="${usuario.codigo_C}"></div>
            <div>Codigo Pago        : <input type="text" name="txtPago" value="${usuario.codigo_P}"></div>
            <div>Nombre Usuario     : <input type="text" name="txtNombre" value="${usuario.nombre_U}"></div>
            <div>Contraseña         : <input type="text" name="txtContraseña" value="${usario.password_U}"></div>
            <div>Vigencia           : <input type="checkbox" name="chkVigencia" 
                                      ${usuario.vigencia_U == true?'checked':'unchecked'}></div>         
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>