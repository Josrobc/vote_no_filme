<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BlueSoft</title>
</head>
<body bgcolor="lightblue">
	<center>
		<br /><br /><br />
		<h1>BlueSoft</h1>
		<form method="post">
			<style>
				select{
				 background:white;
				}
			</style>
			<select size="1" name="selectfilmes" >
				<option selected value="${value}">${title}</option>
				<c:forEach items="${filmes}" var="filme">
					<option value="${filme.id}">${filme.nome_Filme}</option>
				</c:forEach>
			</select> 
			<br /> <br />
			<input type="submit" value="Votar" >
			<br />
		</form>
	</center>
</body>
</html>