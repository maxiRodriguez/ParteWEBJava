package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Jugador;
import Entidades.Partida;

public class CatalogoPartida {
	
	//Devuelve la partida de los 2 jugadores
	public Partida getByJugadores(Jugador j1, Jugador j2){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Partida p = null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idPartida, dniJ1, dniJ2, turno from partida where dniJ1 = ? and dniJ2 = ?");
			stmt.setString(1, j1.getDni());
			stmt.setString(2, j2.getDni());

			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				p = new Partida();
				p.setIdPartida(rs.getInt("idPartida"));
				p.setJ1(j1);
				p.setJ2(j2);
				p.setTurno(rs.getString("turno"));
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
		return p;
	}
	
	
	//Agrega la partida a la DB
	public void add(Partida partida){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into partida(dniJ1, dniJ2, turno) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS
				   );
			
			stmt.setString(1, partida.getJ1().getDni());
			stmt.setString(2, partida.getJ2().getDni());
			stmt.setString(3, partida.getTurno());
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			//VER EL TEMA DEL ID AUTOINCREMENTAL
			if(rs!=null && rs.next()){
				partida.setIdPartida(rs.getInt(1));
			}
			
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

	
	
	public Partida getById(Jugador j1, Jugador j2) {		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Partida p=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idPartida, dniJ1, dniJ2, turno from partida where dniJ1 = ? and dniJ2 = ?"
					);
			stmt.setString(1, j1.getDni());
			stmt.setString(2, j2.getDni());
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				p=new Partida();
				p.setIdPartida(rs.getInt("idPartida"));
				p.setJ1(j1);
				p.setJ2(j2);
				p.setTurno(rs.getString("turno"));				
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
		return p;
	}

	
	//Actualiza la partida que fue recuperada
	public void update(Partida p2) {
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					 "update partida set turno=? where idPartida=?"
					);
			
			stmt.setString(1, p2.getTurno());
			stmt.setInt(2, p2.getIdPartida());
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
	
	
	//Borra la partida de la DB
	public void delete(Partida p){
		PreparedStatement stmt=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					  "delete from partida where idPartida=?"
					);
			stmt.setInt(1, p.getIdPartida());
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
