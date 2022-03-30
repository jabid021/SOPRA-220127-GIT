<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<jsp:include page="../menu.jsp"></jsp:include>
		<h1>listes de participants</h1>
		<table class="table">
			<c:forEach items="${participants}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.prenom}</td>
					<td>${p.nom}</td>
					<td>${p.age}</td>
					<td><a href="${ctx}/participant/edit?id=${p.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="${ctx}/participant/delete?id=${p.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${ctx}/participant/add" class="btn btn-link">nouveau
			participant</a>
	</div>
</body>
</html>