<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="style.css">
  <link rel="icon" href="img/icon.jpg">
  <title>Inscription</title>
</head>

<body>
  <header>
    <img  src="https://previews.123rf.com/images/vicushka/vicushka1506/vicushka150600102/41061682-hojas-de-helecho-sobre-borrosa-fondo-bandera-naturaleza-para-el-sitio-web.jpg" alt="banni�re">
    <a href="index.html"><div id="logo"></div></a>
  </header>
  <main align="center">
  <h1> Inscription client </h1>

  <form id="inscription">

    <table align="center">

    <tr>
    <td>Login : </td>
    <td> <input required placeholder="Identifiant" type="text"></td>
    </tr>

    <br><br>

    <tr>
    <td>Password : </td>
    <td><input required placeholder="Mot de Passe" type="password"></td>
    </tr>

    <tr>
    <td>Date de naissance : </td>
    <td><input required type="date"></td>
    </tr>


    <tr>
    <td>Tel : </td>
    <td><input placeholder="tel" required type="text"></td>
    </tr>

    <tr>
    <td>Numero :</td>
    <td><input placeholder="numero"  required type="text"></td>
    </tr>

    <tr>
    <td>Voie :</td>
    <td><input placeholder="voie"  required type="text"></td>
    </tr>

    <tr>
    <td>Ville : </td>
    <td><input placeholder="ville"  required type="text"></td>
    </tr>

    <tr>
    <td>CP : </td>
    <td><input placeholder="cp"  required type="text"></td>
    </tr>



    </table>
    <br>
    <input type="submit" value="Valider">
  </form>


</main>
</body>

</html>