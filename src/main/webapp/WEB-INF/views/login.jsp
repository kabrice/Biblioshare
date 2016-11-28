
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
	<div>
		<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8" id="welcome"><div class="jumbotron">
    <h1>Bienvenu Sur Biblioshare</h1>      
    <p>Biblioshare est une plateForme de telechargement et de partage de livre en tre amis</p>
    <p>Connecter vous ou creer votre compte pour profiter de toutes les fonctionnalités</p>
  </div></div>
		<div class="col-md-2"></div>
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
									<div class="input-group input-sm log">
										<label class="input-group-addon" for="username"><i
											class="fa fa-user"></i></label>
										<f:input type="text" class="form-control" id="username"
											path="username" placeholder="Enter Username" />
										<span class="label label-warning"></span>
									</div>
									<div class="input-group input-sm log">
										<label class="input-group-addon" for="password"><i
											class="fa fa-lock"></i></label>
										<f:input type="password" class="form-control" id="password"
											path="password" placeholder="Enter Password" />
										<span class="label label-warning"></span>
									</div>


									<div class="form-actions">
										<input type="submit" class="btn btn-block btn-success"
											value="Log in" id="loggin" disabled="disabled">
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
								<f:form modelAttribute="userData" action="register"
									method="post" class="form-horizontal">
									<c:if test="${var_username != null}">
										<div class="alert alert-danger">
											<p>Invalid username deja utilisé.</p>
										</div>
									</c:if>
									<div class="input-group input-sm register">
										<label class="input-group-addon" for="username"><i
											class="fa fa-user"></i></label>
										<f:input type="text" class="form-control" id="username"
											path="username" placeholder="Enter Username" />
										<f:errors path="username" cssStyle="color:red;" />
									</div>

									<div class="input-group input-sm register">
										<label class="input-group-addon" for="nom"><i
											class="fa fa-font"></i></label>
										<f:input type="text" class="form-control" id="nom" path="nom"
											placeholder="Enter Name" />
										<f:errors path="nom" cssStyle="color:red;" />
									</div>

									<div class="input-group input-sm register">
										<label class="input-group-addon" for="prenom"><i
											class="fa fa-font"></i></label>
										<f:input type="text" class="form-control" id="prenom"
											path="prenom" placeholder="Enter Subname" />
										<f:errors path="prenom" cssStyle="color:red;" />
									</div>



									<div class="input-group input-sm register">
										<label class="input-group-addon" for="email"><i
											class="fa fa-envelope"></i></label>
										<f:input type="text" class="form-control" id="email"
											path="email" placeholder="Enter email" />
										<f:errors path="email" cssStyle="color:red;" />
									</div>

									<f:input type="hidden" class="form-control" id="credit"
										path="credit" value="100.00" />
									<div class="input-group input-sm register">
										<label class="input-group-addon" for="password"><i
											class="fa fa-lock"></i></label>
										<f:input type="password" class="form-control" id="password"
											path="password" placeholder="Enter Password" />
										<f:errors path="password" cssStyle="color:red;" />
									</div>

									<div class="input-group input-sm register">
										<label class="input-group-addon" for="passwordConfirm"><i
											class="fa fa-lock"></i></label>
										<f:input type="password" class="form-control"
											id="passwordConfirm" path="passwordConfirm"
											placeholder="Enter Password Confirm" />
										<f:errors path="passwordConfirm" cssStyle="color:red;" />
									</div>

									<div class="form-actions">
										<input type="submit" class="btn btn-block btn-success "
											value="Register" id="register" disabled="disabled">
									</div>
								</f:form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>


	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/modal.js" />"></script>


	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>

	<!-- (Optional) Latest compiled and minified JavaScript translation files -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/i18n/defaults-*.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.log input').keyup(function() {

				var empty = false;
				$('.log input').each(function() {
					if ($(this).val().length == 0) {

						empty = true;
					}

				});

				if (empty) {
					$('.form-actions #loggin').attr('disabled', 'disabled');
				} else {
					$('.form-actions #loggin').removeAttr('disabled');
				}
			});
		});

		$(document).ready(function() {
			$('.register input').keyup(function() {

				var empty = false;
				$('.register input').each(function() {
					if ($(this).val().length == 0) {

						empty = true;

					}

				});

				if (empty) {
					$('.form-actions #register').attr('disabled', 'disabled');
				} else {
					$('.form-actions #register').removeAttr('disabled');
				}
			});
		});
	</script>

</body>
</html>
