package serverlets;

import java.io.IOException;
import java.util.List;

import dominio.Seguros;
import dominio.SegurosDao;
import dominio.TipoSeguro;
import dominio.TipoSeguroDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serverletsSeguros
 */
@WebServlet("/serverletsSeguros")
public class serverletsSeguros extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public serverletsSeguros() 
    {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/*TipoSeguroDao Tipo = new TipoSeguroDao();
		
		List<TipoSeguro> ListaTiposdeSeguros = Tipo.ListarTiposdeSeguros();
		
		request.setAttribute("TiposdeSeguro", ListaTiposdeSeguros);
		
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp"); 
		rd.forward(request, response);
		
		if(request.getParameter("btnAceptar") != null)*/
		int filas = 0;
		{
			Seguros seguroNuevo = new Seguros();
			
			seguroNuevo.setDescripcion(request.getParameter("txtDescripcion"));
			seguroNuevo.setTipoSeguro(Integer.parseInt(request.getParameter("tipoSeguro")));
			seguroNuevo.setCostoContratacion(Float.parseFloat(request.getParameter("txtCostoContratacion")));
			seguroNuevo.setCostoMaxAsegurado(Float.parseFloat(request.getParameter("txtCostoMaximo")));
			
			SegurosDao sDao = new SegurosDao();
			filas = sDao.agregarSeguro(seguroNuevo);
			
			//REQUESTDISPATCHER
			request.setAttribute("cantidadFilas", filas);
			RequestDispatcher rd2 = request.getRequestDispatcher("/AgregarSeguro.jsp"); 
			rd2.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
