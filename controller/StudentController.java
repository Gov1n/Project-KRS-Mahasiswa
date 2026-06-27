package controller;

import java.util.List;
import model.Student;
import dao.StudentDAO;

public class StudentController {
    private StudentDAO studentDAO = new StudentDAO();

    public int create(Student student) {
        
        
      
        student.setName(student.getName().trim().toUpperCase());
        student.setNim(student.getNim().trim());
        
       
        if (student.getNim().isEmpty()) {
            System.err.println("Error: NIM tidak boleh kosong!");
            return 0;
        }
        
        
        if (student.getName().isEmpty()) {
            System.err.println("Error: Nama Mahasiswa tidak boleh kosong!");
            return 0;
        }

        return studentDAO.create(student);
    }

    public List<Student> getStudent() {
        return studentDAO.getStudent();
    }

    public int update(Student student, String nim) {
        
        if (nim == null || nim.isEmpty()) return 0;
        
        student.setName(student.getName().trim().toUpperCase());
        return studentDAO.update(student, nim);
    }

    public int delete(String nim) {
        if (nim == null || nim.isEmpty()) return 0;
        return studentDAO.delete(nim);
    }
}