<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form>
		<label>ID Seguro</label>
		 <br/>
		<label for="txtDescripcion">Descripción</label>		
		<input id="txtDescripcion" type="text" name="txtDescripcion"/>
		 <br/>
		<label for="tipoSeguro">Tipo de seguro</label>
		 <br/>
		<select name="tipoSeguros" id="tipoSeguros">
			<option value="tipoSeguros">Tipo de seguros</option>
			<!-- Tipos de seguros de la DB -->
		</select>
		 <br/>
		<label for="txtCostoContratacion">Costo contratación</label>
		<input id="txtCostoContratacion" name="txtCostoContratacion" type="text"/>
		 <br/>
		<label for="txtCostoMaximo">Costo máximo asegurado</label>
		<input id="txtCostoMaximo" name="txtCostoMaximo" type="text"/>
		 <br/>
		<input type="submit" name="btnAceptar" value="Aceptar" />		
	</form>
	</div>
</body>
</html>