<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="url" required="true"%>
<%@ attribute name="page" required="true"
	type="org.springframework.data.domain.Page"%>
<%-- The number of page links per block --%>
<%@ attribute name="size" required="false"%>

<c:set var="size" value="${empty size ? 10 : size}" />
<c:set var="block" value="${empty param.b ? 0 : param.b }" />
<c:set var="startPage" value="${ block * size + 1}" />
<c:set var="endPage" value="${ (block + 1) * size }" />
<c:set var="endPage" value="${endPage > page.totalPages ? page.totalPages : endPage}" />

<c:if test="${block != 0}">
	<a href="${url}?b=${block-1}&p=${(block-1)*size + 1}">&lt;&lt;</a>
</c:if>

<c:forEach var="pageNumber" begin="${startPage}" end="${endPage}">

	<c:choose>

		<c:when test="${pageNumber - 1 != page.number}">
			<a href="${url}?p=${pageNumber}&b=${block}"><c:out
					value="${pageNumber}" /></a>
		</c:when>

		<c:otherwise>
			<strong><c:out value="${pageNumber}" /></strong>
		</c:otherwise>

	</c:choose>



	<c:if test="${pageNumber != endPage}"> | </c:if>
</c:forEach>

<c:if test="${endPage != page.totalPages}">
	<a href="${url}?b=${block+1}&p=${(block+1)*size + 1}">&gt;&gt;</a>
</c:if>
