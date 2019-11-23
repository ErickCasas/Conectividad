<%-- 
    Document   : medicoListar
    Created on : 06/11/2019, 04:26:31 PM
    Author     : STEVEN ANTONY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR MEDICOS</title>
    </head>
    <body>
        <h1>Lista de Medicos</h1>
        <a href="medico?accion=crear">Nuevo Medico</a>
        
        <a href="medico?accion=crearBuscar">Buscar Medico</a>
       <!-- <a href="medico?accion=crearBuscar">Buscar Medico</a>-->
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
    </body>
</html>
