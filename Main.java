package com.studentmanagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {
        System.out.println("Please create the following database and table in your MySQL client:");
        System.out.println("CREATE DATABASE studentdb;");
        System.out.println("USE studentdb;");
        System.out.println("CREATE TABLE students (id INT PRIMARY KEY, name VARCHAR(255), grade VARCHAR(255));");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        viewStudent(scanner);
                        break;
                    case 3:
                        viewAllStudents();
                        break;
                    case 4:
                        updateStudent(scanner);
                        break;
                    case 5:
                        deleteStudent(scanner);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void addStudent(Scanner scanner) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        studentDao.addStudent(new Student(id, name, grade));
        System.out.println("Student added successfully.");
    }

    private static void viewStudent(Scanner scanner) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = studentDao.getStudent(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() throws SQLException {
        List<Student> students = studentDao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void updateStudent(Scanner scanner) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new student grade: ");
        String grade = scanner.nextLine();
        studentDao.updateStudent(new Student(id, name, grade));
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent(Scanner scanner) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        studentDao.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }
}