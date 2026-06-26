package dao;

import model.KRS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.DBConnection;

public class KrsDAO {

    public int create(KRS krs) {
       
        String sql = "INSERT INTO krs (code, nim, nidn, semester, score, grade) VALUES(?,?,?,?,?,?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, krs.getCode());
            stmt.setString(2, krs.getNim());
            stmt.setString(3, krs.getNidn());
            stmt.setInt(4, krs.getSemester());
            stmt.setDouble(5, krs.getScore());
            stmt.setString(6, krs.getGrade());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}