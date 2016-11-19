

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier E-mail</title>

	<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/helper.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/js/jquery-3.1.1.min.js' />"></link>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>



			
						
					<article>
					<h4>Changez votre E-mail</h4>	
					<f:form method='post' action="change_email" >
						<ul>
							<li>
								<label for='email'>Votre ancien E-mail</label><br/>
								<input type="email" name='email' id='email'/>
							</li><br/>
							<li>
								<label for='newEmail'>Votre nouveau E-mail</label><br/>
								<input type='email' name='newEmail' id='new_email'/>
							</li><br/>
							<li>
								<label for='NewEmailVerif'>Confirmez votre nouveau E-mail</label><br/>
								<input type='email' name='NewEmailVerif' />
							</li><br/>
							<li><input type='submit' name='valider'/></li>
						</ul>
					</f:form>
				</article>
			</section>
					
</body>
</html>