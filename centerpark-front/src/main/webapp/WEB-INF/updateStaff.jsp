
 <title>Modifier Staff</title>
    <main>
 
    <form action="compte" method="post" id="updateFormCompte">
			<input type="hidden" name="tache" value="update">
			<input type="hidden" name="typeCompte" value="staff">
			<input type="hidden" name="id" value="${staff.numero}">
			<div>
				Mail : <input required name="mail" type="text" value="${staff.mail}" placeholder="Saisissez un mail">
			</div>
			<div>
				Password : <input name="password" required value="${staff.password}" type="password"
					placeholder="Saisissez un password">
			</div>
			<div>Metier : <input  name="metier" required type="text" value="${staff.metier}" placeholder="Saisissez le metier"> </div>
			
			<input type="submit" class="btn btn-success mb-2"
				value="modifier un compte">
			 <a href="comptes.jsp"><button type="button" class="btn btn-danger">Annuler</button></a>
		</form>
    
    
    </main>