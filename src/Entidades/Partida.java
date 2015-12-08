package Entidades;

import java.util.ArrayList;

public class Partida {
	int IdPartida;
	Jugador j1;
	Jugador j2;
	String turno;
	ArrayList<Pieza> blancas = new ArrayList<Pieza>();
	ArrayList<Pieza> negras = new ArrayList<Pieza>();
	
	public ArrayList<Pieza> getBlancas() {
		return blancas;
	}

	public void setBlancas(ArrayList<Pieza> blancas) {
		this.blancas = blancas;
	}

	public ArrayList<Pieza> getNegras() {
		return negras;
	}

	public void setNegras(ArrayList<Pieza> negras) {
		this.negras = negras;
	}

	public int getIdPartida() {
		return IdPartida;
	}

	public void setIdPartida(int idPartida) {
		IdPartida = idPartida;
	}

	public Jugador getJ1() {
		return j1;
	}

	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}

	public Jugador getJ2() {
		return j2;
	}

	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	//Me fijo si en la posicion que paso como parametro tengo alguna pieza
	public Pieza posicionLibre(String posicion)
	{
		for (Pieza p : blancas) 
		{
			if(p.getPosicion().equalsIgnoreCase(posicion))
			{
				//Hacerlo con messageBox
				System.out.println("Posicion Ocupada");
				return p; //Esta OCUPADA la posicion
			}
		}
		for (Pieza p : negras) 
		{
			if(p.getPosicion().equalsIgnoreCase(posicion))
			{
				//Hacerlo con messageBox
				System.out.println("Posicion Ocupada");
				return p; //Esta OCUPADA la posicion
			}
		}

		return null; //Esta LIBRE la posicion a la que quiero mover la pieza
	}
	
	public void InicializarPiezas(String color)
	{
		if (color == "Blanca")
		{
			//Inicializar piezas blancas
			//Torres
			Torre t1 = new Torre();
			Torre t2 = new Torre();
			t1.setColor(color);
			t1.setPosicion("a1");
			t1.setEnJuego(true);
			t1.setNombre("Torre");
			t2.setColor(color);
			t2.setPosicion("h1");
			t2.setEnJuego(true);
			t2.setNombre("Torre");
			blancas.add(t1);
			blancas.add(t2);
			//Caballos
			Caballo c1 = new Caballo();
			Caballo c2 = new Caballo();
			c1.setColor(color);
			c1.setPosicion("b1");
			c1.setEnJuego(true);
			c1.setNombre("Caballo");
			c2.setColor(color);
			c2.setPosicion("g1");
			c2.setEnJuego(true);
			c2.setNombre("Caballo");
			blancas.add(c1);
			blancas.add(c2);
			//Alfiles
			Alfil a1 = new Alfil();
			Alfil a2 = new Alfil();
			a1.setColor(color);
			a1.setPosicion("c1");
			a1.setEnJuego(true);
			a1.setNombre("Alfil");
			a2.setColor(color);
			a2.setPosicion("f1");
			a2.setEnJuego(true);
			a2.setNombre("Alfil");
			blancas.add(a1);
			blancas.add(a2);
			//Rey
			Rey r = new Rey();
			r.setColor(color);
			r.setPosicion("e1");
			r.setEnJuego(true);
			r.setNombre("Rey");
			blancas.add(r);
			//Reina
			Reina d = new Reina();
			d.setColor(color);
			d.setPosicion("d1");
			d.setEnJuego(true);
			d.setNombre("Dama");
			blancas.add(d);
			//Peones
			String f = "2";
			for (char i = 'a'; i <= 'h'; i++)
			{
				String pos = i + f;
				Peon p = new Peon();
				p.setColor(color);
				p.setPosicion(pos);
				p.setEnJuego(true);
				p.setNombre("Peon");
				blancas.add(p);
			}
			
		} else
			//Color Negro
		{
			//Inicializar piezas negras
			//Torres
			Torre t3 = new Torre();
			Torre t4 = new Torre();
			t3.setColor(color);
			t3.setPosicion("a8");
			t3.setEnJuego(true);
			t3.setNombre("Torre");
			t4.setColor(color);
			t4.setPosicion("h8");
			t4.setEnJuego(true);
			t4.setNombre("Torre");
			negras.add(t3);
			negras.add(t4);
			//Caballos
			Caballo c3 = new Caballo();
			Caballo c4 = new Caballo();
			c3.setColor(color);
			c3.setPosicion("b8");
			c3.setEnJuego(true);
			c3.setNombre("Caballo");
			c4.setColor(color);
			c4.setPosicion("g8");
			c4.setEnJuego(true);
			c4.setNombre("Caballo");
			negras.add(c3);
			negras.add(c4);
			//Alfiles
			Alfil a3 = new Alfil();
			Alfil a4 = new Alfil();
			a3.setColor(color);
			a3.setPosicion("c8");
			a3.setEnJuego(true);
			a3.setNombre("Alfil");
			a4.setColor(color);
			a4.setPosicion("f8");
			a4.setEnJuego(true);
			a4.setNombre("Alfil");
			negras.add(a3);
			negras.add(a4);
			//Rey
			Rey r = new Rey();
			r.setColor(color);
			r.setPosicion("e8");
			r.setEnJuego(true);
			r.setNombre("Rey");
			negras.add(r);
			//Reina
			Reina d = new Reina();
			d.setColor(color);
			d.setPosicion("d8");
			d.setEnJuego(true);
			d.setNombre("Dama");
			negras.add(d);
			//Peones
			String f = "7";
			for (char i = 'a'; i <= 'h'; i++)
			{
				String pos = i + f;
				Peon p = new Peon();
				p.setColor(color);
				p.setPosicion(pos);
				p.setEnJuego(true);
				p.setNombre("Peon");
				negras.add(p);
			}
		}
	}

	//Muestra las posiciones de las piezas que estan en juego
	public String actualizarPos() {
		String texto;
		texto = "PIEZAS BLANCAS" + "\n";
		for (Pieza p : blancas) 
		{
			if(p.enJuego)
				texto = texto + " " + p.getNombre() + " " + p.getPosicion() + "\n";
		}
		texto = texto + "PIEZAS NEGRAS" + "\n";
		for (Pieza p : negras) 
		{
			if(p.enJuego)
				texto = texto + " " + p.getNombre() + " " + p.getPosicion() + "\n";
		}
		return texto;
	}

	//Se fina si en la posicion que le pasa, hay alguna pieza
	public Pieza buscarPieza(String posIni) {
	    Pieza pie = null ;
		for (Pieza p : blancas) 
		{
			if(p.getPosicion().equalsIgnoreCase(posIni) && p.enJuego == true)
				{
				pie = p;
				}
		}
		for (Pieza p : negras) 
		{
			if(p.getPosicion().equalsIgnoreCase(posIni) && p.enJuego == true)
			{
				pie = p;
			}
		}
		return pie;
	}

	//Me fijo si el rey sigue en juego
	public String finPartida() {
		
		boolean estadoPiezas;
		
		for (Pieza p : blancas) 
		{
			if(p.getNombre().equalsIgnoreCase("Rey"))
				{
					estadoPiezas = p.isEnJuego();
					if(estadoPiezas == false)
					{
						return "Negro";
					}
				}
		}
		for (Pieza p : negras) 
		{
			if(p.getNombre().equalsIgnoreCase("Rey"))
			{
				estadoPiezas = p.isEnJuego();
				if(estadoPiezas == false)
				{
					return "Blanca";
				}
			}
		}
		return null;
	}
}