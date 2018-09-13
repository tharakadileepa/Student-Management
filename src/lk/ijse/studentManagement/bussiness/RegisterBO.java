/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.bussiness;

import java.util.ArrayList;
import lk.ijse.studentManagement.dao.custom.CourseDAO;
import lk.ijse.studentManagement.dao.custom.RegistrationDAO;
import lk.ijse.studentManagement.dao.custom.impl.CourseDAOImpl;
import lk.ijse.studentManagement.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.studentManagement.dto.CourseDTO;
import lk.ijse.studentManagement.dto.RegisterDTO;
import lk.ijse.studentManagement.entity.Course;
import lk.ijse.studentManagement.entity.Registration;

import lk.ijse.studentManagement.entity.Registration_PK;

/**
 *
 * @author THARAKA
 */
public class RegisterBO {
     private static RegistrationDAO regiDAO = new RegistrationDAOImpl();
    
    public static boolean saveRegi(RegisterDTO dto) throws Exception{
        
        Registration registration = new Registration(dto.getSid(),dto.getCid(),dto.getFee(),dto.getRegdate());
        return regiDAO.save(registration);
    }
    
    public static ArrayList<RegisterDTO> getAllRegi() throws Exception{
        ArrayList<Registration> allRegi = regiDAO.getAll();
        ArrayList<RegisterDTO> dtos = new ArrayList<>();
        
        
for (Registration regi : allRegi) {
            RegisterDTO regiDTO=new RegisterDTO(regi.getRegistration_PK().getSid(),regi.getRegistration_PK().getCid(),regi.getFee(),regi.getRegdate());
            dtos.add(regiDTO);
            
        }
        
        return dtos;
    }
    
    public static boolean deleteCourse(Registration_PK Id) throws Exception{
        return regiDAO.delete(Id);
    }
}
