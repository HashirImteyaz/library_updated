*Overview* <br>
This is a Library Management System built using Spring Boot, which allows users to register, log in, and manage a collection of books (employees). 
The application provides functionalities for adding, editing, and deleting book records, as well as user authentication.

*Features*<br>
User registration and login
Add, edit, and delete book records
View all books in the library
Responsive web interface using Thymeleaf and Bootstrap

*Technologies Used*<br>
Backend: Spring Boot, Spring Data JPA
Database: MySQL
Frontend: HTML, CSS, Thymeleaf, Bootstrap
Java Version: 17

*Installation* <br>
git clone <repository-url>  <br>
cd library_updated

*Set up the MySQL database:* <br>
`spring.datasource.url=jdbc:mysql://localhost:3306/library_db` <br>
`spring.datasource.username=<your-username>` <br>
`spring.datasource.password=<your-password>` <br>
`spring.jpa.hibernate.ddl-auto=update` <br>

*Build the project:* <br>
mvn clean install

*Run the application:* <br>
mvn spring-boot:run

*Directory Structure*

library_updated/ <br>
├── src/  <br>
│   ├── main/   <br>
│   │   ├── java/  <br>
│   │   │   └── com/   <br>
│   │   │       └── arvind/   <br>
│   │   │           ├── controller/   <br>
│   │   │           ├── entity/       <br>
│   │   │           ├── repository/     <br>
│   │   │           ├── service/       <br>
│   │   │           └── Application.java    <br>
│   │   └── resources/   <br>
│   │       ├── templates/   <br>
│   │       └── application.properties    <br>
└── pom.xml   <br>


*On web browser type*
http://localhost:1200/regPage 
