<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<title>Gestion des animaux</title>


<main align="center">
	<h1 style="text-align: center;">Liste des animaux</h1>
	<br> <br>
	<div id="tableau">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id Animal</th>
					<th>Nom</th>
					<th>Type Animal</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach items="${listeAnimal}" var="animal">

					<c:choose>

						<c:when test="${animal.getClass().getSimpleName()=='Sanglier'}">
							<tr>
								<td>${animal.id}</td>
								<td>${animal.nom}</td>
								<td>${animal.getClass().getSimpleName()}</td>
								<td><a href='animal?id=${animal.id}'> <input
										type='button' class='btn btn-warning' value='Modifier'>
								</a>
									<form action='animal' method='post'>
										<input type='hidden' name='tache' value='delete'> <input
											name='id' type='hidden' value='${animal.id}'> <input
											type='submit' class='btn btn-danger' value='Supprimer'>
									</form></td>
							</tr>
						</c:when>

						<c:when test="${animal.getClass().getSimpleName()=='Serpent'}">
							<tr>
								<td>${animal.id}</td>
								<td>${animal.nom}</td>
								<td>${animal.getClass().getSimpleName()}</td>
								<td><a href='animal?id=${animal.id}'> <input
										type='button' class='btn btn-warning' value='Modifier'>
								</a>
									<form action='animal' method='post'>
										<input type='hidden' name='tache' value='delete'> <input
											name='id' type='hidden' value='${animal.id}'> <input
											type='submit' class='btn btn-danger' value='Supprimer'>
									</form></td>
							</tr>
						</c:when>

						<c:otherwise>

							<tr>
								<td>${animal.id}</td>
								<td>${animal.nom}</td>
								<td>${animal.getClass().getSimpleName()}</td>
								<td><a href='animal?id=${animal.id}'> <input
										type='button' class='btn btn-warning' value='Modifier'>
								</a>
									<form action='animal' method='post'>
										<input type='hidden' name='tache' value='delete'> <input
											name='id' type='hidden' value='${animal.id}'> <input
											type='submit' class='btn btn-danger' value='Supprimer'>
									</form></td>
							</tr>

						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tbody>
		</table>


	</div>

	<div>
		<form action="animal" method="post">
			<input type="hidden" name="tache" value="insert">

			<fieldset>
				<legend>Ajouter un animal</legend>


				<table align="center">



					<tr>
						<th>Nom</th>
						<td><input required type="text" name="nom"
							placeholder="Saisissez un nom"></td>
					</tr>

					<tr>
						<th>Type Animal</th>
						<td><select name="typeAnimal">
								<option value="Sanglier">Sanglier</option>
								<option value="Serpent">Serpent</option>
								<option value="Ecureuil">Ecureuil</option>
						</select></td>
					</tr>
				</table>
				<br> <input type="submit" class="btn btn-success"
					value="Ajouter un animal">

			</fieldset>
		</form>
	</div>
</main>

