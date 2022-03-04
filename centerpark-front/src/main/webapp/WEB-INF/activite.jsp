
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

			

		</tbody>

		</tbody>
		<tfoot>
		</tfoot>

	</table>


	<br>
	<div id="ajouter">
		<input type="button" value="Ajouter" class="btn btn-info button">
	</div>
	<br> <br>


	<form action="activite" method="post" id="addFormActivite">
		<input type="hidden" name="tache" value="insert">
		<div>
			Type activite : <input checked id="typeActiviteAquatique" type="radio" name="typeActivite" value="aquatique">Aquatique
			<input id="typeActiviteSafari" type="radio" name="typeActivite" value="safari">Safari
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
				max=999 step=0.01> €
		</div>
		<div>
			Météo : <select name=meteo>
				<option>Soleil</option>
				<option>Pluie</option>
				<option>Neige</option>
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
			value="Ajouter une activité"> 
		<input type="reset"
			class="btn btn-danger button">

	</form>

</main>

<script>

typeActiviteAquatique.onchange=showFormActivite;
typeActiviteSafari.onchange=showFormSafari;
btnShowAddForm.onclick=function(){$("#addFormActivite").show();}
function showFormActivite()
{
	$("#addSafari").hide();
}

function showFormSafari()
{
	$("#addSafari").show();
}
</script>