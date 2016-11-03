<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue sur BiblioShare</title>

<!-- 	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" /> -->
<!-- 	<link rel="stylesheet" href="css/index.css" /> -->
<!-- 	<link rel="stylesheet" href="css/helper.css" /> -->
<!-- 	<link rel="stylesheet" href="css/bookshare.css"> -->
<!-- 	<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css"> -->
<!-- 	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> -->


<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"	rel="stylesheet"></link>

<link href="<c:url value='/resources/css/index.css' />"     rel="stylesheet"></link>

<link href="<c:url value='/resources/css/helper.css' />"	rel="stylesheet"></link>

<link href="<c:url value='/resources/css/bookshare.css' />"	rel="stylesheet"></link>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

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
								src="<c:url value="/resources/images/bookshare.png"/>" height="40" width="40"
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
						Thomas<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href='#'>Profil</a></li>
						<li><a href="#">Se Déconnecter</a></li>
					</ul></li>
			</ul>
		</div>
		</nav>
	</div>
	</header>

	<div class="container">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-12">
				<div id="Carousel" class="carousel slide">

					<ol class="carousel-indicators">
						<li data-target="#Carousel" data-slide-to="0" class="active"></li>
						<li data-target="#Carousel" data-slide-to="1"></li>
						<li data-target="#Carousel" data-slide-to="2"></li>
					</ol>

					<!-- Carousel items -->
					<div class="carousel-inner">

						<div class="item active">
							<div class="row">
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
							</div>
							<!--.row-->
						</div>
						<!--.item-->

						<div class="item">
							<div class="row">
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
							</div>
							<!--.row-->
						</div>
						<!--.item-->

						<div class="item">
							<div class="row">
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
								<div class="col-md-3">
									<a href="#" class="thumbnail"><img
										src="http://placehold.it/250x250" alt="Image"
										style="max-width: 100%;"></a>
								</div>
							</div>
							<!--.row-->
						</div>
						<!--.item-->

					</div>
					<!--.carousel-inner-->
					<a data-slide="prev" href="#Carousel" class="left carousel-control">‹</a>
					<a data-slide="next" href="#Carousel"
						class="right carousel-control">›</a>
				</div>
				<!--.Carousel-->

			</div>
		</div>
	</div>
	<!--.container-->

	<!-- 	<script type="text/javascript" src="js/jquery-3.1.1.js"></script> -->
	<!-- 	<script type="text/javascript" src="js/bookshare.js"></script> -->
	<!-- 	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> -->

	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bookshare.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

</body>
</html>