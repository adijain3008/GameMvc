<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Players</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Age</th>
			<th>Batting Avg.</th>
			<th>Bowling Avg.</th>
		</tr>
		<c:forEach items="${list}" var="player">
		 <tr>
		 	<td>${player.id}</td>
		 	<td>${player.name}</td>
		 	<td>${player.type}</td>
		 	<td>${player.age}</td>
		 	<td>${player.battingAvg}</td>
		 	<td>${player.bowlingAvg}</td>
		 	
		</tr>
		</c:forEach>
	
	</table>
	
	<a href="index">Index</a>
</body>
</html>