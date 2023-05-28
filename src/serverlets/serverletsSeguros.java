package serverlets;

import java.io.IOException;
import dominio.Seguros;
import dominio.SegurosDao;

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
public class serverletsSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public serverletsSeguros() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descripcion = "";
		int tipoSeguro = 0;
		float costoContratacion = 0;
		float costoMaxAsegurado = 0;
		int filas = 0;
		
		if(request.getParameter("btnAceptar") != null){
			Seguros seguroNuevo = new Seguros();
			descripcion = request.getParameter("txtDescripcion");
			tipoSeguro = Integer.parseInt(request.getParameter("tipoSeguro"));
			costoContratacion = Float.parseFloat(request.getParameter("txtCostoContratacion"));
			costoMaxAsegurado = Float.parseFloat(request.getParameter("txtCostoMaximo"));
			
			SegurosDao sDao = new SegurosDao();
			filas = sDao.agregarSeguro(seguroNuevo);		

		}
		request.setAttribute("cantidadFilas", filas);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp"); 
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
