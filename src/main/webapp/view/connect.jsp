<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>
<form:form method="POST" action="connect" modelAttribute="connection">

    <table>
        <tr>
            <td>Database name</td>
            <td><form:input path="database" id="database"/></td>
        </tr>
        <tr>
            <td>User name</td>
            <td><form:input path="userName" id="username"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:password path="password" id="password" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="connect" id="connect"></td>
        </tr>
    </table>
</form:form>

    <%@include file="footer_menu.jsp" %>
    <%@include file="footer.jsp" %>
</body>
</html>