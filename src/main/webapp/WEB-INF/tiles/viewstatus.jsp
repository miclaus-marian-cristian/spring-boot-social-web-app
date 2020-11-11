<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url var="url" value="/viewstatus" />

<div class="row">
	<div class="col-md-8 col-md-offset-2">

		<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">

			<c:choose>

				<c:when test="${pageNumber - 1 != page.number}">
					<a href="${url}?p=${pageNumber}"><c:out value="${pageNumber}" /></a>
				</c:when>

				<c:otherwise>
					<strong><c:out value="${pageNumber}" /></strong>
				</c:otherwise>
			</c:choose>

			<c:if test="${pagenNumber != page.totalPages }"> | </c:if>

		</c:forEach>

		<c:forEach var="status" items="${ page.content}">

			<div class="panel panel-default">

				<div class="panel-heading">
					<div class="panel-title">
						Status update added on
						<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
							value="${status.addedTime}" />
					</div>
				</div>

				<div class="panel-body">

					<c:out value="${status.text}" />

				</div>

			</div>

		</c:forEach>

	</div>
</div>