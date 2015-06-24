<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><%=Constants.WEB_NAME%> - <%=Constants.MENU_SEARCH_SCHOLAR_NAME%></title>

<link href="<c:url value="/resources/css/result-content.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/freelancer.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>

<!-- data table -->
<script src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
<script src="<c:url value="/resources/js/DT_bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script type="text/javascript">
	$(function() {
		doAjaxPost()
	});

	function doAjaxPost() {
		var dataString = document.getElementById("keyword").innerHTML;
		$.ajax({
			type : "POST",
			data : keyWord = dataString,
			contentType : "application/json",
			dataType : "text",
			url : "searchSubView",
			success : function(response) {
				document.getElementById('load-data').style.display = 'none';
				$("#subViewDiv").html(response);
				$('#myTable').dataTable();
			}
		});
	}
</script>

</head>
<body>
	<div id="viewport">
		<nav class="navbar navbar-default navbar-fixed-top"
			style="margin: 0px">

			<div class="container">
				<div class="navbar-header page-scroll">
					<a class="navbar-brand" href="<c:url value="/" />"><%=Constants.WEB_NAME%></a>
					<div class="navbar-header page-scroll">
						<%@include file="search-box.jsp"%>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="hidden"><a href="#page-top"></a></li>
						<li class="page-scroll"><a href="<c:url value="/" />"><%=Constants.MENU_HOME%></a></li>
						<li class="page-scroll"><a href="<c:url value="/filter" />"><%=Constants.MENU_FILTER%></a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="content-section" id="filter-intro">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2><%=Constants.TITLE_SEARCH%>
							<br>
						</h2>
						<p id="keyword" style="font-size: 30px; padding: 0; margin: 0">'${keyWord}'</p>
						<hr class="star-light">
					</div>
				</div>
				<div class="row">
					<div class="start-list-result">Có ${resultTotal} kết quả</div>
				</div>
				<br>
			</div>
			<c:if test="${resultTotal!=0}">
				<div class="row">
					<div class="filter-fieldset">
						<p id="load-data"><%=Constants.MESSAGE_LOADING%></p>

						<div id="subViewDiv"></div>
					</div>
				</div>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
