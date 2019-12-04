<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUSCAR PROVEEDOR</title>
    </head>
    <body>
        <h1>BUSCAR PROVEEDOR</h1>
         <form action="proveedor?accion=buscar" method="post">
            <div>Nro Ruc<input type="text" name="txtBuscar" value="${NPR}"> </div>
            <div><input type="submit" name="btnBuscar" value="Buscar"> </div>
        </form>
        <br>
        
        <table>
            <tr>
                <td>N°</td>
                <td>CODIGO</td>
                <td>RAZON SOCIAL</td>
                <td>NOMBRE</td>
                <td>RUC</td>
                <td>DIRECCION</td>     
                <td>TELEFONO</td>     
                <td>ESTADO</td>     
                <td>Opciones</td>
            </tr>
            <c:forEach items="${PR}" var="Proveedor"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>  
                <td><c:out value="${Proveedor.codigo_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${Proveedor.razonSocial_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${Proveedor.nombre_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${Proveedor.ruc_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${Proveedor.direccion_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${Proveedor.telefono_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${Proveedor.estado_PR}"
                       default="No se encontró"/></td>
                
                    <td> <a href="Proveedor?accion=editar&id=${Proveedor.Ruc_PR}" > editar </a> o <a href="Proveedor?accion=eliminar&id=${Proveedor.ruc_PR}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
                
        <br><br>
        <div><a href="Proveedor?accion=listar">Regresar</a></div>    
        
        
    </body>
</html>
