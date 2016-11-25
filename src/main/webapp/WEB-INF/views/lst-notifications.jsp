<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listes des livres</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/listeretoile.css' />"
	rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

</head>
<body>

	<div class="row profile">
	<c:forEach items="${liste_demandes}" var="user">
		<div class="col-md-3">
			<div class="profile-sidebar">
				<!-- SIDEBAR USERPIC -->
				<div class="profile-userpic">
					<img src="<c:url value="/resources/images/profil.jpg"/>"
							height="200" width="200" class="img-responsive"
							style="margin-top: 3px; margin-right: -20px;">
				</div>
				<!-- END SIDEBAR USERPIC -->
				<!-- SIDEBAR USER TITLE -->
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
						${user.username}
					</div>
					
				</div>
				<!-- END SIDEBAR USER TITLE -->
				<!-- SIDEBAR BUTTONS -->
				<div class="profile-userbuttons">
					<button id="ajout" type="button" class="btn btn-success btn-sm" value="${user.id}">Accepter</button>
					<button id="refus" type="button" class="btn btn-danger btn-sm" value="${user.id }">Refuser</button>
				</div>
				<!-- END SIDEBAR BUTTONS -->
				
				
				<!-- END MENU -->
			</div>
		</div>
		
		</c:forEach>
	</div>

</body>

</html>