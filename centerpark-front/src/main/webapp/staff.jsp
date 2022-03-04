<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<c:if test="${connected.getClass().getSimpleName()!='Staff'}">
	<c:redirect url = "home"/>
</c:if>


<title>Menu Staff</title>

<main align="center">

<h1>Welcome ${connected.mail}</h1>
<div id="banniere">
  <div> <a href="animal"><i>"Gestion Animaux"</i></a></div>
  <div> <a href="vehicule"><i>"Gestion des véhicules"</i></a></div>
  <div> <a href="activite"><i>"Gestion des activités"</i></a> </div>
  <div> <a href="compte"><i>"Gestion des comptes"</i></a> </div>
</div>
<br>



  <a href="disconnect"><input value="Se deconnecter" type="submit"></a>

</main>