package Entidades;

import javax.swing.JOptionPane;

public class Reina extends Pieza {
	
	@Override
	public boolean esMovimientoValido(String posIni, String posFin, String color, Partida par, String colorTurno) {
		
		Integer filaIni = Integer.parseInt(RecuperarFila(posIni));
		char colIni = RecuperarColumna(posIni).charAt(0);
		
		Integer filaFin = Integer.parseInt(RecuperarFila(posFin));
		char colFin = RecuperarColumna(posFin).charAt(0);
		
		Torre t = null;
        Alfil a = null;        
        
        if(color.equals(colorTurno)) {
	        if (filaFin >= 1 && filaFin <= 8 && colFin >= 'a' && colFin <= 'h')
			{
				if(t.esMovimientoValido(posIni, posFin, color, par, colorTurno) || a.esMovimientoValido(posIni, posFin, color, par, colorTurno))
				{
					return true;
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
