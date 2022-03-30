<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<nav>
<a href="${ctx}/participant" class="btn btn-link">participant</a>
<a href="${ctx}/activite" class="btn btn-link">activite</a>
<a href="${ctx}/reservation" class="btn btn-link">reservation</a>
</nav>