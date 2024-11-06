package org.example.seqfx.dao;

import org.example.seqfx.model.Sequence;
import org.example.seqfx.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SequenceDAO {

   private Connection connection;

    public SequenceDAO() {
        this.connection = ConnectDB.getConnection();
    }

    public Boolean addSequence(String name) {
        String sqlMessage = "INSERT INTO sequences (name) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlMessage);){
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
