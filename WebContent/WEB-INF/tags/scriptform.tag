	<script type="text/javascript">
            function validaForm() {
            	var d=document.formularioContato;
            	if (d.campoNome.value=="" || d.campoNome.value==null || d.campoNome.value.length < 4){
            		alert ("Nome invalido!" );
            		d.campoNome.focus();
            		return false; 
            	}
            	if ( d.campoeMail.value=="" || d.campoeMail.value.indexOf('@')==-1 || d.campoeMail.value.indexOf('.')==-1 )	{
      				alert( "Por favor, informe um E-MAIL válido!" );
            		d.campoeMail.focus();
       				return false;
            	}
            }
    </script>
