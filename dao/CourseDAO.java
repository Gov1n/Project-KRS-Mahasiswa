package dao;

import model.Course;
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
public class CourseDAO {

    public CourseDAO() {
    }

   
    public int create(Course course) {
        String sql = "INSERT INTO courses (code, name, sks, semester) VALUES(?,?,?,?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, course.getCode());
            stmt.setString(2, course.getCourseName()); 
            stmt.setInt(3, course.getSKS());
            stmt.setInt(4, course.getSemester());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    
    public List<Course> getCourse() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int sks = rs.getInt("sks");
                int semester = rs.getInt("semester");
                
                
                courses.add(new Course(code, name, sks, semester));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }


    public int update(Course course, String oldCode) {
        String sql = "UPDATE courses SET code=?, name=?, sks=?, semester=? WHERE code=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, course.getCode());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3, course.getSKS());
            stmt.setInt(4, course.getSemester());
            stmt.setString(5, oldCode);
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

   
    public int delete(String code) {
        try {
            Connection connection = DBConnection.getConnection();
            
           
            String disableSafe = "SET SQL_SAFE_UPDATES = 0";
            PreparedStatement stmtDisable = connection.prepareStatement(disableSafe);
            stmtDisable.executeUpdate();
            
          
            String sql = "DELETE FROM courses WHERE code=?";
            PreparedStatement stmtDelete = connection.prepareStatement(sql);
            stmtDelete.setString(1, code);
            stmtDelete.executeUpdate();
            
          
            String enableSafe = "SET SQL_SAFE_UPDATES = 1";
            PreparedStatement stmtEnable = connection.prepareStatement(enableSafe);
            stmtEnable.executeUpdate();
            
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
