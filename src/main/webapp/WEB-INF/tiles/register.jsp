<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">

	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

		<form:errors path="email" />
		<form:errors path="password" />

		<div class="panel panel-default">

			<div class="panel-heading">
				<div class="panel-title">Create an Account</div>
			</div>


			<div class="panel-body">
				<form:form method="post" modelAttribute="user">

					<div class="input-group">
						<label for="email">E-mail address:</label>
						<form:input type="text" path="email" placeholder="Email" id="email"
							class="form-control" />
					</div>

					<div class="input-group">
						<label for="pass">Password:</label>
						<form:input type="password" path="password" placeholder="Password"
							class="form-control" id="pass" />
					</div>
					
					<div class="input-group">
						<label for="rpass">Confirm Password:</label>
						<input type="password" name="repeatpassword" id="rpass" placeholder="Repeat password"
							class="form-control" />
					</div>

					<div class="input-group">
						<button type="submit" class="btn-primary form-control pull-right">Register</button>
					</div>

				</form:form>
			</div>
		</div>

	</div>

</div>