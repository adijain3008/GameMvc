<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teams</title>
</head>
<body>
<h1>My Teams</h1>
<table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Country</th>
        </tr>
        <c:forEach items="${list}" var="team">
         <tr>
            <td>${team.id}</td>
            <td>${team.name}</td>
            <td>${team.country}</td>
        </tr>
        </c:forEach>
    
    </table>
</body>
</html>