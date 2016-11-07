<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<div align="center">
		<h1>Registration and loggin form</h1>
	</div>

	<table>
		<tr><td><a href="${pageContext.request.contextPath }/register">Registration</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/login">Login</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/creercategorie">Creer Categorie</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/bookshare">Bookshare</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/userProfile">UserProfile</a></td></tr>
	</table>

</body>
</html>
