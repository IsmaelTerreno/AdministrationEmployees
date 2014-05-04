<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
         <c:when test="${ empty foundEmployee}">
           <p>No se ha encontrado el empleado.</p>
         </c:when>
         <c:when test="${ not empty foundEmployee}">
             <table width="50%">
                 <thead>
                     <tr align="left">
                         <th>
                             Legajo Nro
                         </th>
                         <th>
                             Nombre completo
                         </th>
                         <th>
                             Empresa 
                         </th>
                     </tr>
                 </thead>
                 <tbody>
                     <tr>
                         <td>
                               ${foundEmployee.id}
                         </td>
                         <td>
                               ${foundEmployee.nombre} ${foundEmployee.apellido}
                         </td>
                         <td>
                               ${foundEmployee.empresa.nombre}
                         </td>
                     </tr>
                </tbody>
             </table>
         </c:when>
     </c:choose>
     <hr>
     <p><a href="<c:url value="/"/>">Volver</a></p>
</body>
</html>