<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.*"%>
<%@ page import="util.Context"%>
<!--<%@ include file="banniere.jsp" %>-->


<title>Gestion des activites</title>

<main>

	<h2 align="center">Activités CenterPark</h2>
	<table style="width: 100%" border align="center" id="activites">
		<thead>
			<tr align="center">
				<th>Id</th>
				<th>Date</th>
				<th>Heure</th>
				<th>Prix</th>
				<th>Meteo</th>
				<th>Type</th>
				<th>Véhicule</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>

			<%
				List<Activite> activites=Context.getSingleton().getDaoActivite().findAll();
			
				for(Activite a : activites)
				{
					if(a instanceof Aquatique)
					{
						Aquatique aqua = (Aquatique)a;
						out.println("<tr><td>"+aqua.getId()+"</td><td>"+aqua.getDate()+"</td><td>"+aqua.getHeure()+"</td><td>"+aqua.getPrix()+"</td><td>"+aqua.getMeteo()+"</td><td>"+aqua.getClass().getSimpleName()+"</td><td>null</td><th><a href='activite?id="+aqua.getId()+"'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='activite' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"+aqua.getId()+"'><input type='submit'class='btn btn-danger' value='Supprimer'></form></th></tr>");

					}
					
					else if(a instanceof Safari)
					{
						Safari safari = (Safari)a;
						out.println("<tr><td>"+safari.getId()+"</td><td>"+safari.getDate()+"</td><td>"+safari.getHeure()+"</td><td>"+safari.getPrix()+"</td><td>"+safari.getMeteo()+"</td><td>"+safari.getClass().getSimpleName()+"</td><td>"+safari.getVehicule()+"</td><th><a href='activite?id="+safari.getId()+"'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='activite' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"+safari.getId()+"'><input type='submit'class='btn btn-danger' value='Supprimer'></form></th></tr>");

					}
					
				}
			
			%>

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
					<option value="1">Jeep</option>
					<option value="2">Range</option>
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