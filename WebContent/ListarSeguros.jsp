<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Seguros"%>
<%@page import="dominio.SegurosDao"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="dominio.TipoSeguroDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Seguros</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a>
	<a href="AgregarSeguro.jsp">Agregar seguro</a>
	<a href="ListarSeguros.jsp">Listar seguros</a>
	
	<h2>Tipo de seguros de la base de datos</h2>
	<p>Busqueda por tipo de Seguros: </p> 
	<form action="serverletsSeguros" method="post">
		<select name="tipoSeguros" id="tipoSeguros">
			<!-- Tipos de seguros de la DB -->
			<jsp:useBean id="cn" class="dominio.TipoSeguroDao" scope="page"></jsp:useBean>
			<%ArrayList list = cn.ListarTiposdeSeguros(); %>
			<option value="-1">Escoge una Opcion: </option>
				<%
				ListIterator <TipoSeguro> it = list.listIterator();
				while(it.hasNext())
				{
					TipoSeguro obj = it.next();
				%>
				<option value="<%= obj.getID()%>"><%= obj.getDescripcion() %></option>
				<%
				}%>
		</select>
		<input type="submit" name="btnFiltrar" value="Filtrar" />
		<%String filtro = "Sin filtro"; %>
		<p>Filtro:
		<%if(request.getAttribute("filtro") != null){
			filtro = (String) request.getAttribute("filtro"); 
		}%>
		<%= filtro %>
		</p>
	</form>	
	
	  <%
 	 	ArrayList<Seguros> listaSeguros = new ArrayList<Seguros>();
  		if(request.getAttribute("listaSeguros") != null){
		  listaSeguros = (ArrayList<Seguros>)request.getAttribute("listaSeguros");
	  
  		}
  	%>
  
	<table border="1">
    <tr>
      <th>ID Seguro</th>
      <th>Descripcion del seguro</th>
      <th>Descripcion tipo seguro</th>
      <th>Costo de contratación</th>
      <th>Costo máximo asegurado</th>
    </tr>
    
	<% if(listaSeguros.size() > 0)
	{
		for(Seguros seguro : listaSeguros){%>
   	 	<tr>
     	 	<td><%=seguro.getID() %></td>
     	 	<td><%=seguro.getDescripcion() %></td>
      		<td><%=seguro.getTipoSeguro().getDescripcion() %></td>
      		<td><%=seguro.getCostoContratacion() %></td>
    	  	<td><%=seguro.getCostoMaxAsegurado() %></td>
   	 	</tr>
   		 <%}
	} %>
  </table>
  

</body>
</html>