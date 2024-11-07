package org.example.seqfx.dao;

import org.example.seqfx.util.ConnectDB;
import org.example.seqfx.util.DatabaseInitializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ViewDAO {

    private final Connection connection;

    public ViewDAO() {
        this.connection = ConnectDB.getConnection();
    }

    public Boolean createView(String name, Long seqId) {
        String sqlMessage = "INSERT INTO views (name, sequence_id) VALUES(?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sqlMessage)) {
            pstmt.setString(1, name);
            pstmt.setLong(2, seqId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
