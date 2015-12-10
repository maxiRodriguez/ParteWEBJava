<%@page import="Data.CatalogoPartida"%>
<%@page import="Entidades.Partida"%>
<%@page import="Controlador.CtrlPartida"%>
<%@page import="Entidades.Pieza"%>
<%@page import= "java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajedrez</title>
</head>
<body>
	<h1> Partida Ajederez </h1>
	
	<% Partida p = (Partida) session.getAttribute("partSession");%>
	
	<div>
		<p>Turno : <%=p.getTurno() %></p>
	    	<div>
	     	 <p>Piezas Blancas </p>
	    	<%
			ArrayList<Pieza> b = p.getBlancas();
			for (Pieza a : b){
			
				if("Blanca".equals(a.getColor()))
					{
						out.println(a.getNombre()+ " " + a.getPosicion() +"<br/>");
					}
							 }
			%>
	        </div>
	        
	        <div>
	     	 <p>Piezas Negras </p>
	    	<%
			ArrayList<Pieza> c = p.getNegras();
			for (Pieza a : c){
			
				if("Negro".equals(a.getColor()))
					{
						out.println(a.getNombre()+ " " + a.getPosicion() +"<br/>");
					}
							 }
			%>
	        </div>
	        
	        <form class="form-movimiento" name="formMover" action="moverPieza" method="post">
			        <label for="Origen">Origen : </label>
			        <input name="Origen" type="text" autofocus="autofocus" id="Origen" size="1" maxlength="2" style="text-align:center" />
			        </br></br>
			        <label for="Destino">Destino:</label>
			        <input name="Destino" type="text" autofocus="autofocus" id="Destino" size="1" maxlength="2" style="text-align:center" />
			        </br></br>
			        <input type="reset" value="Limpiar" />
			        <input name="mover" type="submit" id="mover"  value="Mover" />
		        </form>
	        
	</div>>
	
</body>
</html>