<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Importando classes para poder utiliza-las -->
<%@ page import="entidadeDAO.AlunoDAO"%> 
<%@ page import="entidades.Aluno"%>    
<%@ page import="interfaces.InterfaceDAO"%> 

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

</head>

<body>
	<% 
		Aluno aluno = new Aluno();
		
		if (new AlunoDAO().salvaAlunoBD(aluno))
		{
			response.sendRedirect("cadastraalunojspsalvo");
		}
		else
		{
			response.sendRedirect("cadastraalunojspNAOsalvo");
		}
	%>
</body>

</html>