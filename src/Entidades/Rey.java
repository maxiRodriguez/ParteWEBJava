package Entidades;

import javax.swing.JOptionPane;

public class Rey extends Pieza {

	@Override
	public boolean esMovimientoValido(String posIni, String posFin, String color,Partida par, String colorTurno) {
		
		Integer filaIni = Integer.parseInt(RecuperarFila(posIni));
		char colIni = RecuperarColumna(posIni).charAt(0);
		
		Integer filaFin = Integer.parseInt(RecuperarFila(posFin));
		char colFin = RecuperarColumna(posFin).charAt(0);
		
		if(color.equals(colorTurno)) {
			if (filaFin >= 1 && filaFin <= 8)
			{
				if(colFin >= 'a' && colFin <= 'h')
				{
					//Movimientos del REY cuando la POSICION DESTINO esta LIBRE
					if (filaIni == 1 && (filaIni + 1) == filaFin && par.posicionLibre(posFin) == null)
					{
						//Solo se puede mover para adelante
						return true;
					}
					else if (filaIni == 8 && (filaIni - 1) == filaFin && par.posicionLibre(posFin) == null)
					{
						//Solo se puede mover para abajo
						return true;
					}
					else if(colIni == 'a' && ((colIni ++) == colFin) && par.posicionLibre(posFin) == null)
					{
						//Solo se puede mover para la derecha
						return true;
					}
					else if(colIni == 'h' && ((colIni --) == colFin) && par.posicionLibre(posFin) == null)
					{
						//Solo se puede mover a la izquierda
						return true;
					}
					else if (((filaIni + 1) == filaFin || (filaIni - 1) == filaFin) && ((colIni ++) == colFin || (colIni --) == colFin) && par.posicionLibre(posFin) == null)
					{
						//movimiento a un lugar libre
						return true;
					}
					
					//Movimientos cuando el REY BLANCO puede comer una pieza NEGRA
					
					else if (filaIni == 1 && (filaIni + 1) == filaFin && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negra"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (filaIni == 8 && (filaIni - 1) == filaFin && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negra"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if(colIni == 'a' && ((colIni ++) == colFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negra"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if(colIni == 'h' && ((colIni --) == colFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negra"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (((filaIni + 1) == filaFin || (filaIni - 1) == filaFin) && ((colIni ++) == colFin || (colIni --) == colFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negra"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					
					//Movimientos cuando el REY NEGRO puede comer una pieza BLANCA
					
					else if (filaIni == 1 && (filaIni + 1) == filaFin && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (filaIni == 8 && (filaIni - 1) == filaFin && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if(colIni == 'a' && ((colIni ++) == colFin) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if(colIni == 'h' && ((colIni --) == colFin) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (((filaIni + 1) == filaFin || (filaIni - 1) == filaFin) && ((colIni ++) == colFin || (colIni --) == colFin) && par.posicionLibre(posFin) != null && color == "Negra" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca"))
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
