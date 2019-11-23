<%-- 
    Document   : medicoNuevo
    Created on : 06/11/2019, 04:40:52 PM
    Author     : STEVEN ANTONY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NUEVO MEDICO</title>
    </head>
    <body>
        <h1>MEDICO NUEVO</h1>
        <c:if test ="${msje != null}">
            <div>${msje}</div>
        </c:if>
        <form action="medico?accion=registrar" method="post">
            <div>Nombre <input type="text" name="txtNombre" value="${medico.nombre}"></div>
            <div>Apellido P. <input type="text" name="txtApellidoP" value="${medico.apellidoP}"></div>
            <div>Apellido M. <input type="text" name="txtApellidoM" value="${medico.apellidoM}"></div>
            
            <div>DNI <input type="text" name="txtDNI" value="${medico.DNI}"></div>
            <div>CMP <input type="text" name="txtCMP" value="${medico.CMP}"></div>
            
            <div>Especialidad <input type="text" name="txtEspecialidad" value="${medico.especialidad}"></div>
            <div>Vigencia <input type="checkbox" name="chkVigencia" 
                                 ${medico.vigencia == true?'checked':'unchecked'}></div>
            <div><input type="submit" name="btnRegistrar" value="Registrar"></div>
        </form>
    </body>
</html>
