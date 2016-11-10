<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue sur BiblioShare</title>


<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet"></link>

<link href="<c:url value='/resources/css/index.css' />" rel="stylesheet"></link>

<link href="<c:url value='/resources/css/helper.css' />"
	rel="stylesheet"></link>

<link href="<c:url value='/resources/css/bookshare.css' />"
	rel="stylesheet"></link>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>

<body>

	<div class="row">
		<nav class="navbar navbar-findcond ">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar">
					<span class="sr-only"><img
						src="<c:url value="/resources/images/bookshare.png"/>" height="30"
						width="30" style="margin-top: 3px; margin-right: -20px;"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src="<c:url value="/resources/images/bookshare.png"/>" height="30"
					width="30" style="margin-top: 3px; margin-right: -20px;"></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-fw fa-bell-o"></i> Acceuil</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-fw fa-bell-o"></i> Notifications <span class="badge">0</span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">${utilisateur.username}
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath }/logout">Se
									deconnecter</a></li>
							<li><a href="#">Mon Compte</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-right search-form" role="search">
					<input type="text" class="form-control"
						placeholder="rechercher livre, auteur,éditeur,collection, amis"
						style="width: 400px" />
				</form>
			</div>
		</div>
		</nav>
	</div>

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
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<div class="well">

					<c:if
						test="${not fn:endsWith(pageContext.request.requestURI, '/bookshare')}">
						<jsp:include page="lst-livres.jsp"></jsp:include>
					</c:if>

				</div>
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