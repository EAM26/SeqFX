package org.example.seqfx.dao;

import org.example.seqfx.controller.SequenceController;
import org.example.seqfx.model.Sequence;
import org.example.seqfx.model.View;
import org.example.seqfx.util.ConnectDB;
import org.example.seqfx.util.DatabaseInitializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewDAO {

    private final Connection connection;
    private final SequenceController sequenceController;

    public ViewDAO(SequenceController sequenceController) {
        this.connection = ConnectDB.getConnection();
        this.sequenceController = sequenceController;
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

    public View getView(Long id) {
        String sqlMessage = "SELECT * FROM views WHERE id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sqlMessage)) {
            pstmt.setLong(1, id);

            try(ResultSet resultSet = pstmt.executeQuery()){
                if(resultSet.next()) {
                    Long viewId = resultSet.getLong("id");
                    String viewName = resultSet.getString("name");
                    Long sequence_id = resultSet.getLong("sequence_id");
                    Sequence sequence = sequenceController.getSequence(sequence_id);
                    return new View(viewId, viewName, sequence);
                }
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
