<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<title>Gestion des Animaux</title>
  <main align="center">
  	
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
                            <option <c:if test="${animal.getClass().getSimpleName()=='Sanglier'}"> selected </c:if> >Sanglier</option>
                            <option <c:if test="${animal.getClass().getSimpleName()=='Serpent'}"> selected </c:if>>Serpent</option>
                            <option <c:if test="${animal.getClass().getSimpleName()=='Ecureuil'}"> selected </c:if>>Ecureuil</option>
                          </select>
                    </td>
                </tr>
        </table>
        <br>

        <button type="submit" class="btn btn-warning">Modifier</button>
        <a href="animal"><button type="button" class="btn btn-danger">Annuler</button></a>
    </fieldset>
</form>
</main>
