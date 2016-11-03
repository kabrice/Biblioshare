<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <title>Register</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<div align="center"> -->
<!-- 		<h1>Create new User</h1> -->
<!-- 		<table> -->
<%-- 			<f:form modelAttribute="userData" action="register" method="post"> --%>
<!-- 				<tr> -->
<!-- 					<td>Username</td> -->
<%-- 					<td><f:input path="username" /></td> --%>
<%-- 					<td><f:errors path="username" cssStyle="color:red;" /></td> --%>

<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Nom</td> -->
<%-- 					<td><f:input path="nom" /></td> --%>
<%-- 					<td><f:errors path="nom" cssStyle="color:red;" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Prenom</td> -->
<%-- 					<td><f:input path="prenom" /></td> --%>
<%-- 					<td><f:errors path="prenom" cssStyle="color:red;" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Email</td> -->
<%-- 					<td><f:input path="email" /></td> --%>
<%-- 					<td><f:errors path="email" cssStyle="color:red;" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Password</td> -->
<%-- 					<td><f:input path="password" type="password" /></td> --%>
<%-- 					<td><f:errors path="password" cssStyle="color:red;" /></td> --%>
<!-- 				</tr> -->

<!-- 				<tr> -->
<!-- 					<td>Roles</td> -->
<%-- 					<td><f:select path="roles" items="${roles}" itemValue="id" itemLabel="id" /></td> --%>

<!-- 				</tr> -->

<!-- 				<tr> -->
<!-- 					<td><input type="submit" value="valider"></td> -->
<!-- 				</tr> -->
<%-- 			</f:form> --%>
<!-- 		</table> -->
<!-- 	</div> -->
<!-- </body> -->
<!-- </html> -->

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
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					<c:url var="loginUrl" value="/login" />
					<f:form modelAttribute="userData" action="register" method="post"
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
							<label class="input-group-addon" for="nom"><i
								class="fa fa-user"></i></label>
							<f:input type="text" class="form-control" id="nom"
								path="nom" placeholder="Enter Name" />
						</div>
						
						<div class="input-group input-sm">
							<label class="input-group-addon" for="prenom"><i
								class="fa fa-user"></i></label>
							<f:input type="text" class="form-control" id="prenom"
								path="prenom" placeholder="Enter Subname" />
						</div>
						
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username"><i
								class="fa fa-user"></i></label>
							<f:input type="text" class="form-control" id="username"
								path="username" placeholder="Enter Username" />
						</div>
						
						<div class="input-group input-sm">
							<label class="input-group-addon" for="email"><i
								class="fa fa-envelope"></i></label>
							<f:input type="text" class="form-control" id="email"
								path="email" placeholder="Enter email" />
						</div>
						
						<div class="input-group input-sm">
							<label class="input-group-addon" for="email"><i
								class="fa fa-user"></i></label>
							<f:input type="text" class="form-control" id="email"
								path="email" placeholder="Enter email" />
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
								class="btn btn-block btn-primary btn-default" value="Register">
						</div>
					</f:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>