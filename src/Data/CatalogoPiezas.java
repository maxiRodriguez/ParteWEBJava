package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.StyleContext.SmallAttributeSet;

import Entidades.*;

public class CatalogoPiezas {
	
	//Recuperar de la DB todas las piezas de la partida
	public ArrayList<Pieza> getPiezas(int idPartida, String color){
		
		ArrayList<Pieza> piezas = new ArrayList<Pieza>();
		String nom;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre, color, estado, posicion from piezas where idPartida = ? and color = ?");
			stmt.setInt(1, idPartida);
			stmt.setString(2, color);
			rs = stmt.executeQuery();
			while(rs !=null && rs.next()){
				Pieza p = null;
				nom = rs.getString("nombre");
				switch (nom) {
				case "Peon":
					p = new Peon();					
					break;
					
				case "Torre":
					p = new Torre();
					break;
					
				case "Alfil":
					p = new Alfil();
					break;
					
				case "Caballo":
					p = new Caballo();
					break;
					
				case "Rey":
					p = new Rey();
					break;
					
				case "Dama":
					p = new Reina();
					break;

				default:
					break;
				}
				p.setColor(rs.getString("color"));
				p.setEnJuego(rs.getBoolean("estado"));
				p.setPosicion(rs.getString("posicion"));
				p.setNombre(rs.getString("nombre"));
				piezas.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}

		return piezas;
	}
	
	//Guardar las piezas en la DB
	public void add(Pieza p, Partida partida){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {

			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into piezas(idPartida, nombre, color, estado, posicion) values (?,?,?,?,?)"
				   );
			
			stmt.setInt(1, partida.getIdPartida());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getColor());
			stmt.setBoolean(4, p.isEnJuego());
			stmt.setString(5, p.getPosicion());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}
	}

	public void update(Pieza pieza, Partida p2) {
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					 "update piezas set estado=?, posicion=? where idPartida=? and nombre=?"
					);
			
			stmt.setBoolean(1, pieza.isEnJuego());
			stmt.setString(2, pieza.getPosicion());
			stmt.setInt(3, p2.getIdPartida());
			stmt.setString(4, pieza.getNombre());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}
		
	}

}
