<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>edition d'une activite ${activite.getClass().simpleName}</h1>
		<c:choose>
			<c:when test="${activite.getClass().simpleName=='Safari'}">
				<c:url var="url" value="/activite/save/safari"></c:url>
			</c:when>
			<c:otherwise>
				<c:url var="url" value="/activite/save/aquatique"></c:url>
			</c:otherwise>
		</c:choose>
		<form:form action="${url}" method="get" modelAttribute="activite">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" class="form-control" placeHolder="generation auto"/>
			</div>
			<div class="form-group">
				<form:label path="date">date:</form:label>
				<form:input type="date" path="date" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="heure">heure</form:label>
				<form:input type="time" path="heure" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="meteo">meteo:</form:label>
				<form:select path="meteo" items="${allMeteos}" cssClass="form-control">
				</form:select>
			</div>
			<c:if test="${activite.getClass().simpleName=='Safari'}">
			<div class="form-group">
				<form:label path="vehicule.id">vehicule:</form:label>
				<form:select path="vehicule.id" cssClass="form-control">
					<form:options items="${vehicules}" itemValue="id" itemLabel="info"/>
				</form:select>
			</div>
			</c:if>
			<div class="form-group">
				<form:label path="prix">prix:</form:label>
				<form:input path="prix" class="form-control" type="number"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="${ctx}/activite" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>