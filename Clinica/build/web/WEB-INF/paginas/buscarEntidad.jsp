<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUSCAR ENTIDAD BANCARIA</title>
    </head>
    <body>
        <h1>INGRESE NOMBRE DEL ENTIDAD BANCARIA A BUSCAR</h1>
        
        <form action="entidadBancaria?accion=buscar" method="post">
            <div>RUC: <input type="text" name="txtBuscar" value="${ban}"> </div>
            <div><input type="submit" name="btnBuscar" value="Buscar"> </div>
        </form>
        <br>
        
        <table>
            <tr>
                <td>N°</td>
                <td>RUC</td>
                <td>Nombre</td>
                <td>Dirección</td>     
                <td>Opciones</td>
            </tr>
            <c:forEach items="${ent}" var="entidadBancaria"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>  
                <td><c:out value="${entidadBancaria.ruc_E}"
                       default="No se encontró"/></td>
                <td><c:out value="${entidadBancaria.nombre_E}"
                       default="No se encontró"/></td>
                <td><c:out value="${entidadBancaria.direccion_E}"
                       default="No se encontró"/></td>

                <td> <a href="entidadBancaria?accion=editar&id=${entidadBancaria.ruc_E}" > editar </a> o <a href="entidadBancaria?accion=eliminar&id=${entidadBancaria.ruc_E}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
                
        <br><br>
        <div><a href="cliente?accion=listar">Regresar</a></div>    
    </body>
</html>
