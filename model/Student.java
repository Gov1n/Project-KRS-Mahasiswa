/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ngura
 */

import model.Person;
import model.KRS;
import java.util.ArrayList;

public class Student extends Person { 
    private String nim; 
    private String studyProgram; 
    private ArrayList<KRS> krsList; 

    public Student(String idCard, String name, String nim, String studyProgram) { 
        super(idCard, name); 
        this.nim = nim; 
        this.studyProgram = studyProgram; 
        krsList = new ArrayList<>(); 
    }

    @Override
    public String toString() { 
        return this.name; 
    }

    public String getNim() { 
        return nim; 
    }

    public String getName() { 
        return name; 
    }

    public String getStudyProgram() { 
        return studyProgram; 
    }

    public void addKRS(KRS krs) { 
        krsList.add(krs); 
    }

    public String getCardID() {
        
        return idCard;
    }

    public void setName(String toUpperCase) {
        this.name = name;
    }

    public void setNim(String trim) {
        this.nim = nim;
   }
    
    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }
    
    
    
    public void setCardID(String cardID) {
        
        super.setCardID(cardID); 
    }
    
}
