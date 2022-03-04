<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Gestion des activites</title>

<main>

	<h2 align="center">Activites CenterPark</h2>
	<table style="width: 100%" border align="center" id="activites">
		<thead>
			<tr align="center">
				<th>Id</th>
				<th>Date</th>
				<th>Heure</th>
				<th>Prix</th>
				<th>Meteo</th>
				<th>Type</th>
				<th>Vehicule</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${activites}" var="a">
				<c:choose>
					<c:when test="${a.getClass().getSimpleName()=='Aquatique'}">
						<tr>
							<td>${a.id}</td>
							<td>${a.date}</td>
							<td>${a.heure}</td>
							<td>${a.prix}</td>
							<td>${a.meteo}</td>
							<td>Aquatique</td>
							<td>null</td>
							<td><a href='activite?id=${a.id}'><input
									type='button' class='btn btn-warning' value='Modifier'></a>
								<form action='activite' method='post'>
									<input type='hidden' name='tache' value='delete'> <input
										name='id' type='hidden' value='${a.id}'> <input
										type='submit' class='btn btn-danger' value='Supprimer'>
								</form></td>
						</tr>
					</c:when>
					<c:when test="${a.getClass().getSimpleName()=='Safari'}">
						<tr>
							<td>${a.id}</td>
							<td>${a.date}</td>
							<td>${a.heure}</td>
							<td>${a.prix}</td>
							<td>${a.meteo}</td>
							<td>Safari</td>
							<td>${a.vehicule}</td>
							<td><a href='activite?id=${a.id}'><input
									type='button' class='btn btn-warning' value='Modifier'></a>
								<form action='activite' method='post'>
									<input type='hidden' name='tache' value='delete'> <input
										name='id' type='hidden' value='${a.id}'> <input
										type='submit' class='btn btn-danger' value='Supprimer'>
								</form></td>
						</tr>
					</c:when>

				</c:choose>


			</c:forEach>
		</tbody>

		</tbody>
		<tfoot>
		</tfoot>

	</table>


	<br>
	<div id="ajouter">
		<input type="button" value="Ajouter" id="btnShowAddForm" class="btn btn-info button">
	</div>
	<br> <br>


	<form action="activite" method="post" id="addFormActivite">
		<input type="hidden" name="tache" value="insert">
		<div>
			Type activite : <input checked id="typeActiviteAquatique"
				type="radio" name="typeActivite" value="aquatique">Aquatique
			<input id="typeActiviteSafari" type="radio" name="typeActivite"
				value="safari">Safari
		</div>
		<div>
			Date : <input required type="date" name="date">
		</div>
		<div>
			Heure : <input required type="time" placeholder="Saisir une heure"
				name="heure">
		</div>
		<div>
			Prix : <input name=prix type="number" placeholder="prix" min=0
				max=999 step=0.01>€
		</div>
		<div>
			Meteo : <select name=meteo>
				<c:forEach items="${meteos}" var="m">
					<option>${m}</option>
				</c:forEach>
			</select>
		</div>


		<div id="addSafari" style="display: none">
			<div>
				Vehicule : <select name=vehicule>
					<c:forEach items="${vehicules}" var="v">
						<option value="${v.id}">${v.model}</option>
					</c:forEach>
				</select>
			</div>
		</div>


		<input type="submit" class="btn btn-success mb-2"
			value="Ajouter une activite"> <input type="reset"
			class="btn btn-danger button">

	</form>

</main>

<script>
	typeActiviteAquatique.onchange = showFormActivite;
	typeActiviteSafari.onchange = showFormSafari;
	btnShowAddForm.onclick = function() {
		$("#addFormActivite").show();
	}
	function showFormActivite() {
		$("#addSafari").hide();
	}

	function showFormSafari() {
		$("#addSafari").show();
	}
</script>