package org.example.seqfx.controller;

import org.example.seqfx.dao.SequenceDAO;

public class SequenceController {

    public final SequenceDAO seqDAO;

    public SequenceController() {
        this.seqDAO = new SequenceDAO();
    }


    public Boolean createSequence(String name) {
        return this.seqDAO.addSequence(name);
    }

}
