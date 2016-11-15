<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listes des livres</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/listeretoile.css' />"
	rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

</head>
<body>

	<div class="row">
		<c:forEach items="${livresUsers}" var="livre" varStatus="vs">
			<div class="col-xs-4">
				<div class="thumbnail">
					<a href="#myModal${vs.index}" data-toggle="modal"> <img
						src='<c:url value="/resources/images/image${livre.id}.jpeg"></c:url>'
						style="max-width: 300px; max-height: 225px"></a>
					<div class="rating rating2">

						<a href="?id=${livre.id}&note=4" title="Noter à 4">★</a> <a
							href="?id=${livre.id}&note=3" title="Noter à 3">★</a> <a
							href="?id=${livre.id}&note=2" title="Noter à 2">★</a> <a
							href="?id=${livre.id}&note=1" title="Noter à 1">★</a>
					</div>
				</div>
				<div id="myModal${vs.index}" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Informations sur le livre</h4>
							</div>
							<div class="modal-body">
								<p>Ce livre a été éditer par :</p>
								<p class="text-warning">
									<small>${livre.description}</small>
								</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>


	</div>
<script type="text/javascript">

</script>

</body>

</html>