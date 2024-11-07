package org.example.seqfx.controller;

import org.example.seqfx.dao.SequenceDAO;
import org.example.seqfx.model.Sequence;

public class SequenceController {

    public final SequenceDAO seqDAO;

    public SequenceController() {
        this.seqDAO = new SequenceDAO();
    }


    public Sequence getSequence(Long id) {
        return this.seqDAO.getSequence(id);
    }
    public Boolean addSequence(String name) {
        return this.seqDAO.addSequence(name);
    }

    public Boolean deleteSequence(Long id) {
        return this.seqDAO.deleteSequence(id);
    }

}
