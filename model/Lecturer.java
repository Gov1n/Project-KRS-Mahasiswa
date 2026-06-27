package model;

/**
 *
 * @author ngura
 */
public class Lecturer extends Person { 
    private String nidn; 
    private String expertise; 

    public Lecturer(String idCard, String name, String nidn, String expertise) { 
        super(idCard, name); 
        this.nidn = nidn; 
        this.expertise = expertise; 
    }
    
    @Override
    public String toString() {
        return this.name; 
    }

    public String getName() {
        return this.name; 
    }

    public String getCardID() {
        return super.getCardID(); 
    }

    public String getNidn() {
        return this.nidn; 
    }

    public String getExpertise() {
        return this.expertise; 
    }

    public void setName(String toUpperCase) {
        this.name = name;
    }

    public void setNidn(String trim) {
        this.nidn = nidn;
    }

    public void setExpertise(String umum) {
        this.expertise = expertise;
    }
    
    public void setCardID(String idCard) {
        
        super.setCardID(idCard);
        
    }
    
}