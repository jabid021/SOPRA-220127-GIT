<!--
Afficher un tableau avec une liste d'animaux (id,nom,type) (modifier + Suppr)
Bouton ajouter pour avoir acces au formulaire d'ajout (nom + type en liste deroulante)
Modifier aura un lien vers la page updateAnimal.html?id=x
 -->

<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="util.Context" %>

<title>Gestion des animaux</title>


   <main align="center">
    <h1 style="text-align: center;">Liste des animaux</h1><br><br>
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

              <%
				List<Animal> animals = Context.getSingleton().getDaoAnimal().findAll();
			
				for(Animal a : animals)
				{
					if( a instanceof Sanglier)
					{
						Sanglier animal = (Sanglier)a;
						out.println("<tr><td>"+animal.getId()+"</td><td>"+animal.getNom()+"</td><td>"+animal.getClass().getSimpleName()+"</td><td><a href='animal?id="+animal.getId()+"'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='animal' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"+animal.getId()+"'><input type='submit'class='btn btn-danger' value='Supprimer'></form></td></tr>");
					}
					else if( a instanceof Serpent)
					{
						Serpent animal = (Serpent)a;
						out.println("<tr><td>"+animal.getId()+"</td><td>"+animal.getNom()+"</td><td>"+animal.getClass().getSimpleName()+"</td><td><a href='animal?id="+animal.getId()+"'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='animal' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"+animal.getId()+"'><input type='submit'class='btn btn-danger' value='Supprimer'></form></td></tr>");
					}
					else if( a instanceof Ecureuil)
					{
						Ecureuil animal =  (Ecureuil)a;
						out.println("<tr><td>"+animal.getId()+"</td><td>"+animal.getNom()+"</td><td>"+animal.getClass().getSimpleName()+"</td><td><a href='animal?id="+animal.getId()+"'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='animal' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"+animal.getId()+"'><input type='submit'class='btn btn-danger' value='Supprimer'></form></td></tr>");
					}
				}
			
			%>
            </tbody>
          </table>
              
          
    </div>

    <div >
        <form action="animal" method="post">
        	<input type="hidden" name="tache" value="insert">

            <fieldset>
                <legend>Ajouter un animal</legend>
                
                
                <table align="center">



                        <tr>
                            <th>Nom</th>
                            <td><input required type="text" name="nom" placeholder="Saisissez un nom"></td>
                        </tr>

                        <tr>
                            <th>Type Animal</th>
                            <td>
                                <select name="typeAnimal">
                                    <option value="Sanglier">Sanglier</option>
                                    <option value="Serpent">Serpent</option>
                                    <option value="Ecureuil">Ecureuil</option>
                                  </select>
                            </td>
                        </tr>
                </table>
                <br>
                
                <input type="submit" class="btn btn-success" value="Ajouter un animal">

            </fieldset>
        </form>
    </div>
</main>

