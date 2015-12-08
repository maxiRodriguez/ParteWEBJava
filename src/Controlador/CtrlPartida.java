package Controlador;

import java.util.ArrayList;

import Data.CatalogoJugador;
import Data.CatalogoPartida;
import Data.CatalogoPiezas;
import Entidades.Jugador;
import Entidades.Partida;
import Entidades.Pieza;

public class CtrlPartida {

	CatalogoJugador catJug = new CatalogoJugador();
	CatalogoPartida catPart = new CatalogoPartida();
	CatalogoPiezas catPie = new CatalogoPiezas();
	Partida p;
	Jugador j;
	ArrayList<Pieza> piezas;
	
	public Partida buscarPartida(String dni1, String dni2) {
		Jugador j1 = catJug.getByDni(dni1);
		Jugador j2 = catJug.getByDni(dni2);
		p = catPart.getByJugadores(j1, j2);
		p.setBlancas(catPie.getPiezas(p.getIdPartida(), "Blanca"));
		p.setNegras(catPie.getPiezas(p.getIdPartida(), "Negro"));		
		return p;
	}

	public Jugador buscarJugador(String dni) {
		j = catJug.getByDni(dni);
		return j;
	}

	public ArrayList<Pieza> buscarPiezas(int idPartida, String color) {
		piezas = catPie.getPiezas(idPartida, color);
		return piezas;
	}

	public void guardarPartida(Partida p2, Jugador j1, Jugador j2) {
		if(catPart.getById(p2.getJ1(), p2.getJ2()) == null) {
			catPart.add(p2);
			piezas = p2.getBlancas();
			for (Pieza pieza : piezas) {
				catPie.add(pieza, p2);
			}
			piezas = p2.getNegras();
			for (Pieza pieza : piezas) {
				catPie.add(pieza, p2);
			}
		} else {
			catPart.delete(p2);
			catPart.add(p2);
			piezas = p2.getBlancas();
			for (Pieza pieza : piezas) {
				catPie.add(pieza, p2);
			}
			piezas = p2.getNegras();
			for (Pieza pieza : piezas) {
				catPie.add(pieza, p2);
			}
		}
		
	}

}
