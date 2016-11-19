<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bienvenue sur BiblioShare</title>

	<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/index.css' />" ></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/helper.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/profil.css' />"></link>
	<link rel="stylesheet" href="<c:url value='/resources/js/jquery-3.1.1.min.js' />"></link>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
					<style>
					/* CSS */
					.cModal {
					  position: fixed;
					  z-index: 99999;
					  top: 0;
					  right: 0;
					  bottom: 0;
					  left: 0;
					  background: rgba(0, 0, 0, 0.8);
					  opacity:0;
					  pointer-events: none;
					}
					.cModal:target {
					  opacity:1;
					  pointer-events: auto;
					}
					.cModal > div {
					  width: 400px;
					  min-height:100px;
					  height:auto;
					  position: relative;
					  margin: 10% auto;
					  padding: 8px 8px 8px 8px;
					  border-radius: 2px;
					  background: #fff;
					  text-align: center;
					}
					</style>

</head>

<body>
<header>
    <div>
        <nav class="navbar  navbar-fixed-top navbar-default ">
            <div class="container">
                <div class="navbar-header">
                    <div>
                        <ul class="nav navbar-nav">
                            <li><a class="navbar-brand" href="?controller=apropos&action=apropos"><img
								src="<c:url value="/resources/images/bookshare.png"/>"
								height="40" width="40"
								style="margin-top: 3px; margin-right: -20px;"></a></li>
						<li class="logo"><a
							style="color: #1a7ad9 !important; margin-right: 200px; margin-left: 30px">BiblioShare</a></li><a>
                                <form id="custom-search-input" style="display: inline-block; max-width: 500px; ">
                                    <div class="input-group col-md-12">
                                        <input type="text" class="  search-query form-control" placeholder="Recherche un ami et emprunte ses livres" />
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" >
                                        <span class=" glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                                    </div>
                                </form></a>
                            </li>
                        </ul>
                    </div>

                </div>




                <ul class="nav navbar-nav navbar-right" >
                    <li id="notification_li">
                        <span id="notification_count" hidden></span>
                        <a href='?controller=utilisateur&action=posterpensee' class="header-text" id="notificationLink"><i class="material-icons">notifications</i></a>
                        <div id="notificationContainer">
                            <div id="notificationTitle">Notifications</div>
                            <div id="notificationsBody" class="notifications scroll">
                                <ul class="nav" id="notifications-ul">

                                </ul>
                            </div>
                            <div id="notificationFooter"><a href="#" class="notif-link-footer"><i class="material-icons">sentiment_satisfied</i></a></div>
                        </div>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/login" class="header-text">Accueil</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="margin-top: 5px; color:dimgrey;" onmouseover="this.style.color='#1e90fe';this.style.color='#1e90fe';" onmouseout="this.style.background='';this.style.color='dimgrey';">
                           ${username_user}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href='#'>Profil</a></li>
                            <li><a href="#">Se Déconnecter</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>


<div class="card card-container">

	<table>
		<tr>
			<td><img src="<c:url value="/resources/images/thomas.jpg"/>" class="img-circle" alt="Cinque Terre" width="100" height="100"></td>
			<td>${prenom_user}</td>
			<td style="padding-left: 10px;">${nom_user}
			</td>
			
			<td style="padding-left: 10px;">

				<!-- HTML -->
				<div id="oModal" class="cModal">
				  <div>	<br>		    
				   <center>
				   	<a href="${pageContext.request.contextPath}/change_password"> modifier le mot de passe</a><br><br>
				   	<a href="${pageContext.request.contextPath}/change_email"> modifier votre E-mail</a><br><br>
					<a href="#"> Supprimer mon compte</a><br><br><br>
				   </center>
					
				    <footer class="cf">
				      <a href="#fermer" class="btn">Fermer</a>
				    </footer>
				  </div>
				</div>
				<a href="#oModal"><span class="glyphicon glyphicon-pencil">Editer</span></a>
								
			</td>
			
			
			
		</tr>
		<tr >
			<td class="td-pic"><a href="#">${nb_livre} livre(s)</a></td>
			<td  class="td-pic" style="text-align: center"> | </td>
			<td class="td-pic"><a href="#"> ${nb_amis} ami(s)</a></td>
		</tr>



	</table>
	<div  class="td-pic" style="text-align: center; font-weight: 900;">A Propos </div>
	<div  style="text-align: center">Doctorant en droid, passionné de livre de fiction et d'action</div>
</div>


	<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/notification.js"></script>

	
	
</body>
</html>