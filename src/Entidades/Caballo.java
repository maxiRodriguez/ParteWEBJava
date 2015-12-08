package Entidades;

import javax.swing.JOptionPane;

public class Caballo extends Pieza {

	
	@Override
	public boolean esMovimientoValido(String posIni, String posFin, String color, Partida par, String colorTurno) {
		Integer filaIni = Integer.parseInt(RecuperarFila(posIni));
		char colIni = RecuperarColumna(posIni).charAt(0);
		
		Integer filaFin = Integer.parseInt(RecuperarFila(posFin));
		char colFin = RecuperarColumna(posFin).charAt(0);
		
		if(color.equals(colorTurno)) {
			if (filaFin >= 1 && filaFin <= 8)
			{
				if(colFin >= 'a' && colFin <= 'h')
				{
					//Se mueve 2 +/- sobre la misma COLUMNA y se desplaza UNO para la izquierda o la derecha
					if((((filaIni + 2) == filaFin || (filaIni - 2) == filaFin) && (((colIni ++) == colFin) || ((colIni --) == colFin)) && par.posicionLibre(posFin) == null))
					{
						return true;
					}
					// se mueve 2 +/- sobre la misma FILA y se desplaza UNO para arriba o para abajo  
					else if((((colIni + 2) == colFin || (colIni - 2) == colFin) && (((filaIni + 1) == filaFin) || ((filaIni - 1) == filaFin)) && par.posicionLibre(posFin) == null))
					{
						return true;
					}
					//Validaciones Extremos de las COLUMNAS cuando la posicion esta VACIA
					//Si esta en la columna A solo se puede desplazar para arriba o abajo y despues a la DERECHA
					else if (colIni == 'a' && colFin == 'b' && (((filaIni + 2) == filaFin) || (filaIni - 2) == filaFin) && par.buscarPieza(posFin) == null)
					{
						return true;
					}
					//Si esta en la columna H solo se puede desplazar para arriba o abajo y despues a la IZQUIERDA
					else if (colIni == 'h' && colFin == 'g' && (((filaIni + 2) == filaFin) || (filaIni - 2) == filaFin) && par.buscarPieza(posFin) == null)
					{
						return true;
					}
					//Validaciones Extremos de las FILAS cuando la posicion esta VACIA
					//Si esta en la columna 1 solo se puede desplazar para la izquierda o dereecha y despues para ARRIBA
					else if (filaIni == 1 && filaFin == 2 && (((colIni + 2) == colFin) || (colIni - 2) == colFin) && par.buscarPieza(posFin) == null)
					{
						return true;
					}
					//Si esta en la columna 8 solo se puede desplazar para la izquierda o dereecha y despues para ABAJO
					else if (filaIni == 8 && filaFin == 7 && (((colIni + 2) == colFin) || (colIni - 2) == colFin) && par.buscarPieza(posFin) == null)
					{
						return true;
					}
					
					//Validaciones cuando puede comer un CABALLO BLANCO a una pieza NEGRA
					else if((((filaIni + 2) == filaFin || (filaIni - 2) == filaFin) && (((colIni ++) == colFin) || ((colIni --) == colFin)) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro")))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if((((colIni + 2) == colFin || (colIni - 2) == colFin) && (((filaIni + 1) == filaFin) || ((filaIni - 1) == filaFin)) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro")))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (colIni == 'a' && colFin == 'b' && (((filaIni + 2) == filaFin) || (filaIni - 2) == filaFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (colIni == 'h' && colFin == 'g' && (((filaIni + 2) == filaFin) || (filaIni - 2) == filaFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (filaIni == 1 && filaFin == 2 && (((colIni + 2) == colFin) || (colIni - 2) == colFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (filaIni == 8 && filaFin == 7 && (((colIni + 2) == colFin) || (colIni - 2) == colFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					
					//Validaciones cuando puede comer un CABALLO NEGRO a una pieza BLANCA
					else if((((filaIni + 2) == filaFin || (filaIni - 2) == filaFin) && (((colIni ++) == colFin) || ((colIni --) == colFin)) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanco")))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if((((colIni + 2) == colFin || (colIni - 2) == colFin) && (((filaIni + 1) == filaFin) || ((filaIni - 1) == filaFin)) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanco")))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (colIni == 'a' && colFin == 'b' && (((filaIni + 2) == filaFin) || (filaIni - 2) == filaFin) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanco"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (colIni == 'h' && colFin == 'g' && (((filaIni + 2) == filaFin) || (filaIni - 2) == filaFin) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanco"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (filaIni == 1 && filaFin == 2 && (((colIni + 2) == colFin) || (colIni - 2) == colFin) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanco"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (filaIni == 8 && filaFin == 7 && (((colIni + 2) == colFin) || (colIni - 2) == colFin) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanco"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Movimiento Incorrent", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
		} else {
			return false;
		}
	}

}
