/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.DBConnection;

/**
 *
 * @author ngura
 */
public class StudentDAO {

    public StudentDAO() {
    }
  

    public int create(Student student) {
      
        String sql = "INSERT INTO students (cardID, NIM, name, studiProgram) VALUES(?,?,?,?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getStudyProgram());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace(); 
            return 0;
        }
    }
   
    
    public List<Student> getStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                String cardID = rs.getString("cardID");
                String NIM = rs.getString("NIM");
                String name = rs.getString("name");
                String studiProgram = rs.getString("studiProgram");
                
               
                students.add(new Student(cardID, name, NIM, studiProgram));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
   
    
    public int update(Student student, String nim) {
        
        String sql = "UPDATE students SET cardID=?, name=?, studiProgram=? WHERE NIM=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getStudyProgram());
            stmt.setString(4, nim);
            
            stmt.executeUpdate();
            return 1;            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
   
    
    public int delete(String nim) {
        String sql = "DELETE FROM students WHERE NIM=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, nim);
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}