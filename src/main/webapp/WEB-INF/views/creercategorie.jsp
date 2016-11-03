<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center"> 
		<h1>Create new Categorie</h1>
		<table>
		<f:form  modelAttribute="categorieData" action="creercategorie" method="post"> 
			<tr>
			<td>Libele</td>
			<td><f:input path="libelle"/></td>
			<td><f:errors path="libelle" cssStyle="color:red;"/></td>		
			</tr>
			<tr>
				<td><input type="submit" value="valider"></td>
			</tr>
		</f:form>
		</table>
	</div>

</body>
</html>