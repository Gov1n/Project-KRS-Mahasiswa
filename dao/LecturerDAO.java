package dao;

import model.Lecturer;
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
public class LecturerDAO {

    public LecturerDAO() {
    }

    public int create(Lecturer lecturer) {
        try {
            
            String sql = "INSERT INTO lectures (name, cardID, nidn, expertise) VALUES(?,?,?,?)";
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, lecturer.getName());
            stmt.setString(2, lecturer.getCardID()); 
            stmt.setString(3, lecturer.getNidn());
            stmt.setString(4, lecturer.getExpertise()); 
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Lecturer> getLecturer() {
        List<Lecturer> lectures = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lectures";
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString("name");
                String cardID = rs.getString("cardID");
                String nidn = rs.getString("nidn");
                String expertise = rs.getString("expertise");
                
                lectures.add(new Lecturer(cardID, name, nidn, expertise));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    public int update(Lecturer lecturer, String oldNidn) {
        try {
            String sql = "UPDATE lectures SET name=?, cardID=?, nidn=?, expertise=? WHERE nidn=?";
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, lecturer.getName());
            stmt.setString(2, lecturer.getCardID());
            stmt.setString(3, lecturer.getNidn());
            stmt.setString(4, lecturer.getExpertise());
            stmt.setString(5, oldNidn);
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String nidn) {
        try {
           
            String sql = "DELETE FROM lectures WHERE nidn=?";
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, nidn);
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}