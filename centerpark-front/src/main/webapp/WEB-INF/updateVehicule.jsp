<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<title>Modifier Vehicule</title>
	<main>
	<form action="vehicule" method="post" id="updateFormVehicule">
		<input type="hidden" name="tache" value="update">
		<input type="hidden" name="id" value="${vehicule.id}">
		<div class="form-group">
			<label for="exampleInputEmail1">ID :</label> <input type="text"
				class="form-control" id="id_vehicule" value="${vehicule.id}" readonly>

		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Modele</label> <input required type="text"
				class="form-control" name="modele" value="${vehicule.model}" placeholder="Saisissez le modèle">
		</div>

		<input type="submit" class="btn btn-success"
			value="Modifier les infos"> <a href="vehicule"><button
				type="button" class="btn btn-danger">Annuler</button></a>

	</form>
</main>