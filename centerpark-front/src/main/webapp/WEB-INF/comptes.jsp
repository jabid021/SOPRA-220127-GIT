<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>


	

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
			
			<c:forEach items="${listeCompte}" var="compte">
			
			<c:choose>
				<c:when  test="${compte.getClass().getSimpleName()=='Client'}">
				<tr>
					<td>${compte.numero}</td>
					<td>${compte.mail}</td>
					<td>${compte.password}</td>
					<td>${compte.tel}</td>
					<td>${compte.adresse.numero} ${compte.adresse.voie}, ${compte.adresse.cp}, ${compte.adresse.ville}</td>
					<td>/</td>
					<td>${compte.getClass().getSimpleName().toLowerCase()}</td>
					<td>
						<a href='compte?id=${compte.numero}'>
							<input type='button' class='btn btn-warning'value='Modifier'>
						</a>
						<form action='compte' method='post'>
							<input type='hidden' name='tache' value='delete'>
							<input name='id' type='hidden' value='${compte.numero}'>
							<input type='submit'class='btn btn-danger' value='Supprimer'>
						</form>
					</td>
				</tr>
			</c:when>
			
			<c:otherwise>
			
				<tr>
					<td>${compte.numero}</td>
					<td>${compte.mail}</td>
					<td>${compte.password}</td>
					<td>/</td>
					<td>/</td>
					<td>${compte.metier}</td>
					<td>${compte.getClass().getSimpleName().toLowerCase()}</td>
					<td>
						<a href='compte?id=${compte.numero}'>
							<input type='button' class='btn btn-warning'value='Modifier'>
						</a>
						<form action='compte' method='post'>
							<input type='hidden' name='tache' value='delete'>
							<input name='id' type='hidden' value='${compte.numero}'>
							<input type='submit'class='btn btn-danger' value='Supprimer'>
						</form>
					</td>
				</tr>
				
			</c:otherwise>
			
			</c:choose>
			
			</c:forEach>
	
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