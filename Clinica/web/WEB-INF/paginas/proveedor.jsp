<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR PROVEEDOR</title>
    </head>
    <body>
        <h1>Lista de Proveedor</h1>       
        <a href="Proveedor?accion=crear">Nuevo Proveedor</a>      
        <a href="Proveedor?accion=crearBuscar">Buscar Proveedor</a>
        
         <table>
            <tr>
                <td>N° |</td>
                <td>CODIGO |</td>
                <td>RAZON SOCIAL |</td>
                <td>NOMBRE |</td>
                <td>RUC |</td>     
                <td>DIRECCION |</td>     
                <td>TELEFONO |</td>     
                <td>ESTADO |</td>     
                <td>Opciones</td>
            </tr>
            <c:forEach items="${PR}" var="proveedor"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>   
                <td><c:out value="${proveedor.codigo_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${proveedor.razonSocial_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${proveedor.nombre_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${proveedor.ruc_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${proveedor.direccion_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${proveedor.telefono_PR}"
                       default="No se encontró"/></td>
                <td><c:out value="${proveedor.estado_PR}"
                       default="No se encontró"/></td>
                
                <td> <a href="proveedor?accion=editar&id=${proveedor.codigo_PR}" > editar </a> o <a href="proveedor?accion=eliminar&id=${proveedor.codigo_PR}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>     
    </body>
</html>
