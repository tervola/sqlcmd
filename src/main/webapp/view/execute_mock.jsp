<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCmd</title>
    </head>
    <body>
    <form action="execute_mock" method="post">
        <p>Execution command: INSERT INTO id VALUES (222, 'mock', 'mock')
        </p>
        <table>
            <tr>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Executes!"></td>
            </tr>
        </table>
    </form>
    <%@include file="footer_menu.jsp"%>
    <%@include file="footer.jsp"%>
</body>
</html>