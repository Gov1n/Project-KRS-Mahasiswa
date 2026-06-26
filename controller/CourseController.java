/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Course;
import dao.CourseDAO;

/**
 *
 * @author ngura
 */
public class CourseController {
    private CourseDAO courseDAO = new CourseDAO();

    
    public int create(Course course) {
        return courseDAO.create(course);
    }


    public List<Course> getCourse() {
        return courseDAO.getCourse();
    }


    public int update(Course course, String code) {
        return courseDAO.update(course, code);
    }


    public int delete(String code) {
        return courseDAO.delete(code);
    }
}