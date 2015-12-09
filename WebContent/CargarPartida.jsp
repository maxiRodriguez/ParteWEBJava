<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	 <form class="form-cargarPartida"  action="cargarPartida" method="post">
	 	<h1>Cargar Partida</h1>
	 
		<label for="dniJug1">Dni Jugador 1:</label>
		<input type= "text" name ="dniJug1" id="dniJug1" autofocus="autofocus" /></br></br>
		
		<label for="dniJug2">Dni Jugador 2:</label>
		<input type="text" name="dniJug2" id="dniJug2" /></br></br>	
		 <button class="btnCargarPartida" type="submit">Cargar Partida</button>
	 </form>
</div>
</body>
</html>