<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier Password</title>

<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/index.css' />" ></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/helper.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/profil.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/js/jquery-3.1.1.min.js' />"></link>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
	
	
	
			<article>
			<h4>Changez votre mot de passe</h4>	
			<form method='post' action="">
				<ul>
					<li>
						<label for='pass'>Votre ancien mot de passe</label><br/>
						<input type='password' name='pass' id='mdp'/>
					</li><br/>
					<li>
						<label for='NewPass'>Votre nouveau mot de passe</label><br/>
						<input type='password' name='NewPass' id='new_mdp'/>
					</li><br/>
					<li>
						<label for='NewPassVerif'>Confirmez votre nouveau mot de passe</label><br/>
						<input type='password' name='NewPassVerif' />
					</li><br/>
					<li><input type='submit' name='valider'/></li>
				</ul>
			</form>
		</article>
	</section>

</body>
</html>