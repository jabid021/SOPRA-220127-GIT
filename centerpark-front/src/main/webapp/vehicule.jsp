<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.*"%>
<%@ page import="util.Context"%>
<!--<%@ include file="banniere.jsp" %>-->


<title>Gestion des comptes</title>
<main>

	<input type="button" value="Ajouter" class="btn btn-sucess">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Modèle</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Vehicule> vehicules = Context.getSingleton().getDaoVehicule().findAll();

			for (Vehicule v : vehicules) {
				out.println("<tr><td>" + v.getId() + "</td><td>" + v.getModel() + "</td><th><a href='vehicule?id=" + v.getId()
				+ "'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='vehicule' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"
				+ v.getId() + "'><input type='submit' class='btn btn-danger' value='Supprimer'></form></th></tr>");

			}
			%>
		</tbody>
	</table>
	<hr>
	<br>
	<form action="vehicule" method="post" id="addFormVehicule">
		<input type="hidden" name="tache" value="insert">
		<table>
			<tr>
				<td>Modèle :</td>
				<td><input required type="text" name="modele"
					placeholder="Saisissez un modèle"></td>
				<td><input type="submit" class="btn btn-success mb-2"
					value="Ajouter un véhicule"></td>
			</tr>
		</table>
	</form>
	<br> <br>

</main>