package org.example.seqfx.controller;

import org.example.seqfx.dao.ViewDAO;

public class ViewController {

    public final ViewDAO viewDAO = new ViewDAO();

    public Boolean createView(String name, Long seqId) {return this.viewDAO.createView(name, seqId);}
}
