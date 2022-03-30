<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form action="${ctx}/vehicule/save" method="post"
			modelAttribute="vehicule">
<%-- 			<form:hidden path="version"/> --%>
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="model">model:</form:label>
				<form:input path="model" cssClass="form-control" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
			</div>
		</form:form>
		<!-- 		<form> -->
		<!-- 			<div class="form-group">id: -->
		<%-- 				<input name="id" class="form-control" value="${vehicule.id}" readonly="readonly"> --%>
		<!-- 			</div> -->
		<!-- 			<div class="form-group"> -->
		<!-- 			modele: -->
		<%-- 				<input name="model" class="form-control"  value="${vehicule.model}"> --%>
		<!-- 			</div> -->
		<!-- 			<div> -->
		<!-- 				<button type="submit" class="btn btn-outline-primary">enregistrer</button> -->
		<!-- 			</div> -->
		<!-- 		</form> -->
	</div>
</body>
</html>