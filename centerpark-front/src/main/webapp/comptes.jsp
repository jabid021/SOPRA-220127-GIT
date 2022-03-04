<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="util.Context" %>
<!--<%@ include file="banniere.jsp" %>-->
	

<title>Gestion des comptes</title>
<main>
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
			out.println("ttttt");
			
			
				List<Compte> comptes=Context.getSingleton().getDaoCompte().findAll();
				out.println(comptes);
			
				for(Compte c : comptes)
				{
					if(c instanceof Client)
					{
						Client client = (Client)c;
						out.println("<tr><td>"+client.getNumero()+"</td><td>"+client.getMail()+"</td><td>"+client.getPassword()+"</td><td>"+client.getTel()+"</td><td>"+client.getAdresse()+"</td><td>/</td><th>"+c.getClass().getSimpleName().toLowerCase()+"</th><th><a href='compte?id="+client.getNumero()+"'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='compte' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"+c.getNumero()+"'><input type='submit'class='btn btn-danger' value='Supprimer'></form></th></tr>");

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
		<form action="compte" method="post" id="addFormCompte">
			<input type="hidden" name="tache" value="insert">
			<div>
				Type compte : <input id="typeCompteClient" checked type="radio" name="typeCompte" value="client">
				Client <input id="typeCompteStaff" type="radio" name="typeCompte" value="staff">
				Staff
			</div>
			<div>
				Mail : <input required type="text" name="mail" placeholder="Saisissez un mail">
			</div>
			<div>
				Password : <input required type="password"
					placeholder="Saisissez un password" name="password">
			</div>
			
			<div id="addClient">
				<div>Tel : <input  type="text" name="tel" placeholder="Saisissez le tel"> </div>
				<div>Numero : <input  type="text" name="numero" placeholder="Saisissez le numero"> </div>
				<div>Voie : <input  type="text" name="voie" placeholder="Saisissez la voie"> </div>
				<div>CP : <input  type="text" name="cp" placeholder="Saisissez le CP"> </div>
				<div>Ville : <input  type="text" name="ville" placeholder="Saisissez la ville"> </div>
			</div>
			
			<div id="addStaff">
				<div>Metier : <input  type="text" name="metier" placeholder="Saisissez le metier"> </div>
			</div>

			<input type="submit" class="btn btn-success mb-2"
				value="Ajouter un compte">
		</form>

	</main>

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