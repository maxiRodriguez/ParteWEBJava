package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.CtrlPartida;
import Entidades.Partida;


/**
 * Servlet implementation class cargarPartida
 */
@WebServlet("/cargarPartida")
public class cargarPartida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cargarPartida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlPartida ctrl = new CtrlPartida();
		
		String dni1 = String.valueOf(request.getParameter("dniJug1"));
		String dni2 = String.valueOf(request.getParameter("dniJug2"));
		
		Partida p = new Partida();
		
		p = ctrl.buscarPartida(dni1, dni2);
		
		if (p != null)
		{
			//Redirecciono a jugar.jsp
			request.getSession().setAttribute("partSession", p);
			request.getRequestDispatcher("jugar.jsp").forward(request, response);
		}
		
		
	}

}
