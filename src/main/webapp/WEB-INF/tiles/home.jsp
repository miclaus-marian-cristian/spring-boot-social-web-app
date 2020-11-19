<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<div class="row">
		<div class="col-xs-6 col-xs-offset-3">
			<div class="panel panel-default">

				<div class="panel-heading">
					<div class="panel-title">
						Status update added on
						<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
							value="${latestStatus.addedTime}" />
					</div>
				</div>

				<div class="panel-body">

					<c:out value="${latestStatus.text}" />

				</div>

			</div>
		</div>
	</div>

</div>