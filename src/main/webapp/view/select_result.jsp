<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>
SELECT RESULT:
<table border="1" width="300">
    <caption align="left">Result select command from table:</caption>
    <c:forEach items="${select}" var="row" varStatus="loop">
        <tr>
            <td> ${loop.index} </td>
            <c:forEach items="${row}" var="colums" varStatus="loop">
                <td>
                        ${colums}
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

<%@include file="footer_menu.jsp" %>
<%@include file="footer.jsp" %>
</p>

</body>
</html>