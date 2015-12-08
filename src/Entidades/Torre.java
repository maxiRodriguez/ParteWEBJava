package Entidades;

import javax.swing.JOptionPane;

public class Torre extends Pieza {
	
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
					if((filaIni == filaFin || colIni == colFin) && par.posicionLibre(posFin) == null)
					{
						return true;
					}
					//Torre BLANCA come pieza NEGRA
					else if((filaIni == filaFin || colIni == colFin) && par.posicionLibre(posFin) != null && color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro"))
					{
						par.posicionLibre(posFin).setEnJuego(false);
						return true;
					}
					//Torre NEGRA come pieza BLANCA
					else if((filaIni == filaFin || colIni == colFin) && par.posicionLibre(posFin) != null && color == "Negro" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca"))
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
