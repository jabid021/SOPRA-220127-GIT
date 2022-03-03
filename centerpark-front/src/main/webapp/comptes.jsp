<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="util.Context" %>
	
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Lobster&display=swap"
	rel="stylesheet">
<link rel="icon" href="img/icon.jpg">
<link rel="stylesheet" href="style.css">
<title>Véhicules CenterPark</title>
</head>


<body>
	<header>
		<img
			src="https://previews.123rf.com/images/vicushka/vicushka1506/vicushka150600102/41061682-hojas-de-helecho-sobre-borrosa-fondo-bandera-naturaleza-para-el-sitio-web.jpg"
			alt="bannière"> <a href="index.html"><div id="logo"></div></a>
	</header>
	<main>
<% out.println("test"); %>
<%= "test" %>

		<input type="button" value="Ajouter" id="btnShowAddForm" class="btn btn-success">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Mail</th>
					<th>Password</th>
					<th>Tel</th>
					<th>Adresse</th>
					<th>Metier</th>
					<th>Type</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			
			<%
				List<Compte> comptes=Context.getSingleton().getDaoCompte().findAll();
			
				for(Compte c : comptes)
				{
					if(c instanceof Client)
					{
						Client client = (Client)c;
						out.println("<tr><td>"+client.getNumero()+"</td><td>"+client.getMail()+"</td><td>"+client.getPassword()+"</td><td>"+client.getTel()+"</td><td>"+client.getAdresse()+"</td><td>/</td><th>"+c.getClass().getSimpleName().toLowerCase()+"</th><th><input type='button' class='btn btn-warning'value='Modifier'><input type='button'class='btn btn-danger' value='Supprimer'></th></tr>");

					}
					else if(c instanceof Staff)
					{
						Staff staff = (Staff)c;
						out.println("<tr><td>"+staff.getNumero()+"</td><td>"+staff.getMail()+"</td><td>"+staff.getPassword()+"</td><td>/</td><td>/</td><td>"+staff.getMetier()+"</td><th>"+c.getClass().getSimpleName().toLowerCase()+"</th><th><input type='button' class='btn btn-warning'value='Modifier'><input type='button'class='btn btn-danger' value='Supprimer'></th></tr>");

					}
					
				}
			
			%>
		
			</tbody>
		</table>
		<hr>
		<br>
		<form id="addFormCompte">
			<div>
				Type compte : <input id="typeCompteClient" checked type="radio" name="typeCompte" value="client">
				Client <input id="typeCompteStaff" type="radio" name="typeCompte" value="staff">
				Staff
			</div>
			<div>
				Login : <input required type="text" placeholder="Saisissez un login">
			</div>
			<div>
				Password : <input required type="password"
					placeholder="Saisissez un password">
			</div>
			
			<div id="addClient">
				<div>Tel : <input  type="text" placeholder="Saisissez le tel"> </div>
				<div>Numero : <input  type="text" placeholder="Saisissez le numero"> </div>
				<div>Voie : <input  type="text" placeholder="Saisissez la voie"> </div>
				<div>CP : <input  type="text" placeholder="Saisissez le CP"> </div>
				<div>Ville : <input  type="text" placeholder="Saisissez la ville"> </div>
			</div>
			
			<div id="addStaff">
				<div>Metier : <input  type="text" placeholder="Saisissez le metier"> </div>
			</div>

			<input type="submit" class="btn btn-success mb-2"
				value="Ajouter un compte">
		</form>

	</main>
</body>

</html>

<script>

typeCompteClient.onchange=showFormClient;
typeCompteStaff.onchange=showFormStaff;
btnShowAddForm.onclick=function(){$("#addFormCompte").show();}
function showFormClient()
{
	$("#addClient").show();
	$("#addStaff").hide();
}

function showFormStaff()
{
	$("#addClient").hide();
	$("#addStaff").show();
}
</script>