package Entidades;

import javax.swing.JOptionPane;

public class Alfil extends Pieza {


	@Override
	public boolean esMovimientoValido(String posIni, String posFin, String color, Partida par, String colorTurno) {
		Integer filaIni = Integer.parseInt(RecuperarFila(posIni));
		char colIni = RecuperarColumna(posIni).charAt(0);
		
		Integer filaFin = Integer.parseInt(RecuperarFila(posFin));
		char colFin = RecuperarColumna(posFin).charAt(0);
		
		// diferencia entre filas y columnas para el movimiento
        int difFil, difCol;

        difFil = Math.abs(filaFin - filaIni);
        difCol = Math.abs(colFin - colIni);
        
        if(color.equals(colorTurno)) {
	        if (filaFin >= 1 && filaFin <= 8 && colFin >= 'a' && colFin <= 'h') 
	        {
	        	//un valor igual para ambas diferencias indica un moviento en diagonal
	            if ((difFil == difCol))
	            {
	            	if(par.posicionLibre(posFin) == null)
	            	{
	            		return true;
	            	}
	            	else if (color == "Blanca" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Negro"))
	            	{
	            		par.posicionLibre(posFin).setEnJuego(false);
	            		return true;
	            	}
	            	else if (color == "Negro" && par.posicionLibre(posFin).getColor().equalsIgnoreCase("Blanca"))
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
