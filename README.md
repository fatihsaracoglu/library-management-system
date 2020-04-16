# Library Management System

It is a library management project that you can add/update/delete books and authors.  

This project was developed using Spring Boot, Spring Security, Thymeleaf, and PostgreSQL.

## Installation

Before running the application, you need to have:

- JDK (at least v11)
- PostgreSQL
- Maven

Since the application is connected with PostgreSQL, you should edit some parts of the project:

- Create a database in PostgreSQL
- Go into **/src/main/resources/application.properties** and change these settings according to your configuration:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/librarydb  
spring.datasource.username=postgres  
spring.datasource.password=test123
```

After these configurations, go into the project root directory (where pom.xml is in) and run below command on the command line:

```$ mvn spring-boot:run```

## Authentication and Authorization

In order to add/update/delete books etc., you should login with admin account. The application is coming with a default admin:

```
username: admin  
password: admin
```

Normal users can just view the books, authors etc.

## Screenshots

![Imgur](https://i.imgur.com/T7RZM9C.png)

![Imgur](https://i.imgur.com/yKQM1sW.png)

![Imgur](https://i.imgur.com/fPAOtyI.png)

![Imgur](https://i.imgur.com/6FtbW5J.png)

![Imgur](https://i.imgur.com/puqMaD0.png)

![Imgur](https://i.imgur.com/BMNYQOs.png)

