package controller;

import java.util.List;
import model.Lecturer;
import dao.LecturerDAO;

public class LecturerController {
    private LecturerDAO lecturerDAO = new LecturerDAO();

    public int create(Lecturer lecturer) {
        
        lecturer.setName(lecturer.getName().trim().toUpperCase());
        lecturer.setNidn(lecturer.getNidn().trim());
        
       
        if (lecturer.getNidn().isEmpty()) {
            System.err.println("Error: NIDN wajib diisi!");
            return 0;
        }
        

        if (lecturer.getExpertise() == null || lecturer.getExpertise().isEmpty()) {
            lecturer.setExpertise("UMUM"); 
        }

        return lecturerDAO.create(lecturer);
    }

    public List<Lecturer> getLecturer() {
        return lecturerDAO.getLecturer();
    }

    public int update(Lecturer lecturer, String nidn) {
       
        lecturer.setName(lecturer.getName().trim().toUpperCase());
        
        if (nidn == null || nidn.isEmpty()) return 0;
        
        return lecturerDAO.update(lecturer, nidn);
    }

    public int delete(String nidn) {
        if (nidn == null || nidn.isEmpty()) return 0;
        return lecturerDAO.delete(nidn);
    }
}