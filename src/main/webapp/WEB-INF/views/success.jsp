<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Spring MVC Tutorial Series by Crunchify.com</title>

<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"></link>

<link href="<c:url value='/resources/css/index.css' />" rel="stylesheet"></link>	


<style type="text/css">
body {
	
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-findcond ">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar">
							<span class="sr-only">BiblioShare</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">BiblioShare</a>
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
							<li><img src="images/hum.jpg" alt="profil"
								class="img-circle" style="width: 40px; padding-top: 5px;" /></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false">Pseudo
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">D�connexion</a></li>
									<li><a href="#">Mon Compte</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-right search-form" role="search">
							<input type="text" class="form-control"
								placeholder="rechercher livre, auteur,�diteur,collection, amis"
								style="width: 400px" />
						</form>
					</div>
				</div>
			</nav>
		</div>
		<div class="row">

			<div class="col-xs-6 col-md-4">Meilleures s�lections</div>
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
									</span>Activit�s sur Livre</a>
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
											<td><a href="#">Pr�t�s</a></td>
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
						<h1>Liste de Nos Livres</h1>
						Et puis Basta
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="text-align: center">
		<h3>
			<a href="welcome.html">Click here to See Welcome Message... </a>
			<!-- Standard button -->
		</h3>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	

</body>
</html>