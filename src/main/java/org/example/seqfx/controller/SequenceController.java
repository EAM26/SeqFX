package org.example.seqfx.controller;

import org.example.seqfx.HelloApplication;
import org.example.seqfx.dao.SequenceDAO;

public class SequenceController {

    public final SequenceDAO seqDAO;

    public SequenceController() {
        this.seqDAO = new SequenceDAO(HelloApplication.getConnection());
    }


    public Boolean createSequence(String name) {
        try {
            this.seqDAO.addSequence(name);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
