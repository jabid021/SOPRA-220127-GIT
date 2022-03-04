<c:if test="${connected==null}">
	<c:redirect url = "home"/>
</c:if>

<title>Menu Staff</title>

<main align="center">

<h1>Welcome ${connected.mail}</h1>
<div id="banniere">
  <div> <a href="animaux.jsp"><i>"Gestion Animaux"</i></a></div>
  <div> <a href="vehicule.jsp"><i>"Gestion des véhicules"</i></a></div>
  <div> <a href="activite.jsp"><i>"Gestion des activités"</i></a> </div>
  <div> <a href="compte"><i>"Gestion des comptes"</i></a> </div>
</div>
<br>



  <a href="disconnect"><input value="Se deconnecter" type="submit"></a>

</main>