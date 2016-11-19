<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Bienvenu sur Biblioshare</title>

<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet"></link>

<link href="<c:url value='/resources/css/index.css' />" rel="stylesheet"></link>


</head>
<body>
	<div class="container-fluide">
		<div class="row">
			<nav class="navbar navbar-findcond ">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar">
							<span class="sr-only"><img
								src="<c:url value="/resources/images/bookshare.png"/>"
								height="30" width="30"
								style="margin-top: 3px; margin-right: -20px;"></span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><img
								src="<c:url value="/resources/images/bookshare.png"/>"
								height="30" width="30"
								style="margin-top: 3px; margin-right: -20px;"></a>
					</div>
					<div class="collapse navbar-collapse" id="navbar">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-fw fa-bell-o"></i> Acceuil</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-fw fa-bell-o"></i> Notifications <span
									class="badge">0</span></a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false">${utilisateur.username}
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="${pageContext.request.contextPath }/logout">Se
											deconnecter</a></li>
									<li><a href="${pageContext.request.contextPath }/userProfile">Mon Compte</a></li>
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
									</span>Mes Livres</a> <span class="badge">${nbLivreUser}</span>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse in">
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
							<div id="collapseTwo" class="panel-collapse collapse">
								<div class="panel-body">
									<table class="table">
										<tr>
											<td><a href="#">Emprunt</a> <span
												class="label label-success">$ 320</span></td>
										</tr>
										<tr>
											<td><a href="#">Prétés</a></td>
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
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseThree"><span
										class="glyphicon glyphicon-user"> </span>Compte</a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse">
								<div class="panel-body">
									<table class="table">
										<tr>
											<td><a href="#">Change Password</a></td>
										</tr>
										<tr>
											<td><a href="#">Notifications</a> <span
												class="label label-info">5</span></td>
										</tr>
										<tr>
											<td><a href="#">Amis</a></td>
										</tr>
										<tr>
											<td><a href="#">Groupe</a></td>
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
							<a href="${pageContext.request.contextPath }/bookshare">Bookshare</a>
<%-- 							<jsp:include page="lst-livres.jsp"></jsp:include> ici vous allez inclure la liste des livre de l'utilisateur --%>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</div>
	

	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		
	<script type="text/javascript" src="<c:url value="/resources/js/modal.js" />"></script>	


</body>
</html>