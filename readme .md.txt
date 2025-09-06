#Student Management system(Java+JDBC+MYSQL)

##project overview
This is a console based java application that allows users to manage student information stored in a MySQL database.
The application uses JDBC for database operations such as adding,updating,deleting,and viewing student records.

##features
-Add new student records
-update existing student details 
-Delete a student by ID
-View all students 
-Search for a student by ID or name 

##Technologies Used
-JAVA 
-MySQL Database
-JDBC
-IntelliJ IDEA
-MySQL Workbench

##project structure


StudentManagementSystem/
│── src/
│   ├── Main.java
│   ├── Student.java
│   ├── StudentDAO.java
│   ├── DatabaseConnection.java
│   └── ...
│
│── resources/
│   └── application.properties (DB credentials)
│
│── StudentDataBase.iml
│── README.md


##Setup the database

1.Open MySQL workbench
2.Create a databse
  
  CREATE DATABASE studentdb;

3.Creates a student table :

  CREATE TABLE students(
     id INT PRIMARY KEY,
     name VARCHAR(255), 
     grade VARCHAR(255));");

 
## Configure Database Connection

Update your DatabseConnection,java with your SQL credentials

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

##Run the application 
- Open in IntelliJ IDEA
-Build and run Main.java 
-Follow the console menue to manage students 

##Example usage 

=====Student Management system=====
1.Add students
2.View All students.
3.Search student
4.Update student
5.Delete student
6.Exit
Enter your Choice:


##Future improvements
-GUI version 
-Login and Authentication system

This Project is Open-Source .Feel free to use and modify it.








