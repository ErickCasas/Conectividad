<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR ENTIDADES BANCARIAS</title>
    </head>
    <body>
        <h1>Lista de Entidades Bancarias</h1>
        <a href="entidadBancaria?accion=crear">Nuevas Entidades Bancarias</a>
        
        <a href="entidadBancaria?accion=crearBuscar">Buscar Entidades Bancarias</a>
      
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
    </body>
</html>
