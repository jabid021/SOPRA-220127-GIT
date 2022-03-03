 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
  <main align="center">
    <form action="animal" method="post" id="updateAnimal">
    <input type="hidden" name="id" value="${animal.numero}">

    <fieldset>
        <legend>Modifier un animal</legend>
        <table align="center">
                <tr>
                    <th>nom</th>
                    <td><input value="${animal.numero}" type="text"></td>
                </tr>

                <tr>
                    <th>type</th>
                    <td>
                        <select name="type">
                            <option selected>Sanglier</option>
                            <option >Serpent</option>
                            <option>Ecureuil</option>
                          </select>
                    </td>
                </tr>
        </table>
        <br>
        <button type="submit" class="btn btn-success">Ajouter</button>
        <a href="animaux.jsp"><button type="button" class="btn btn-danger">Annuler</button></a>
    </fieldset>
</form>
</main>
