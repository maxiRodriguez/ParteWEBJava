package Entidades;

import javax.swing.JOptionPane;

public class Peon extends Pieza {

	@Override
	public boolean esMovimientoValido(String posIni, String posFin, String color, Partida par, String colorTurno) {
		
		int filaIni = Integer.parseInt(RecuperarFila(posIni));
		char colIni = RecuperarColumna(posIni).charAt(0);
		
		int filaFin = Integer.parseInt(RecuperarFila(posFin));
		char colFin = RecuperarColumna(posFin).charAt(0);
		
		if(color.equals(colorTurno)) {
			if (filaFin >= 1 && filaFin <= 8)
			{
				if(colFin >= 'a' && colFin <= 'h')
				{
					//Validaciones den POSICIONES INCIALES
					//Peon Blanco en posicion inicial con POSICION FIN VACIA
					if (filaIni == 2)
					{
						if(colIni == colFin && (filaFin == 3 || filaFin == 4) && par.posicionLibre(posFin) == null)
						{
							return true; //Movimiento VALIDO
						}
					}
						//Peon Negro en posicion Inicial con POSICION FIN VACIA
					else if (filaIni == 7)
						{
							if(colIni == colFin && (filaFin == 6 || filaFin == 5) && par.posicionLibre(posFin) == null)
							{
								return true;
							}
						}
					
					//Movimiento del PEON BLANCO a una POSICION FIN VACIA
					else if ((filaIni + 1) == filaFin && colIni == colFin && color == "Blanca" && filaIni <= 7 && par.posicionLibre(posFin) == null )
					{
						return true;
					}
					
					//Movimiento del PEON BLANCO que come una pieza NEGRA
					else if (color == "Blanca" && colIni == 'a' && colFin == 'b' && par.posicionLibre(posFin) != null && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro") && (filaIni + 1) == filaFin) 
					{					
	
						par.posicionLibre(posFin).setEnJuego(false);;
						return true;
					}
					else if (color == "Blanca" && colIni == 'h' && colFin == 'g' && par.posicionLibre(posFin) != null && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro") && (filaIni + 1) == filaFin)
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if(color == "Blanca" && (colIni ++ == colFin || colIni -- == colFin) && par.posicionLibre(posFin) != null && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro") && (filaIni + 1) == filaFin)
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					
					//Movimiento del peon NEGRO a una POSICION FINAL VACIA
					else if ((filaIni - 1) == filaFin && colIni == colFin && color == "Negro" && filaIni >= 2 && par.posicionLibre(posFin) == null )
					{
						return true;
					}
					
					//Movimiento del PEON NEGRO cuando come una pieza BLANCA
					
					else if (color == "Negro" && colIni == 'a' && colFin == 'b' && par.posicionLibre(posFin) != null && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca") && (filaIni - 1) == filaFin) 
					{					
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if (color == "Negro" && colIni == 'h' && colFin == 'g' && par.posicionLibre(posFin) != null && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca") && (filaIni - 1) == filaFin)
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					else if(color == "Negro" && (colIni ++ == colFin || colIni -- == colFin) && par.posicionLibre(posFin) != null && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca") && (filaIni - 1) == filaFin)
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
