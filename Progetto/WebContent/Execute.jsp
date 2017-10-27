<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risolutore problemi</title>
<link href="styleExecute.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="Servlet2" method="Post" id="freezer">

<!--  <div id="go">
	<input type="submit" value ="Esegui" id="bottoneazione">
</div> -->

<%
	int i;
	int n=(int)request.getAttribute("n");
	String domanda=(String)request.getAttribute("domanda");
	String[] scelte = (String[])request.getAttribute("scelte");
	if(n != 0)
		out.print("<div id=\"go\"> <input type=\"submit\" value =\"Esegui\" id=\"bottoneazione\"> </div> ");
%>

</form>

<%
/*
	int i;
	int n=(int)request.getAttribute("n");
	String domanda=(String)request.getAttribute("domanda");
	String[] scelte = (String[])request.getAttribute("scelte");
	*/
%>

<div id="domanda">
<%
	out.println(domanda + "\n");
%>
</div>
<div id="scelte">
<%
	for(i=0;i<n;i++)
	{
		out.println("<input type=\"radio\" name=\"azione\" value=\""+scelte[i]+"\" form=\"freezer\">"+ scelte[i]+"<br>");
	}
	
	%>
</div>
	
	<form action="Servlet2" method="Post" id="crilin"> 
		
	
	
	<% 
		int n2=(int)request.getAttribute("n2");
		String[] percorso =(String[])request.getAttribute("percorso");
		if(n2==0)
		{}
		else
		{
			if(n==0)
			{}
			else
			{
				%>
			<div id="contenitore">
			<div id="torna">
				<%
				out.println("<input type=\"submit\"  id=\"bottonetorna\" value=\"Torna\">");
				%>
			</div>
			<div id="select">
				<%
				out.println("<select class=\"w3-select\" name=\"indietro\" form=\"crilin\" id=\"selezione\">");
				for(i=0;i<n2;i++){
					out.print("<option value=\"" + percorso[i] +"\">" + percorso[i] + "</option>");
					}
			
					}
				}
				%>
				</select>
			</div>
			</div>
	</form>
	<form action="Servlet2" method="Post" id="majin bu">
	<div id="home">
		<input type="submit" name="azione" value ="Home" form="majin bu" id="bottonehome">
	</div>
	</form>
	<form action="Servlet2" method="Post" id="c17">
	<%
		if(n2==0)
		{}
		else
		{
	%>
	<div id="indietro">
	<%
		out.println("<input type=\"submit\" name=\"azione\" value =\"Indietro\" form=\"c17\" id=\"bottoneindietro\">");
	%>
	</div>
	<%
	}
	%>
	</form>
</body>
</html>