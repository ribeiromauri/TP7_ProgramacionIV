<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Seguros"%>
<%@page import="dominio.SegurosDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="dominio.TipoSeguroDao"%>
<%@page import="dominio.TipoSeguro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Seguro</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a>
	<a href="AgregarSeguro.jsp">Agregar seguro</a>
	<a href="ListarSeguros.jsp">Listar seguros</a>
	
	<h2>Agregar Seguros</h2>
	<!-- Agregar servlet al form -->
	<div>
		<form action="serverletsSeguros" method="get">
			<label>ID Seguro</label><%SegurosDao seguroDao = new SegurosDao();
			int cantidad = seguroDao.obtenerSeguros().size(); %> 
			<%=cantidad+1 %>
			<input type="hidden" name="txtID" value="<%=cantidad+1 %>"> <br>
			<label for="txtDescripcion">Descripcion</label>		
			<input id="txtDescripcion" type="text" name="txtDescripcion"/>
			<br/>
			<label for="tipoSeguro">Tipo de seguro</label>
			<br/>
			<%-- 
			<select name="tipoSeguros" id="tipoSeguros">
			<% List<TipoSeguro> listaTiposDeSeguro = (List<TipoSeguro>)request.getAttribute("TiposdeSeguro");
			if(listaTiposDeSeguro!=null)
       			for(TipoSeguro tipo:listaTiposDeSeguro){%>
       		<option value="<%=tipo.getID()%>"><%=tipo.getDescripcion()%></option>
       		<%} %>
			</select>
			--%>
			
			<jsp:useBean id="cn" class="dominio.TipoSeguroDao" scope="page"></jsp:useBean>
			<%ArrayList list = cn.ListarTiposdeSeguros(); %>
			<select name="tipoSeguro">
				<option>Escoge una Opcion: </option>
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
			
			<br/>
			<label for="txtCostoContratacion">Costo contratacion</label>
			<input id="txtCostoContratacion" name="txtCostoContratacion" type="text"/>
			 <br/>
			<label for="txtCostoMaximo">Costo maximo asegurado</label>
			<input id="txtCostoMaximo" name="txtCostoMaximo" type="text"/>
			<br/>
			<input type="submit" name="btnAceptar" value="Aceptar" />		
		</form>
	</div>
	
	<%
	int filas = 0;
 	if(request.getAttribute("cantidadFilas") != null){
 		 filas = Integer.parseInt(request.getAttribute("cantidadFilas").toString());
			
			if(filas == 1){
				%>
				Seguro agregado correctamente!
				<%
			}
 	}
	%>
</body>
</html>