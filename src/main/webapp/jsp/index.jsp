<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
	<!-- declaracion style css -->
	<style type="text/css">
		body {
			background:black;
			color:limegreen;
		}
		.principal{
			align-items: center;
			display: flex;
			justify-content: center;
		}
		h1{
			font-size: 40px;
		}
		.divTable{
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			padding-top: 50px;
		}
		.table{
			border: 1px solid limegreen;
			width: 50%;
		}
		.formulario{
			display: flex;
			flex-direction: row;
		}
		.history{
			display: flex;
			flex-direction: column;
			justify-content: left;
			margin-top: 40px;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4"></div>
			<div class=" col-4 principal">
				<h1>Wordle Salesianos </h1>
			</div>
			<div class="col-4"></div>
		</div>
	</div>
<div class="container">
	<div class="row">
		<div class="col">
			<div class="divTable">
				<table class="table">
					<tr>
						<c:forEach var="word" items="${history2}">
							<c:if test="${word.correct}">
								<c:if test="${word.position == word.correctPosition}">
									<td style="background-color:green; color:black; font-weight: bold">${word.letter}</td> 
								</c:if>
								<c:if test="${word.position != word.correctPosition}">
									<td style="background-color:yellow; color:black; font-weight: bold">${word.letter}</td> 
								</c:if>
							</c:if>
							<c:if test="${word.position!=word.correctPosition && !word.correct}">
								<td style="background-color:red; color:black; font-weight: bold">${word.letter}</td> 
							</c:if>
						</c:forEach>
					</tr>
						<tr>
							<c:forEach var="word" items="${word}">
								<c:if test="${word.correct}">
									<c:if test="${word.position == word.correctPosition}">
										<td style="background-color:green; color:black; font-weight: bold">${word.letter}</td> 
									</c:if>
									<c:if test="${word.position != word.correctPosition}">
										<td style="background-color:yellow; color:black; font-weight: bold">${word.letter}</td> 
									</c:if>
								</c:if>
								<c:if test="${word.position!=word.correctPosition && !word.correct}">
									<td style="background-color:red; color:black; font-weight: bold">${word.letter}</td> 
								</c:if>
							</c:forEach>
						</tr>
				</table>
			</div>
		</div>
	</div>
</div>
	<c:if test="${Attempts > 0}">
		<div>
			<span class="attempts">	Intentos: ${Attempts}</span>	
		</div>
		<form action="/check" method="post" class="formulario">
			<input type="text"  name="word" id="word" class="form-control" placeholder="Inserte una palabra" style="width: 225px;">
			<button type="submit" class="btn btn-warning">Probar Palabra</button>
		</form>
	</c:if>
	<c:if test="${Attempts <= 0}">
		<h1>No tienes mas intentos</h1>
	</c:if>
	<div class="history">
		<c:forEach var="word" items="${history}">
			<h2>${word}</h2>
				<br>
				</c:forEach>	
	</div>
</body>
</html>