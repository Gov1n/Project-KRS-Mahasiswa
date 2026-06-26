package controller;

import model.KRS; 
import dao.KrsDAO; 

/**
 *
 * @author ngura
 */
public class KrsController {
    private KrsDAO krsDAO = new KrsDAO(); 

    public int create(KRS krs) { 
        return krsDAO.create(krs);
    }
}