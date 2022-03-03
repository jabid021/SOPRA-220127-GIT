<!--
Afficher un tableau avec une liste d'animaux (id,nom,type) (modifier + Suppr)
Bouton ajouter pour avoir acces au formulaire d'ajout (nom + type en liste deroulante)
Modifier aura un lien vers la page updateAnimal.html?id=x
 -->



   <title>Gestion des animaux</title>


   <main align="center">
    <h1 style="text-align: center;">Liste des animaux</h1><br><br>
    <div id="tableau">
        <table class="table table-striped">
            <thead>
              <tr>
                <th>id animal</th>
                <th>nom</th>
                <th>type animal</th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
             <!-- <tr>
                <td>1</td>
                <td>Pumba</td>
                <td>Sanglier</td>
                <td><a href="updateAnimal.html"><button type="button" class="btn btn-primary">Modifier</button></a></td>
                <td><button type="button" class="btn btn-danger">Supprimer</button></td>
              </tr>
              <tr>
                <td>2</td>
                <td>KobraKai</td>
                <td>Serpent</td>
                <td><a href="updateAnimal.html"><button type="button" class="btn btn-primary">Modifier</button></a></td>
                <td><button type="button" class="btn btn-danger">Supprimer</button></td>
              </tr>
              <tr>
                <td>3</td>
                <td>Scrat</td>
                <td>Ecureuil</td>
                <td><a href="updateAnimal.html"><button type="button" class="btn btn-primary">Modifier</button></a></td>
                <td><button type="button" class="btn btn-danger">Supprimer</button></td>
              </tr>-->
              <%
				List<Animal> animals = Context.getSingleton().getDaoAnimal().findAll();
			
				for(Animal a : animals)
				{
					out.println("<tr><td>"+a.getId()+"</td><td>"+a.getNom()+"</td><td>"+client.getPassword()+"</td><td>/</td><th>"+c.getClass().getSimpleName().toLowerCase()+"</th><th><a href='compte?id="+client.getNumero()+"'><input type='button' class='btn btn-warning'value='Modifier'></a><form action='compte' method='post'><input type='hidden' name='tache' value='delete'><input name='id' type='hidden' value='"+c.getNumero()+"'><input type='submit'class='btn btn-danger' value='Supprimer'></form></th></tr>");
				}
			
			%>
            </tbody>
          </table>
    </div>

    <div >
        <form >

            <fieldset>
                <legend>Ajouter un animal</legend>
                <table align="center">



                        <tr>
                            <th>nom</th>
                            <td><input type="text"></td>
                        </tr>

                        <tr>
                            <th>type</th>
                            <td>
                                <select name="type">
                                    <option >Sanglier</option>
                                    <option >Serpent</option>
                                    <option>Ecureuil</option>
                                  </select>
                            </td>
                        </tr>
                </table>
                <br>
                <button type="button" class="btn btn-success">Ajouter</button>

            </fieldset>
        </form>
    </div>
</main>

