package controller;

import java.util.List;
import model.Course;
import dao.CourseDAO;

public class CourseController {
    private CourseDAO courseDAO = new CourseDAO();

    public int create(Course course) {
        
        course.setCourseName(course.getCourseName().trim().toUpperCase());
        
       
        if (course.getSKS() <= 0) {
            System.err.println("ol atau negatif!");
            return 0; 
        }
        
        
        if (course.getCode() == null || course.getCode().isEmpty()) {
            return 0;
        }

        return courseDAO.create(course);
    }

    public List<Course> getCourse() {
        return courseDAO.getCourse();
    }

    public int update(Course course, String code) {
       
        course.setCourseName(course.getCourseName().trim().toUpperCase());
        
        return courseDAO.update(course, code);
    }

    public int delete(String code) {
        
        if (code == null || code.isEmpty()) {
            return 0;
        }
        return courseDAO.delete(code);
    }
}