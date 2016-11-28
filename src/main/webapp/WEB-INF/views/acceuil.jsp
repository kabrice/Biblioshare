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

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">
<link href="<c:url value='/resources/css/index.css' />" rel="stylesheet"></link>

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
				<div class="col-sm-2 col-md-2">
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
				<div class="col-sm-8 col-md-8">
					<div class="well">

						<c:if
							test="${not fn:endsWith(pageContext.request.requestURI, '/acceuil')}">
							<a href="${pageContext.request.contextPath }/bookshare">Bookshare</a>
							<jsp:include page="livres-users.jsp"></jsp:include>
						</c:if>

					</div>
					<div class="well">

						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#home">CATEGORY</a></li>
							<li><a data-toggle="tab" href="#menu1">AUTEUR</a></li>
							<li><a data-toggle="tab" href="#menu2">EDITEUR</a></li>
							<li><a data-toggle="tab" href="#menu3">COLLECTION</a></li>
							<li><a data-toggle="tab" href="#menu4">UTILISATEURS</a></li>
						</ul>

						<div class="tab-content">
							<div id="home" class="tab-pane fade in active">
								<div class="col-sm-1 col-md-1">
									<form action="" method="post">
										<select name='categorie' class="selectpicker"
											data-live-search="true" id="categorieLivre">
											<option value="Categorie" data-tokens="Categorie">Liste
												Categorie</option>
											<c:forEach items="${listeCategorie}" var="categorie">

												<option value="${categorie.id}"
													data-tokens="${categorie.libelle}">${categorie.libelle}</option>

											</c:forEach>
										</select>

									</form>
								</div>


								<jsp:include page="livre-user-categorie.jsp"></jsp:include>


								<h3>HOME</h3>

							</div>
							<div id="menu1" class="tab-pane fade">
								<h3>Menu 1</h3>
								<p>Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
							</div>
							<div id="menu2" class="tab-pane fade">
								<h3>Menu 2</h3>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam.</p>
							</div>
							<div id="menu3" class="tab-pane fade">
								<h3>Menu 3</h3>
								<p>Eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo.</p>

							</div>

							<div id="menu4" class="tab-pane fade">
								<c:if test="${deja_envoyer != null}">
									<div class="alert alert-danger">${deja_envoyer}</div>
								</c:if>


							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-2 col-md-2">
					<div class="well">
						<form action="" method="post">
							<select name='utilisateurs' class="selectpicker"
								data-live-search="true" id="utilisateurs">
								<option value="utilisateur" data-tokens="Utilisateurs">Liste
									Utilisateurs</option>
								<c:forEach items="${listeUtilisateur}" var="listeUser">

									<option value="${listeUser.id}"
										data-tokens="${listeUser.username}">${listeUser.username}</option>

								</c:forEach>
							</select>

						</form>
						<ul>
							<c:forEach items="${listeAmis}" var="listeAmis">
<!-- 							Lilian à défénir des que marcelin fini pour afficher le profil -->
								<li><a href="#"> ${listeAmis.username} </a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div></div>
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
		$(function() {
			$('#categorieLivre')
					.bind(
							'change',
							function() {
								var idCateg = $(this).val(); // get selected value
								window.location = "${pageContext.request.contextPath }/categorie/"
										+ idCateg;

								return true;
							});
		});

		$(function() {
			$('#utilisateurs')
					.bind(
							'change',
							function() {
								var idUser = $(this).val(); // get selected value
								window.location = "${pageContext.request.contextPath }/demande_amis/"
										+ idUser;

								return true;
							});
		});
	</script>


</body>
</html>