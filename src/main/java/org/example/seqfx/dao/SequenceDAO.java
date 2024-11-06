package org.example.seqfx.dao;

import org.example.seqfx.model.Sequence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SequenceDAO {

   private Connection connection;

    public SequenceDAO(Connection connection) {
        this.connection = connection;
    }

    public Boolean addSequence(String name) {
        try {
            String sqlEntry = "INSERT INTO sequences (name) VALUES (?)";
            PreparedStatement pstmt = connection.prepareStatement(sqlEntry);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
