<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
    <main>
 
    <form action="compte" method="post" id="updateFormCompte">
			<input type="hidden" name="tache" value="update">
			<input type="hidden" name="typeCompte" value="client">
			<input type="hidden" name="id" value="${client.numero}">
			<div>
				Mail : <input required name="mail" type="text" value="${client.mail}" placeholder="Saisissez un mail">
			</div>
			<div>
				Password : <input name="password" required value="${client.password}" type="password"
					placeholder="Saisissez un password">
			</div>
			<div>Tel : <input  name="tel" required type="text" value="${client.tel}" placeholder="Saisissez le tel"> </div>
			<div>Numero : <input   name="numero" required type="text" value="${client.adresse.numero}" placeholder="Saisissez le numero"> </div>
			<div>Voie : <input   name="voie" required type="text" value="${client.adresse.voie}" placeholder="Saisissez la voie"> </div>
			<div>CP : <input   name="cp" required type="text" value="${client.adresse.cp}" placeholder="Saisissez le CP"> </div>
			<div>Ville : <input   name="ville" required type="text" value="${client.adresse.numero}" placeholder="Saisissez la ville"> </div>

			

			<input type="submit" class="btn btn-success mb-2"
				value="modifier un compte">
			 <a href="comptes.jsp"><button type="button" class="btn btn-danger">Annuler</button></a>
		</form>
    
    
    </main>