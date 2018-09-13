/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.bussiness;

import java.util.ArrayList;
import lk.ijse.studentManagement.dao.custom.CourseDAO;
import lk.ijse.studentManagement.dao.custom.StudentDAO;
import lk.ijse.studentManagement.dao.custom.impl.CourseDAOImpl;
import lk.ijse.studentManagement.dao.custom.impl.StudentDAOImpl;
import lk.ijse.studentManagement.dto.CourseDTO;
import lk.ijse.studentManagement.dto.StudentDTO;
import lk.ijse.studentManagement.entity.Course;
import lk.ijse.studentManagement.entity.Student;

/**
 *
 * @author THARAKA
 */
public class CourseBO {
    private static CourseDAO courseDAO = new CourseDAOImpl();
    
    public static boolean saveCourse(CourseDTO dto) throws Exception{
        
        Course course = new Course(dto.getCid(), dto.getCname(), dto.getDuration());
        return courseDAO.save(course);
    }
    
    public static ArrayList<CourseDTO> getAllCourse() throws Exception{
        ArrayList<Course> allCourse = courseDAO.getAll();
        ArrayList<CourseDTO> dtos = new ArrayList<>();
        
//        for (Customer customer : allCustomers) {
//            CustomerDTO customerDTO = new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
//            dtos.add(customerDTO);
//        }
for (Course course : allCourse) {
            CourseDTO courseDTO=new CourseDTO(course.getCid(),course.getCname(),course.getDuration());
            dtos.add(courseDTO);
        }
        
        return dtos;
    }
    
    public static boolean deleteCourse(int Id) throws Exception{
        return courseDAO.delete(Id);
    }
      
}
