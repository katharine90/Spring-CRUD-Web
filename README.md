This is a Spring application with a front and back-end (front-end build with jsp).
This application is connected to a mysql database written with jdbctemplate. The jdbctemplate is connected to the server using Jndi. 
You can perform simple crud operations (create, read, update and delete) from a user form. 

Prerequisites:
* Java 8
* Maven 

To run the project:
* Create a database with a 'member' table. 
* Within member table add attrubites (id(auto_implement, primary key), name, lname, adress, city, username). 
* To create the table enter command:  CREATE TABLE member(id int not null auto_increment, name varchar(30), lname varchar(45), adress varchar(60), city varchar(45), username varchar(45), primary key(id)); 
* Download project 'Spring-CRUD-WEB' from github repository. 
* Run the project on TomEE or tomcat server. 
* Choose action from welcome page from http://localhost:8080/Spring-Mvc-Members/

Source: https://www.youtube.com/watch?v=7f-B-bWu9YE + Udemy
