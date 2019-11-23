
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUSCAR MEDICO</title>
    </head>
    <body>
        <h1>INGRESE NOMBRE DEL MEDICO A BUSCAR</h1>
        
        <form action="medico?accion=buscar" method="post">
            <div>Nombre: <input type="text" name="txtBuscar" value="${ban}"> </div>
            <div><input type="submit" name="btnBuscar" value="Buscar"> </div>
        </form>
        <br>
        
        <table>
            <tr>
                <td>N°</td>
                <td>Nombre</td>
                <td>Especialidad</td>     
                <td>Opciones</td>
            </tr>
            <c:forEach items="${med}" var="medico"  varStatus="iteracion">
            <tr>
                <td>${iteracion.index + 1}</td>           
                <td><c:out value="${medico.nombre}"
                       default="No se encontró"/></td>
                <td><c:out value="${medico.especialidad}"
                       default="No se encontró"/></td>
                
                    <td> <a href="medico?accion=editar&id=${medico.codigo}" > editar </a> o <a href="medico?accion=eliminar&id=${medico.codigo}" > eliminar </a></td>
            </tr>
            </c:forEach>
        </table>
                
        <br><br>
        <div><a href="medico?accion=listar">Regresar</a></div>    
    </body>
</html>
