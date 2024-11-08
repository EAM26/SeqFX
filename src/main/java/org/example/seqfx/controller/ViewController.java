package org.example.seqfx.controller;

import org.example.seqfx.dao.ViewDAO;
import org.example.seqfx.model.View;

import java.util.List;

public class ViewController {

    public final SequenceController sequenceController = new SequenceController();
    public final ViewDAO viewDAO = new ViewDAO(sequenceController);

    public Boolean createView(String name, Long seqId) {return this.viewDAO.createView(name, seqId);}

    public View getView(Long id) {return this.viewDAO.getView(id);}
    public List<View> getAllViews() {return this.viewDAO.getAllViews();}
}
