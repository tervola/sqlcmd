<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>
<form action="select" method="post">
    <table>
        <tr>
            <td>Input command:</td>
            <td><input type="text" name="command"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Execute"></td>
        </tr>
    </table>
</form>
<%@include file="footer_menu.jsp" %>
<%@include file="footer.jsp" %>
</body>
</html>