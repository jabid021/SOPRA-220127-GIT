 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
  <main align="center">
<<<<<<< Updated upstream
  	
    <form action="animal" method="post" id="updateAnimal">
    <input type="hidden" name="tache" value="update">
    <input type="hidden" name="id" value="${animal.id}">

    <fieldset>
        <legend>Modifier un animal</legend>
        <table align="center">
                <tr>
                    <th>nom</th>

                    <td><input name="nom" value="${animal.nom}" type="text" placeholder="Saisissez le nom"></td>
                </tr>

                <tr>
                    <th>type</th>
                    <td>
                        <select name="typeAnimal">
                            <option selected >Sanglier</option>
                            <option>Serpent</option>
                            <option>Ecureuil</option>
                          </select>
                    </td>
                </tr>
        </table>
        <br>

        <button type="submit" class="btn btn-warning">Modifier</button>
        <a href="animaux.jsp"><button type="button" class="btn btn-danger">Annuler</button></a>
    </fieldset>
</form>
</main>
