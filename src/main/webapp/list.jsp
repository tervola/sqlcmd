<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCmd</title>
    </head>
    <body>

    <table border="1" width="200">
        <caption align="left">List of tables into the database:</caption>
        <c:forEach items="${tablelist}" var="row" varStatus="loop">
        <tr>
            <td> ${loop.index} </td>
            <td>
               ${row} <br>
            </td>
        </tr>
        </c:forEach>
    </table>
    <p>You can go to  <a href="help">help</a> <br> or  <a href="menu">Menu</a>
    <%@include file="footer.jsp"%>
    </p>

</body>
</html>