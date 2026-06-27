package model;

public class KRS {
    private Course course; 
    private String code;
    private String nim;
    private String nidn;
    private int semester;
    private double score;
    private String grade;
    
 
    private int sikap, uts, uas;

  
    public KRS() {}

    public KRS(String code, String nim, String nidn, int semester, double score, String grade) {
        this.code = code;
        this.nim = nim;
        this.nidn = nidn;
        this.semester = semester;
        this.score = score;
        this.grade = grade;
    }

    public KRS(Course selecttedCourse, double rataRata) {
        this.course = selecttedCourse;
        this.score = rataRata;
        this.grade = hitungGradeOtomatis(rataRata); 
    }

    private String hitungGradeOtomatis(double score) {
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        if (score >= 50) return "D";
        return "E";
    }

   
    public String getCode() { 
        return (course != null) ? course.getCode() : code; 
    }
    
    public String getNim() { 
        return nim; 
    }
    
    public String getNidn() { 
        return nidn; 
    }
    
    public int getSemester() { 
        return semester; 
    }
    
    public double getScore() { 
        return score; 
    }
    
    public String getGrade() { 
        return grade; 
    }
    
    public Course getCourse() { 
        return course; 
    }
    

    public void setNim(String nim) { 
        this.nim = nim;
    }
    
    public void setNidn(String nidn) { 
        this.nidn = nidn;
    }
    
    public void setSemester(int sem) { 
        this.semester = sem;
    }
    
    public void setGrade(String grade) {
        this.grade = grade; 
    }
    

    
    public int getSikap() { 
        return sikap; 
    }
    
    public void setSikap(int sikap) { 
        this.sikap = sikap;
    }
    

    public int getUts() {
        return uts; 
    }
    
    public void setUts(int uts) {
        this.uts = uts;
    }
    

    public int getUas() { 
        return uas; 
    }
    
    public void setUas(int uas) { 
        this.uas = uas;
    }
    
}