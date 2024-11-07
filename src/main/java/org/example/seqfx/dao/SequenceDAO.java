package org.example.seqfx.dao;

import org.example.seqfx.model.Sequence;
import org.example.seqfx.util.ConnectDB;
import java.sql.*;

public class SequenceDAO {

    private Connection connection;

    public SequenceDAO() {
        this.connection = ConnectDB.getConnection();
    }

    public Sequence getSequence(Long id) {
        String sqlMessage = "SELECT * FROM sequences WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlMessage);
            pstmt.setLong(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return new Sequence(resultSet.getLong("id"), resultSet.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Boolean addSequence(String name) {
        String sqlMessage = "INSERT INTO sequences (name) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlMessage)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteSequence(Long id) {
        String sqlMessage = "DELETE FROM sequences WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlMessage)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
