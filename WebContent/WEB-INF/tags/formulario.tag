	<form name="formularioContato" id="cadastro" action="cadastro" method="post" onsubmit="return validaForm();">
		<center>
			<table border="1">
				<tr>
					<td>
					<input type="text" name="id" value="1"  style="display:none"/>
					<label>Nome:    </label>   
					<br />
					<input type="text" name="campoNome"  id="nome"  /> 
					<br /> <br /> 
					<label>E-mail:</label>
					<br />
					<input type="text" name="campoeMail" id="eMail" />
					</td>
				</tr>
			</table>
			<input type="submit" class="submit" value="Cadastrar">
		</center>
		<br />
	</form>
