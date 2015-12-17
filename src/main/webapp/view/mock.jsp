<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>SQLCmd</title>
    </head>
    <body>
    <form action="mock" method="post">
        <table>
            <tr align="left">
                <td>Use for connect to DB server with hardcoded parameters</td>
            </tr>
            <tr></tr>
            <tr>
                <td><input type="submit" name="connect" value="Connect!"></td>
            </tr>
    </table>
    </form>
    <br>
    <%@include file="footer_menu.jsp"%>
    <%@include file="footer.jsp"%>
</body>
</html>