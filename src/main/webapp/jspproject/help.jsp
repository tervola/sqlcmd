<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>SQLCmd</title>
</head>
<body>
Help list:<br>
<ul>
    <li>help:<br> Show this help
        <p><li>exit:<br> Output from the program</li>
        <p><li>list:<br> List of tables into the database</li>
        <p><li>Select from table:<br>Select records from table, examples:</li>
    <br>SELECT * FROM name
    <br>SELECT * FROM name WHERE id > 1
    <br>SELECT id FROM name WHERE id < 1
    <p><li>Insert into table, examples:
        <br>INSERT INTO id (id_name,id_temp,country_name) VALUES (3, 'tree', 'UA')
        <br>INSERT INTO employee (id,name,alias) VALUES (1, 'Stas', 'tervola')
    <p><li>Updating records:<br>Updating records into table, example:
        <br>UPDATE id set country_name = 'Unknown' WHERE country_name ='null'
    <p><li>Deleting records, example::
        <br>DELETE FROM id WHERE id_name = 4
    <p><li>drop, example:
        <br>DROP TABLE films, distributors
    <p><li>Create table, example:
        <br>CREATE TABLE COMPANY (ID INT, NAME TEXT NOT NULL, AGE INT NOT NULL)
</ul>
You can go to <a href="menu">Menu</a>

<%@include file="footer.jsp"%>

</body>
</html>
