# Spring Boot application example

Basic Java Spring application made using Spring AOP, Spring MVC, JPA and Spring Boot modules.

## Description

Basically this is an application connected to a MySQL database with one table (employees) and we can execute CRUD operations on this table. We can list all employees, add an employee, update an employee and delete an employee. 

## Installing and executing

* Install XAMPP or MySQL Workbench
* Create a database named "springdb" with user = "root" and password = "" with the following table
```
CREATE TABLE employees(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(25),
  surname VARCHAR(25),
  department VARCHAR(50),
  salary INT(11)
)
```
* Add some values
* Open the project with Intellij Idea
* Run it
* Go to localhost:8080/
