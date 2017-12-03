<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Spitter</title>
<link rel="stylesheet" style="text/css"
	href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<div class="spittleForm">
		<h1>Spit it out...</h1>
		<form method="POST" name="spittleForm">
			<input type="hidden" name="latidute"> 
			<input type="hidden" name="longitude">
			<textarea name="message" rows="5" cols="80"></textarea>
			<br /> 
			<input type="submit" value="Add" />
		</form>
	</div>
	<div class="spittleList">
		<h1>Recent Spittles</h1>
		<ul class="spittleList">
			<c:forEach items="${spittleList}" var="spittle">
				<li id="spittle_<c:out value="spittle.id" /> ">
					<div class="spittleMessage">
						<c:out value="${spittle.message}" />
					</div>
					<div>
						<span class="spittleTime"><c:out value="${spittle.time}" /></span>
						<span class="spittleLocation">
							(<c:out value="${spittle.latitude}" />, 
							 <c:out value="${spittle.longitude}" />)
						</span>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>