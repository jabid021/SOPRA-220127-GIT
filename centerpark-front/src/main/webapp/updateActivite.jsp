<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html>

<title>Gestion des activites</title>

<main align="center">

	<h1>Mise à jour de l'activité</h1>

	<form action="activite" method="post" id="updateFormActivite">
		<input type="hidden" name="tache" value="update"> 
		<!-- >input type="hidden" name="typeActivite" value="aquatique">-->
		<input type="hidden" name="id" value="${activite.id}">
		<table align="center">
			<tr>
				<td>Date :</td>
				<td><input required name=date type="date" value="${activite.date}"></td>
			</tr>
			<tr>
				<td>Heure :</td>
				<td><input name=heure type="time" value="${activite.heure}"></td>
			</tr>

			<tr>
				<td>Prix :</td>
				<td><input name=prix type="number" placeholder="prix" value="${activite.prix}" min=0
					max=999 step=0.01> €</td>
			</tr>

			<tr>
				<td>Météo :</td>
				<td><select name="meteo">
						<option selected>Pluie</option>
						<option>Soleil</option>
						<option>Neige</option>
				</select></td>
			</tr>

			<tr>
				<td>Activité :</td>
				<td><select name="typeActivite">
						<option>Aquatique</option>
						<option selected>Safari</option>
				</select></td>
			</tr>

			<tr>
				<td>Véhicule :</td>
				<td><select name="vehicule">
						<option>null</option>
						<option selected value="1">Jeep</option>
						<option value="2">Range</option>
				</select></td>
			</tr>
		</table>

		<br> <br>


		<div>
			<input type="submit" value="Valider" class="btn btn-success button">
			<input type="reset" class="btn btn-danger button"> <a
				href="activite.jsp"><input type="button" value="Retour"
				class="btn btn-primary button"></a>
		</div>

	</form>