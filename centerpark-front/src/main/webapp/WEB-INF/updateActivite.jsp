<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Gestion des activites</title>

<main align="center">

	<h1>Mise a jour de l'activite</h1>

	<form action="activite" method="post" id="updateFormActivite">
		<input type="hidden" name="tache" value="update">
		<!-- >input type="hidden" name="typeActivite" value="aquatique">-->
		<input type="hidden" name="id" value="${activite.id}">
		<table align="center">
			<tr>
				<td>Date :</td>
				<td><input required name=date type="date"
					value="${activite.date}"></td>
			</tr>
			<tr>
				<td>Heure :</td>
				<td><input name=heure type="time" value="${activite.heure}"></td>
			</tr>

			<tr>
				<td>Prix :</td>
				<td><input name=prix type="number" placeholder="prix"
					value="${activite.prix}" min=0 max=999 step=0.01>€</td>
			</tr>

			<tr>
				<td>Meteo :</td>
				<td><select name="meteo">
						<c:forEach items="${meteos}" var="m">
							<c:choose>
								<c:when test="${activite.meteo==m}">
									<option selected>${m}</option>
								</c:when>
								<c:otherwise>
									<option>${m}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>Activite :</td>
				<td><select name="typeActivite">

						<option>${activite.getClass().getSimpleName()}</option>

				</select></td>
			</tr>

			<c:if test="${activite.getClass().getSimpleName()=='Safari'}">
				<tr>
					<td>Vehicule :</td>
					<td><select name="vehicule">
							<c:forEach items="${vehicules}" var="v">
								<c:choose>
									<c:when test="${activite.vehicule.model==v.model}">
										<option value="${v.id}" selected>${v.model}</option>
									</c:when>
									<c:otherwise>
										<option value="${v.id}">${v.model}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>

			</c:if>

		</table>

		<br> <br>


		<div>
			<input type="submit" value="Valider" class="btn btn-success button">
			<input type="reset" class="btn btn-danger button"> <a
				href="activite.jsp"><input type="button" value="Retour"
				class="btn btn-primary button"></a>
		</div>

	</form>