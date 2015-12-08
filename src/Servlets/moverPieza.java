package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Controlador.CtrlPartida;
import Entidades.Partida;
import Entidades.Pieza;

/**
 * Servlet implementation class moverPieza
 */
@WebServlet("/moverPieza")
public class moverPieza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public moverPieza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String origen = request.getParameter("Origen");
		String destino = request.getParameter("Destino");
		
		Partida partSession = (Partida) request.getSession().getAttribute("partSession");
		
		String colorTurno = partSession.getTurno();
		Pieza pieza = partSession.buscarPieza(origen);
		String color = pieza.getColor();
		
		if(pieza.esMovimientoValido(origen, destino, color, partSession, colorTurno))
			{
				pieza.setPosicion(destino);
				actualizarTurno(partSession);
			}
		
		else
				response.getWriter().append("Movimiento Invalido");
		
//		if(partSession.finPartida().equalsIgnoreCase("Negro") || partSession.finPartida().equalsIgnoreCase("Blanca") )
//		{
//			request.getSession().setAttribute("partSession", partSession);
//			response.getWriter().append("Fin del juego").append(partSession.finPartida());	
//		}
		
		//else
		{	
			request.getSession().setAttribute("partSession", partSession);
			request.getRequestDispatcher("jugar.jsp").forward(request, response);
		}

	}
	
	private void actualizarTurno(Partida p) {
		
		if (p.getTurno().equalsIgnoreCase("Blanca") )
		{
			p.setTurno("Negro");
		}
		
		else
		{
			p.setTurno("Blanca");
		}
	}

}
