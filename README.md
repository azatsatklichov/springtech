# spring tech 

- For incremental development using springboot technologies, and applying 12factor principles to the project  

## Requirements:

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
 

## Testing 

To test API, use either Browser-Swagger, Postman REST client, IntelliJ http-client in scratches,  or JUnit

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

See scratches directory 
   

## Integrated 
 
- Spring Boot project 
- Thymeleaf
- Lombok
- JSON
- REST API
- Swagger, Postman, IntelliJ http client, Spring REST clients
- JPA/JPS Data Integration
- Flyway
- Config Properties

 
## TO BE
 
- PDF
- Mail services 
- Messaging
- Security
