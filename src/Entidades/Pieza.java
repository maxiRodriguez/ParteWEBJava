package Entidades;

public abstract class Pieza {

	String color;
	String posicion;//(columna, fila)
	boolean enJuego; //True en el tablera, false fue comida
	String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	} 
	
	public abstract boolean esMovimientoValido(String posIni, String posFin, String color, Partida partida, String colorTurno);
	
	public String RecuperarColumna(String pos)
	{
		String columna = pos.substring(0, 1);
		return columna;
	}
	
	public String RecuperarFila(String pos)
	{
		String fila = pos.substring(1, 2);
		return fila;
	}
	
}
