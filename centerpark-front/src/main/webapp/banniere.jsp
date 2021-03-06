<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="img/icon.jpg">
 </head>


    <header>
        <img src="https://previews.123rf.com/images/vicushka/vicushka1506/vicushka150600102/41061682-hojas-de-helecho-sobre-borrosa-fondo-bandera-naturaleza-para-el-sitio-web.jpg" alt="bannière">
        <c:choose>
        	<c:when  test="${connected==null}"><a href="home"></c:when>
        	<c:when  test="${connected.getClass().getSimpleName()=='Staff'}"><a href="staff.jsp"></c:when>
        	<c:when  test="${connected.getClass().getSimpleName()=='Client'}"><a href="client.html"></c:when>
        </c:choose>
        <div id="logo"></div></a>
    </header>
  