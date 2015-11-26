<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCmd</title>
    </head>
    <body>
    <c:forEach items="${items}" var="item">
        <a href="${item}">${item}</a> <br>
    </c:forEach>
    <br>
    <a href="log_clean">${logs}</a> <br>
    <br>
    <table style="font-size: small">
        <tr>
            <td>Connection status:</td>
            <td>${status}</td>
        </tr>
        <tr>
            <td>Database name:</td>
            <td>${dbname}</td>
        </tr>
        <tr>
            <td>User name:</td>
            <td>${username}</td>
        </tr>
    </table>
    <%@include file="footer.jsp"%>

</body>
</html>