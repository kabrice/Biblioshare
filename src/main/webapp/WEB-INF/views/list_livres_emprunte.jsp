<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Bienvenu sur Biblioshare</title>

<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet"></link>

<link href="<c:url value='/resources/css/index.css' />" rel="stylesheet"></link>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">
</head>
<body>
	<div class="container-fluide">
		<c:if test="${nouvel_amis != null}">
			<div class="alert alert-success">
				<p>Nouvel amis ajouté.</p>
			</div>
		</c:if>
		<div class="row">
			<nav class="navbar navbar-findcond ">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar">
							<span class="sr-only"><img
								src="<c:url value="/resources/images/bookshare.png"/>"
								height="30" width="30"
								style="margin-top: 3px; margin-right: -20px;"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><img
							src="<c:url value="/resources/images/bookshare.png"/>"
							height="30" width="30"
							style="margin-top: 3px; margin-right: -20px;"></a>
					</div>
					<div class="collapse navbar-collapse" id="navbar">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${pageContext.request.contextPath }/acceuil"
								role="button" aria-expanded="false"><i
									class="fa fa-fw fa-home"></i> Acceuil</a></li>
							<li class="dropdown"><a
								href="${pageContext.request.contextPath }/mes_notification"
								role="button" aria-expanded="false"><i
									class="fa fa-fw fa-bell-o"></i> Notifications <span
									class="badge">${utilisateur.notification}</span></a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false">${utilisateur.username}
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="${pageContext.request.contextPath }/logout">Se
											deconnecter</a></li>
									<li><a href="#">Mon Compte</a></li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-fw fa-credit-card"></i> ${utilisateur.credit}€</a></li>

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
											<td><a href="${pageContext.request.contextPath }/emprunte">Emprunt</a> <span
												class="label label-success">$ 320</span></td>
										</tr>
										<tr>
											<td><a href="${pageContext.request.contextPath }/prete">Prétés</a></td>
										</tr>
										<tr>
											<td><a href="${pageContext.request.contextPath }/remi">Remis</a></td>
										</tr>
										<tr>
											<td><a href="${pageContext.request.contextPath }/attente">En Attenter</a></td>
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
<p> liste des livres empruntés tototo tototo tototo </p>

<jsp:useBean id="listeLivreEmpruntes" class="java.util.ArrayList" scope="session"></jsp:useBean>
	<div class="row">
		<c:forEach items="${listeLivreEmpruntes}" var="livre" varStatus="test">
			<div class="col-xs-4">
				<div class="thumbnail" style="max-width: 230px; max-height: 230px">
					<a href="#myModal${test.index}" data-toggle="modal"> <img
						src='<c:url value="/resources/images/image${livre.getLivre().getId()}.jpeg"></c:url>'
						style="max-width: 300px; max-height: 225px"></a>
				</div>
				<div id="myModal${test.index}" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Informations sur le livre</h4>
							</div>
							<div class="modal-body">
								<p>Ce livre a été Emprunté par :</p>
								<p class="text-warning">
									<small>${livre.getLivre().getDescription()}</small>
								</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
<p>Petit test test test test test </p>
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