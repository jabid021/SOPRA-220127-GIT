<!--
Afficher un tableau avec une liste de vehicule (id,model) (modifier + Suppr)
Bouton ajouter pour avoir acces au formulaire d'ajout (nom + model)
Modifier aura un lien vers la page updateVehicule.html?id=x
 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!--<%@ include file="banniere.jsp" %>-->
	

<title>Gestion des comptes</title>
<main>

	<input type="button" value="Ajouter" class="btn btn-sucess">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Modèle</th>
				<th scope="col">Modification</th>
				<th scope="col">Suppresion</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Jeep</td>
				<td><a href="vehicule?id=1"><input type="button"
						class="btn btn-warning" value="Modifier" /></a></td>
				<td><input type="submit" class="btn btn-danger"
					value="Supprimer"></td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Range</td>
				<td><a href="updateVehicule.html"><input type="button"
						class="btn btn-warning" value="Modifier" /></a></td>
				<td><input type="submit" class="btn btn-danger"
					value="Supprimer"></td>

			</tr>
		</tbody>
	</table>
	<hr>
	<br>
	<form action="vehicule" method="post" id="addFormVehicule">
		<input type="hidden" name="tache" value="insert">
		<table>
			<tr>
				<td>Modèle :</td>
				<td><input required type="text" name="modele" placeholder="Saisissez un modèle"></td>
				<td><input type="submit" class="btn btn-success mb-2"
					value="Ajouter un véhicule"></td>
			</tr>
		</table>
	</form>
	<br> <br>

</main>

