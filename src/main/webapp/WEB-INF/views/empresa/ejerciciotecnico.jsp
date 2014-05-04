<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/default.css" >
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.1.0.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.1.0.min.map"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/tooltip/jquery.qtip.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/resources/js/tooltip/jquery.qtip.min.map"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/tooltip/jquery.qtip.css" >
<title>Ejercicio técnico de Java</title>
</head>
<body>
    <div class="section">
	    <p><strong>Formulario de alta empresa</strong></p>
	    <form:form method="post" commandName="empresa" action="${pageContext.request.contextPath}/empresa/save" >
	        <ul>
	            <li>
	                <form:label path="nombre">Nombre de empresa</form:label>
	                <form:input path="nombre" size="32" maxlength="64" required="required" 
	                title="Por favor ingrese al menos una empresa para empezar."
	                />
	            </li>
	            <li>
	               <input type="submit" class="" value="Guardar empresa"/>
	            </li>
	        </ul>
	    </form:form>
    </div>
    <div class="section">
	    <p><strong>Formulario de alta empleado</strong></p>
	    <form:form method="post" commandName="empleado" action="${pageContext.request.contextPath}/empleado/save" >
	        <ul>
	            <li>
	                <form:label path="empresarelated">Empresa</form:label>
	                <form:select path="empresarelated" items="${empresas}" 
	                   title="Seleccione la empresa a la que pertenece el nuevo empleado."
	                />
	            </li>
	            <li>
	                <form:label path="nombre">Nombre</form:label>
	                <form:input path="nombre" size="32" maxlength="64" required="required" 
	                   title="Nombre completo del nuevo empleado."
	                />
	            </li>
	            <li>
	                <form:label path="apellido">Apellido</form:label>
	                <form:input path="apellido" size="32" maxlength="64" required="required" 
	                   title="Apellido del nuevo empleado."
	                />
	            </li>
	            <li>
	                <form:label path="edad">Edad</form:label>
	                <form:input path="edad" size="10" maxlength="3" required="required" 
	                   title="Edad actual."
	                />
	            </li>
	            <li>
	                <form:label path="job">Puesto de trabajo</form:label>
	                <form:select path="job" items="${job}" required="required"
	                   title="Puesto de trabajo del nuevo empleado."
	                />
	            </li>
	            <li>
	                <form:label path="aptitud">Aptitud</form:label>
	                <form:select path="aptitud" items="${aptitud}" required="required"
	                   title="Aptidud para el puesto del nuevo empleado."
	                />
	            </li>
	            <li>
	               <input type="submit" class="" value="Guardar empleado"/>
	            </li>
	        </ul>
	    </form:form>
	</div>
    <div class="section">
    <p><strong>Buscar empleado por ID</strong></p>
	   <form:form method="post" commandName="empleado" action="${pageContext.request.contextPath}/empleado/find" >
	       <ul>
		       <li>
		           <form:label path="id">Nro de legajo</form:label>
		           <form:input path="id" size="32" maxlength="36" required="required" 
		              title="Por favor ingrese un Nro de legajo para buscar el empleado."
		           />
		       </li>
		       <li>
		          <input type="submit" class="" value="Buscar empleado"/>
		       </li>
	       </ul>
	   </form:form>
    </div>
    <div class="section">
        <p><strong>Promedio actual de edad de empleados</strong></p>
        <p>Hay ${countemployees} empleados con un promedio de edad de ${averageage} años</p>
    </div>
    <div class="section">
	   <p><strong>Lista de empleados</strong></p>
	   <c:choose>
			<c:when test="${ empty allEmployees}">
			  <p>No hay empleados actualmente.</p>
			</c:when>
			<c:when test="${ not empty allEmployees}">
				<table width="100%">
					<thead>
					    <tr align="left">
					        <th>
					            Legajo Nro
					        </th>
					        <th>
					            Nombre completo
					        </th>
					        <th>
                                Tipo de puesto 
                            </th>
                            <th>
                                Aptitud 
                            </th>
					        <th>
					            Empresa 
					        </th>
					    </tr>
					</thead>
					<tbody>
			            <c:forEach var="employee" items="${allEmployees}">
							 <tr>
							     <td>
							           <p>${employee.id}</p>
							     </td>
							     <td>
							           <p>${employee.nombre}&nbsp;${employee.apellido}</p>
							     </td>
							     <td>
                                       <p>${employee.job}</p>
                                 </td>
                                 <td>
                                       <p>${employee.aptitud}</p>
                                 </td>
							     <td>
							           ${employee.empresa.nombre}
							     </td>
							 </tr>
				       </c:forEach>
				   </tbody>
			    </table>
		    </c:when>
	   </c:choose>
    </div>
</body>
<script type="text/javascript">
$(document).ready(function() {
    /**
     * Tooltip for the type users.
     */
    $("[title]").qtip({
        content: {
            attr: 'title'
        },
        style: { classes: 'qtip-bootstrap'},
        show: {
            event: 'focus mouseover'
        },
        hide: {
            event: 'focusout mouseout'
        }
    });
});
</script>
</html>