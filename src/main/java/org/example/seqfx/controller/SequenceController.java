package org.example.seqfx.controller;

import org.example.seqfx.dao.SequenceDAO;
import org.example.seqfx.model.Sequence;

import java.util.List;

public class SequenceController {

    public final SequenceDAO seqDAO;

    public SequenceController() {
        this.seqDAO = new SequenceDAO();
    }


    public Sequence getSequence(Long id) {
        return this.seqDAO.getSequence(id);
    }

    public List<Sequence> getAllSequences() {
        return this.seqDAO.getAllSequences();
    }

    public Boolean addSequence(String name) {
        return this.seqDAO.addSequence(name);
    }

    public Boolean deleteSequence(Long id) {
        return this.seqDAO.deleteSequence(id);
    }

}
