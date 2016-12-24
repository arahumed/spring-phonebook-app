
Introduction
============

A simple spring MVC phonebook app used to educate myself on how to use the
Spring framework.

This is based from the guides in https://spring.io/guides
- Spring MVC
- Spring JPA
- Handling Form Submission.

Features
- Add new persons
- Remove persons
- List persons



To run
======

If you have maven and JDK installed, you can run the program by:
./mvnw clean package
java -jar target/phonebook-0.0.1-SNAPSHOT.jar 

Then point the browser to http://localhost:8080



Configuration
=============

This project makes use of the H2 database.
To make the storage of the phonebook persistent. 

You may edit the applications.properties file included in this project by 
1. Uncommenting lines relating to "datasource". except for the username and password, which is not supported by H2 DB.
2. Also, uncomment the line spring.jpa.hibernate.ddl-auto=validate

In addition, you may want to remove code which initializes the sample database in the main program.
Look for the string @SpringBootApplication to find the main program.


References 
==========
http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-connect-to-production-database
http://www.h2database.com/html/quickstart.html


Future Ideas
============
...
