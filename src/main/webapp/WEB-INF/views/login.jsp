
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
	<div class="row">
		<div class="col-md-6">
			<div id="logginWrapper">
				<div class="login-container">
					<div class="login-card">
						<div class="login-form">
							<c:url var="loginUrl" value="/login" />
							<f:form modelAttribute="userData" action="login" method="post"
								class="form-horizontal">
								<c:if test="${failed != null}">
									<div class="alert alert-danger">
										<p>Invalid username or password.</p>
									</div>
								</c:if>
								<c:if test="${param.logout != null}">
									<div class="alert alert-success">
										<p>You have been logged out successfully.</p>
									</div>
								</c:if>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="username"><i
										class="fa fa-user"></i></label>
									<f:input type="text" class="form-control" id="username"
										path="username" placeholder="Enter Username" />
								</div>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="password"><i
										class="fa fa-lock"></i></label>
									<f:input type="password" class="form-control" id="password"
										path="password" placeholder="Enter Password" />
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />

								<div class="form-actions">
									<input type="submit"
										class="btn btn-block btn-primary btn-default" value="Log in">
								</div>
							</f:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div id="logginWrapper">
				<div class="login-container">
					<div class="login-card">
						<div class="login-form">
							<c:url var="loginUrl" value="/login" />
							<f:form modelAttribute="userData" action="register" method="post"
								class="form-horizontal">
									<c:if test="${var_username != null}">
									<div class="alert alert-danger">
										<p>Invalid username deja utilisé.</p>
									</div>
								</c:if>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="username"><i
										class="fa fa-user"></i></label>
									<f:input type="text" class="form-control" id="username"
										path="username" placeholder="Enter Username" />
									<f:errors path="username" cssStyle="color:red;" />
								</div>

								<div class="input-group input-sm">
									<label class="input-group-addon" for="nom"><i
										class="fa fa-font"></i></label>
									<f:input type="text" class="form-control" id="nom" path="nom"
										placeholder="Enter Name" />
									<f:errors path="nom" cssStyle="color:red;" />	
								</div>

								<div class="input-group input-sm">
									<label class="input-group-addon" for="prenom"><i
										class="fa fa-font"></i></label>
									<f:input type="text" class="form-control" id="prenom"
										path="prenom" placeholder="Enter Subname" />
									<f:errors path="prenom" cssStyle="color:red;" />	
								</div>



								<div class="input-group input-sm">
									<label class="input-group-addon" for="email"><i
										class="fa fa-envelope"></i></label>
									<f:input type="text" class="form-control" id="email"
										path="email" placeholder="Enter email" />
									<f:errors path="email" cssStyle="color:red;" />	
								</div>

								<f:input type="hidden" class="form-control" id="credit"
										path="credit" value="100.00"/>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="password"><i
										class="fa fa-lock"></i></label>
									<f:input type="password" class="form-control" id="password"
										path="password" placeholder="Enter Password" />
									<f:errors path="password" cssStyle="color:red;" />	
								</div>
								
								<div class="input-group input-sm">
									<label class="input-group-addon" for="passwordConfirm"><i
										class="fa fa-lock"></i></label>
									<f:input type="password" class="form-control" id="passwordConfirm"
										path="passwordConfirm" placeholder="Enter Password Confirm" />
									<f:errors path="passwordConfirm" cssStyle="color:red;" />	
								</div>

								<div class="form-actions">
									<input type="submit"
										class="btn btn-block btn-primary btn-default" value="Register">
								</div>
							</f:form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>




</body>
</html>