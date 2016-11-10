<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue sur BiblioShare</title>

<link rel="stylesheet"
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"></link>

<link rel="stylesheet" href="<c:url value='/resources/css/index.css' />"></link>

<link rel="stylesheet"
	href="<c:url value='/resources/css/helper.css' />"></link>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>

<body>
	<header>
	<div>
		<nav class="navbar  navbar-fixed-top navbar-default ">
		<div class="container">
			<div class="navbar-header">
				<div>
					<ul class="nav navbar-nav">
						<li><a class="navbar-brand"
							href="?controller=apropos&action=apropos"><img
								src="<c:url value="/resources/images/bookshare.png"/>"
								height="40" width="40"
								style="margin-top: 3px; margin-right: -20px;"></a></li>
						<li class="logo"><a
							style="color: #1a7ad9 !important; margin-right: 200px; margin-left: 30px">BiblioShare</a></li>
						<li><a>
								<form id="custom-search-input"
									style="display: inline-block; max-width: 500px;">
									<div class="input-group col-md-12">
										<input type="text" class="  search-query form-control"
											placeholder="Recherche un ami et emprunte ses livres" /> <span
											class="input-group-btn">
											<button class="btn btn-default" type="button">
												<span class=" glyphicon glyphicon-search"></span>
											</button>
										</span>
									</div>
								</form>
						</a></li>
					</ul>
				</div>

			</div>

			<ul class="nav navbar-nav navbar-right">
				<li id="notification_li"><span id="notification_count" hidden></span>
					<a href='?controller=utilisateur&action=posterpensee'
					class="header-text" id="notificationLink"><i
						class="material-icons">notifications</i></a>
					<div id="notificationContainer">
						<div id="notificationTitle">Notifications</div>
						<div id="notificationsBody" class="notifications scroll">
							<ul class="nav" id="notifications-ul">

							</ul>
						</div>
						<div id="notificationFooter">
							<a href="#" class="notif-link-footer"><i
								class="material-icons">sentiment_satisfied</i></a>
						</div>
					</div></li>
				<li><a href='?controller=utilisateur&action=posterpensee'
					class="header-text">Accueil</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" style="margin-top: 5px; color: dimgrey;"
					onmouseover="this.style.color='#1e90fe';this.style.color='#1e90fe';"
					onmouseout="this.style.background='';this.style.color='dimgrey';">
						${utilisateur.username}<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href='#'>Profil</a></li>
						<li><a href="${pageContext.request.contextPath }/logout">Se
								deconnecter</a></li>
					</ul></li>
			</ul>
		</div>
		</nav>
	</div>
	</header>


	<div class="container content">

		<div class="row">
			<div class="col-xs-6 col-md-4">Meilleures sélections</div>
			<div class="col-xs-12 col-sm-6 col-md-8"></div>
		</div>

		<div class="row">
			<div class="row">
				<div class="col-sm-3 col-md-3">
					<div class="panel-group" id="accordion">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne"><span class="glyphicon glyphicon-book">
									</span>Mes Livres</a> <span class="badge">42</span>
								</h4>
							</div>
							<div>
								<div class="panel-body">
									<table class="table">
										<tr>
											<td><span class="glyphicon glyphicon-time text-primary"></span><a
												href="#">Recement lu</a> <span class="badge">42</span></td>
										</tr>
										<tr>
											<td><span class="glyphicon glyphicon-list text-success"></span><a
												href="#">Tous</a> <span class="badge">42</span></td>
										</tr>
										<tr>
											<td><span class="glyphicon glyphicon-font text-info"></span><a
												href="#">Auteurs</a> <span class="badge">42</span></td>
										</tr>
										<tr>
											<td><span
												class="glyphicon glyphicon-pencil text-success"></span><a
												href="#">Editeurs</a> <span class="badge">42</span></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseTwo"><span class="glyphicon glyphicon-th">
									</span>Activités sur Livre</a>
								</h4>
							</div>
							<div>
								<div class="panel-body">
									<table class="table">
										<tr>
											<td><a href="#">Emprunt</a> <span
												class="label label-success">$ 320</span></td>
										</tr>
										<tr>
											<td><a href="#">Prêtés</a></td>
										</tr>
										<tr>
											<td><a href="#">Remis</a></td>
										</tr>
										<tr>
											<td><a href="#">En Attenter</a></td>
										</tr>
									</table>
								</div>
							</div>
						</div>


					</div>
				</div>
				<div class="col-sm-9 col-md-9">
					<div class="well">

						<c:if
							test="${not fn:endsWith(pageContext.request.requestURI, '/acceuil')}">
							<jsp:include page="lst-livres.jsp"></jsp:include>
						</c:if>

					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- 	<script type="text/javascript" -->
	<%-- 		src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script> --%>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/notification.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/modal.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>


</body>
</html>