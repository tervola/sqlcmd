<html>
<head>
  <title>SQLCmd</title>
</head>
<body>
Help List
 "help: \n\t\tShow this help" <br>
 "exit: \n\t\tOutput from the program" <br>
 "list: <br>
"\t\tList of tables into the database" <br>
 "Select from table: <br>
"\t\tSelect records from table, examples:" <br>
"\t\t" + " \"SELECT * FROM name\"" <br>
"\t\t" + " \"SELECT * FROM name WHERE id > 1\"" <br>
"\t\t" + " \"SELECT id FROM name WHERE id < 1\"" <br>
 "Insert into table: <br>
"\t\t" + " \"INSERT INTO id (id_name,id_temp,country_name) VALUES (3, 'tree', 'UA');\"" <br>
"\t\t" + " \"INSERT INTO employee (id,name,alias) VALUES (1, 'Stas', 'tervola');\"" <br>
 "Updating records: <br>
"\t\tupdating records into table" <br>
"\t\t" + " \"UPDATE id set country_name = 'Unknown' WHERE country_name ='null';\"" <br>
 "Deleting records: <br>
"\t\t" + " \"DELETE FROM id WHERE id_name = 4;\"" <br>
 "drop: <br>
"\t\t\"DROP TABLE films, distributors;\"" <br>
 "Create table: <br>
"\t\t" + " \"CREATE TABLE COMPANY (ID INT, NAME TEXT NOT NULL, AGE INT NOT NULL)\";"
</body>
</html>
