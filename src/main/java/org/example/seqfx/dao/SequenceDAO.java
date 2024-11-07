package org.example.seqfx.dao;

import org.example.seqfx.model.Sequence;
import org.example.seqfx.util.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SequenceDAO {

    private final Connection connection;

    public SequenceDAO() {
        this.connection = ConnectDB.getConnection();
    }

    public List<Sequence> getAllSequences() {
        List <Sequence> sequences = new ArrayList<>();
        String sqlMessage = "SELECT * FROM sequences";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlMessage);
             ResultSet resultSet = pstmt.executeQuery()){

            while(resultSet.next()) {
                sequences.add(new Sequence(resultSet.getLong("id"), resultSet.getString("name")));
            }
            return sequences;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Sequence getSequence(Long id) {
        String sqlMessage = "SELECT * FROM sequences WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlMessage)){
            pstmt.setLong(1, id);
            try(ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Sequence(resultSet.getLong("id"), resultSet.getString("name"));
                }
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean updateSequence(Long id, String name) {
        String sqlMessage = "UPDATE sequences SET name = ? where id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sqlMessage)) {
            pstmt.setString(1, name);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
