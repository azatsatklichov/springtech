# spring tech 

- For incremental development  

## Requirements:

Before start install these tools

- Eclipse or Intellij IDEA
- JDK 1.8 or later welcome
- Maven
- Install PostgresSQL database, and create Db "pandc" with user/pwd: postgres/postgres and follow db/postgresql
  PostgreSQL(e.g. version 11.3,  pgAdmin 4) 
- embedded Tomcat provided by Spring Boot, but welcome to change it to Jetty or etc.
- Extract FakeSMTP server under docs folder and just run it before tryin mail-services

## Install the project and surroundings:

    git clone https://github.com/azatsatklichov/springtech.git

## Project build and run
Just in command line run below command
> run.bat
 

To test API either use Browser-Swagger, Postman REST client, IntelliJ http-client,  or JUnit  
-----------------

A. Test on browser

http://localhost:9999/hello/book

B. Via Swagger

http://localhost:9999/swagger-ui.html

C. Postman

Install Postman client. 
POST method, http://localhost:9999/api/rate
Set headers: 
Content-Type = application/json
Accept = application/json

BODY
{
  "amount": 3,
  "product": "Nike"
}


D. IntelliJ Scratches

See docs/ directory 


E. JUnit tests - https://www.baeldung.com/rest-template

run: RestTemplateClient
   

DONE
-----
-Spring Boot project creation
-lombok
-JSON
-REST API
-Swagger, Postman, IntelliJ http client, Spring REST clients
-JPA/JPS Data Integration

- Flyway
https://hellokoding.com/database-migration-evolution-with-flyway-and-jpa-hibernate/
https://www.baeldung.com/database-migrations-with-flyway
https://www.tutorialspoint.com/spring_boot/spring_boot_flyway_database.htm
https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/
id-issue
https://stackoverflow.com/questions/39855979/jpa-schema-validation-with-postgresql-9-5
https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/

-- Config Properties in Spring
https://www.baeldung.com/configuration-properties-in-spring-boot
 
TODO BE
-----
-Thymeleaf
-PDF
-Mail services
-Properties with Spring and Spring Boot - https://www.baeldung.com/properties-with-spring 
 
TODO FE
-----
Angular/TS client 
Node.js 
Mongo DB 

 
