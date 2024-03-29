<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDITAR CLIENTE</title>
    </head>
    <body>
        <h1>Editar Cliente - ${cliente.nroDocumento_C}</h1> 
        <c:if test="${msje!=null}">
            <div>${msje}</div>
        </c:if>
        <form action="cliente?accion=modificar&id=${cliente.nroDocumento_C}" method="post">
            <div>Codigo Tipo Cliente: <input type="text" name="txtTipoCliente" value="${cliente.codigo_TC}"></div>
            <div>Tipo         : <select name="cboTipoCliente">
                                    <option value="0">Seleccionar</option>
                                    <option value="1">P. Jurídica</option>
                                    <option value="2">P. Natural</option>
                                </select>
            </div>
            <div>Nro Documento: <input type="text" name="txtNroDocumento" value="${cliente.nroDocumento_C}"></div>
            <div>Nombre       : <input type="text" name="txtNombre" value="${cliente.nombre_C}"></div>
            <div>Apellidos    : <input type="text" name="txtApellido" value="${cliente.apellido_C}"></div>
            <div>Dirección    : <input type="text" name="txtDireccion" value="${cliente.direccion_C}"></div>
            <div>Teléfono     : <input type="text" name="txtTelefono" value="${cliente.telefono_C}"></div>
            <div>Estado       : <input type="checkbox" name="chkEstado" 
                                 ${cliente.estado_C == true?'checked':'unchecked'}></div>
            <div><input type="submit" name="btnRegistrar" value="EDITAR"></div>         
        </form>
    </body>
</html>
