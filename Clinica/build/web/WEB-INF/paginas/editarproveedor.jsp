<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR PROVEEDOR</title>
    </head>
    <body>
        <h1>EDITAR PROVEEDOR - ${proveedor.codigo_PR}</h1>
        <c:if test="${msje!=null}">
            <div>${msje}</div>
        </c:if>
        <form action="proveedor?accion=modificar&id=${proveedor.codigo_PR}" method="post">
            <div>Razon Social : <input type="text" name="txtRazonSocial" value="${cliente.razonSocial_PR}"></div>
            <div>Nombre       : <input type="text" name="txtNombre" value="${cliente.nombre_PR}"></div>
            <div>RUC          : <input type="text" name="txtRuc value="${cliente.ruc_PR}"></div>
            <div>Dirección    : <input type="text" name="txtDireccion" value="${cliente.direccion_PR}"></div>
            <div>Teléfono     : <input type="text" name="txtTelefono" value="${cliente.telefono_PR}"></div>
            <div>Estado       : <input type="checkbox" name="chkEstado" 
                                 ${cliente.estado_PR == true?'checked':'unchecked'}></div>
            <div><input type="submit" name="btnRegistrar" value="EDITAR"></div>         
        </form>
    </body>
</html>
