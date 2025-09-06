package com.studentmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (id, name, grade) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getGrade());
            pstmt.executeUpdate();
        }
    }

    public Student getStudent(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("grade"));
                }
            }
        }
        return null;
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("grade")));
            }
        }
        return students;
    }

    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, grade = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGrade());
            pstmt.setInt(3, student.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
