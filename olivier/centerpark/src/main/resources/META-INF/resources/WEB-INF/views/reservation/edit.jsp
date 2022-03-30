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
		<h1>reservation</h1>
		<form:form action="${ctx}/reservation/save" method="post"
			modelAttribute="reservation">
			<input type="hidden" name="type" value="${type}">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true"
					placeholder="generation automatique" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="date">date:</form:label>
				<form:input type="date" path="date" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="statut">statut:</form:label>
				<form:select path="statut" items="${statuts}"
					cssClass="form-control">
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="idParticipant">participant:</form:label>
				<form:select path="idParticipant" items="${participants}" itemLabel="identite"
					itemValue="id"
					cssClass="form-control">
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="idActivite">activite de type ${type}:</form:label>
				<form:select path="idActivite" items="${activites}" itemValue="id" itemLabel="id" cssClass="form-control"></form:select>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="${ctx}/reservation" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>