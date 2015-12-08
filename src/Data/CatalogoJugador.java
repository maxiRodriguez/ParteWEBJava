package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Jugador;

public class CatalogoJugador {
	
	//Busca el jugador por el DNI
	public Jugador getByDni(String dni){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Jugador j = null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select dni, nombre, apellido from jugadores where dni = ?"
					);
			
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			
			if(rs !=null && rs.next()){
				j=new Jugador();
				j.setDni(rs.getString("dni"));
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));			
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
		return j;
	}
	

}
