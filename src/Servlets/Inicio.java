package Servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.CtrlPartida;
import Data.CatalogoPartida;
import Entidades.Jugador;
import Entidades.Partida;

/**
 * Servlet implementation class Login
 */
@WebServlet("/inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
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
		
		String dni1 = String.valueOf(request.getParameter("dniJug1"));
		String dni2 = String.valueOf(request.getParameter("dniJug2"));
		
		CtrlPartida ctrl = new CtrlPartida();
		
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		
		j1 = ctrl.buscarJugador(dni1);
		j2 = ctrl.buscarJugador(dni2);
		
		Partida p = new Partida();
		p.InicializarPiezas("Blanca");
		p.InicializarPiezas("Negro");
		p.setTurno("Blanca");
		p.setJ1(j1);
		p.setJ2(j2);
		//p.setIdPartida(1);
		
		
		request.getSession().setAttribute("partSession", p);
		request.getRequestDispatcher("jugar.jsp").forward(request, response);

	}

}
