/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.bussiness;

import java.util.ArrayList;
import lk.ijse.studentManagement.dao.custom.StudentDAO;
import lk.ijse.studentManagement.dao.custom.impl.StudentDAOImpl;
import lk.ijse.studentManagement.dto.StudentDTO;
import lk.ijse.studentManagement.entity.Student;

/**
 *
 * @author THARAKA
 */
public class StudentBO {
     private static StudentDAO studentDAO = new StudentDAOImpl();
    
    public static boolean saveStudent(StudentDTO dto) throws Exception{
        
        Student student = new Student(dto.getSid(), dto.getSname(), dto.getAddress());
        return studentDAO.save(student);
    }
    
    public static ArrayList<StudentDTO> getAllStudent() throws Exception{
        ArrayList<Student> allStudent = studentDAO.getAll();
        ArrayList<StudentDTO> dtos = new ArrayList<>();
        
//        for (Customer customer : allCustomers) {
//            CustomerDTO customerDTO = new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
//            dtos.add(customerDTO);
//        }
for (Student student : allStudent) {
            StudentDTO studentDTO=new StudentDTO(student.getSid(), student.getSname(),student.getAddress());
            dtos.add(studentDTO);
        }
        
        return dtos;
    }
    
    public static boolean deleteStudent(int Id) throws Exception{
        return studentDAO.delete(Id);
    }
     
}
