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
	<form>
		<select name="tipoSeguros" id="tipoSeguros">
			<option value="tipoSeguros">Tipo de seguros</option>
			<!-- Tipos de seguros de la DB -->
		</select>
		<input type="submit" name="btnFiltrar" value="Filtrar" />
	</form>	
	
	<table>
    <tr>
      <th>ID Seguro</th>
      <th>Descripcion del seguro</th>
      <th>Descripcion tipo seguro</th>
      <th>Costo de contratación</th>
      <th>Costo máximo asegurado</th>
    </tr>
    <tr>
    <!-- Información desde la DB -->
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </table>
</body>
</html>