<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="loginUrl" value="/login" />

<div class="row">

	<div class="col-xs-8 col-xs-offset-2 col-md-6 col-md-offset-3">
		<c:if test="${param.error != null }">
			<p class="text-danger">Wrong username or password!</p>
		</c:if>
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
					<h1>Sign In</h1>
				</div>

			</div>
			<div class="panel-body">

				<form action="${loginUrl}" method="post" class="form-group">

					<input type="hidden" name="${_csrf.parameterName}"
						value="${ _csrf.token }" />

					<div class="form-group">
						<label for="username">Email address:</label> <input type="text"
							name="username" class="form-control" id="username">
					</div>

					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							name="password" class="form-control" id="pwd">
					</div>

					<input type="submit" name="password" class="btn btn-primary"
						value="Sign In" />

				</form>

			</div>
		</div>

	</div>
</div>

