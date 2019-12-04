<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entidad Bancaria</title>
    </head>
    <body>
        <h1> Entidad Bancaria </h1>
        <form action="entidadBancaria?accion=buscar" method="post">
            <div>Nro Ruc<input type="text" name="txtBuscar" value="${NPR}"> </div>
            <div><input type="submit" name="btnBuscar" value="Buscar"> </div>
        </form>
        <br>
        
        <table>
            <tr>
                <td>N°</td>
                <td>CODIGO</td>
                <td>NOMBRE</td>
                <td>DIRECCION</td>
                <td>RUC</td>
            </tr>
            <c:forEach items="${eb}" var="entidadBancaria"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>  
                <td><c:out value="${entidadBancaria.codigo_E}"
                       default="No se encontró"/></td>
                <td><c:out value="${entidadBancaria.nombre_E}"
                       default="No se encontró"/></td>
                <td><c:out value="${entidadBancaria.direccion_E}"
                       default="No se encontró"/></td>
                <td><c:out value="${entidadBancaria.ruc_E}"
                       default="No se encontró"/></td>
                             
                    <td> <a href="entidadBancaria?accion=editar&id=${entidadBancaria.Ruc_E}" > editar </a> o <a href="entidadBancaria?accion=eliminar&id=${entidadBancaria.ruc_E}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
                
        <br><br>
        <div><a href="Proveedor?accion=listar">Regresar</a></div>           
    </body>
</html>
