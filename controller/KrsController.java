package controller;

import model.KRS; 
import dao.KrsDAO; 

public class KrsController {
    private KrsDAO krsDAO = new KrsDAO(); 

    public int create(KRS krs) { 
    
        
       
        if (krs.getSikap() < 0 || krs.getSikap() > 100 ||
            krs.getUts() < 0 || krs.getUts() > 100 ||
            krs.getUas() < 0 || krs.getUas() > 100) {
            System.err.println("Error: Nilai harus berada dalam rentang 0-100!");
            return 0; 
        }
        
      
        double rataRata = (krs.getSikap() + krs.getUts() + krs.getUas()) / 3.0;
        krs.setGrade(hitungGrade(rataRata));
        
       
        return krsDAO.create(krs);
    }
    
   
    private String hitungGrade(double rataRata) {
        if (rataRata >= 85) return "A";
        if (rataRata >= 75) return "B";
        if (rataRata >= 65) return "C";
        if (rataRata >= 50) return "D";
        return "E";
    }
}