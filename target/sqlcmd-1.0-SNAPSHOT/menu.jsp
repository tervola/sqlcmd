<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCmd</title>
    </head>
    <body>
    Hello World!
    <a href="/help">Help</a> <br>
    <a href="/connect">Connect</a> <br>
    <a href="/exit">Exit</a> <br>


    <!--c:forEach items="${manuItems}" var="item">
        <a href="/sqlcmd/project?category=${item.id}"><c:out value="${$item.name}"/></a>
    <!--/c:forEach!-->
    </body>
</html>