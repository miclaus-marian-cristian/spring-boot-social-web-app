<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="pg" tagdir="/WEB-INF/tags" %>

<c:url var="url" value="/viewstatus" />

<div class="row">
	<div class="col-md-8 col-md-offset-2">

		<div class="pagination">
			<pg:pagination url="${url}" page="${page}" size="3"/>
		</div>

		<c:forEach var="status" items="${ page.content}">

			<c:url var="editLink" value="/editstatus?id=${status.id}"/>
			<c:url var="deleteLink" value="/deletestatus?id=${status.id}"/>

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
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					
						<a href="${editLink }" class="pull-right" >Edit</a>
						<a href="${deleteLink}" class="pull-right" 
						onclick="return confirm('Are you sure you want to delete it?' )">
							Delete
						</a>
					
					</sec:authorize>

				</div>

			</div>

		</c:forEach>

	</div>
</div>