<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<link href="styleHome.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="Servlet1" method="post" id="cel">

<br><br>
<div id="titolo">
<font>RISOLUTORE DI PROBLEMI</font>
</div>
<br><br>

<div id="sottotitolo" align="center">
<font>Selezionare un oggetto</font>
</div>

<div id="contenitore" align="center">
	<select name="popo" form="cel" style="width:150px;height: 50px">
	<%
	int i;
	int n=(int)request.getAttribute("num");
	String[] elenco=(String[])request.getAttribute("ele");
	for(i=0;i<n;i++)
	{
		out.println("<option value=\""+elenco[i]+"\">"+elenco[i]+"</option>");
	}
	%>



	<input type="submit" value="Vai" id="bottonevai" style="width:80px;height: 50px" >
</div>

  </select>
</form>
</body>
</html>