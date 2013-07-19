<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<title>Resultado BlueSoft</title>
</head>
<body bgcolor="lightblue">
	<form action="resultado" method="post">
		<center>
			<h3>Votações dos Filmes</h3>
			<table border="1">
				<tr bgcolor="red">
					<h5><td>
							<center>Filme</center>
							</center>
						</td>
						<td>Qt Votos</td>
					</h5>
				</tr>
				<input type="text" name="parametro" value=""  style="display:none"/>
				<c:forEach items="${filmes}" var="filme">
					<tr>
						<td>${filme.nome_Filme}
							</h6>
						</td>
						<td>${filme.qtvoto}</td>
					</tr>
				</c:forEach>
				</tr>

			</table>
			<br />
			<input type="submit" value="Voltar">
		</center>
	</form>

</body>
</html>