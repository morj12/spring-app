# Spring application example

This is a basic Java Spring application made using Spring AOP, Spring MVC and Hibernate modules.

## Description

Basically there is an application connected to a MySQL database with one table (employees) and we can CRUD operations with this table. We can list all employees, add an employee, update an employee and delete an employee. 

## Getting Started

### Installing and executing

* Install XAMPP or MySQL Workbench
* Create a database named "springdb" with the following table
```
CREATE TABLE employees(
  id INT(11) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(25),
  surname VARCHAR(25),
  department VARCHAR(50),
  salary INT(11)
)
```
* Install Tomcat
* Download the project
* Open with Intellij Idea
* Build -> Build Artifacts -> spring_mvc_hib_aop:war exploded
* Run -> Edit configurations -> Tomcat Local -> Deployment -> add the artifact created in the last step
* Run -> Run 'Tomcat'
