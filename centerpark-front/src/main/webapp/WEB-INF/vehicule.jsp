<title>Gestion des Vehicules</title>
<main>

	<input type="button" value="Ajouter" id="btnShowAddForm" class="btn btn-success">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Modele</th>
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
				<td>Modele :</td>
				<td><input required type="text" name="modele"
					placeholder="Saisissez un modele"></td>
				<td><input type="submit" class="btn btn-success mb-2"
					value="Ajouter un vehicule"></td>
			</tr>
		</table>
	</form>
	<br> <br>

</main>
<script>
btnShowAddForm.onclick=function(){$("#addFormVehicule").show();}
</script>