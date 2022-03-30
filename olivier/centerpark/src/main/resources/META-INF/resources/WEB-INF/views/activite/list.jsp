<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>liste des activites</h1>
		<table class="table">
			<c:forEach items="${activites}" var="a">
				<tr>
					<td>${a.id}</td>
					<td><fmt:parseDate value="${a.date}" pattern="yyyy-MM-dd"
							type="date" var="dateActivite"></fmt:parseDate> <fmt:formatDate
							value="${dateActivite}" pattern="dd/MM/yyyy" /></td>
					<td>${a.heure}</td>
					<td>${a.prix}</td>
					<td>${a.meteo}</td>
					<td>${a.getClass().simpleName}</td>
					<td><c:if test="${a.getClass().simpleName=='Safari'}"> ${a.vehicule.model}</c:if></td>
					<td><a href="${ctx}/activite/edit?id=${a.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="${ctx}/activite/delete?id=${a.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${ctx}/activite/add/aquatique" class="btn btn-link">nouvelle
			activite aquatique</a><a href="${ctx}/activite/add/safari"
			class="btn btn-link">nouvelle activite safari</a>
	</div>
</body>
</html>