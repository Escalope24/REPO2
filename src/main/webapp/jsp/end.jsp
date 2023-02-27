<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
    <style type="text/css">
		body {
			background:black;
			color:limegreen;
		}
    </style>
</head>
<body>
	<h1>${Attempts} intentos sobrantes</h1>

    <form action="/search" method="post">
        <input type="numer"  name="number" id="number" class="form-control" placeholder="Buscador de intentos" style="width: 225px;">
        <button type="submit" class="btn btn-warning">Buscar intento</button>
    </form>


    <c:if test="${pos>0}">
        <h4>En la posicion ${pos} se encuentra la palabra: ${word}</h4>
    </c:if>
</body>
</html>