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
                <td>"SELECT * FROM id"</td>
                <td><input type="submit" name="command_mock"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Go!"></td>
            </tr>
        </table>
    </form>
    <%@include file="footer.jsp"%>
</body>
</html>