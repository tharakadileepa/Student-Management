/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.studentManagement.dao.custom.RegistrationDAO;
import lk.ijse.studentManagement.db.DBConnection;
import lk.ijse.studentManagement.entity.Course;
import lk.ijse.studentManagement.entity.Registration;
import lk.ijse.studentManagement.entity.Registration_PK;

/**
 *
 * @author THARAKA
 */
public class RegistrationDAOImpl implements RegistrationDAO{

    @Override
    public boolean save(Registration entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO scregistration VALUES (?,?,?,?)");
        
        Registration registration = (Registration) entity;
        pstm.setObject(1, registration.getRegistration_PK().getSid());
        pstm.setObject(2,registration.getRegistration_PK().getCid());
        pstm.setObject(3,registration.getFee());
        pstm.setObject(4,registration.getRegdate());
        
        return pstm.executeUpdate() > 0;
    
    
    
    
    
    
    }

    @Override
    public boolean update(Registration entity) throws Exception {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("UPDATE scregistration SET cid=?,fee=?,rdate=?, WHERE sid=?");
        
        pstm.setObject(1, entity.getRegistration_PK().getCid());
        pstm.setObject(2, entity.getFee());
        pstm.setObject(3, entity.getRegdate());
         pstm.setObject(4, entity.getRegistration_PK().getSid());
        
        return pstm.executeUpdate()>0;
    
    
    }

    @Override
    public boolean delete(Registration_PK id) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
     Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM scregistration WHERE cid=?");
        
        pstm.setObject(1, id);
        
        return pstm.executeUpdate() >0;
    
    
    
    }

    @Override
    public Registration find(Registration_PK id) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM scregistration WHERE cid=?");
        
        pstm.setObject(1,id);
        
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()){
            
            return new Registration(rst.getInt(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getDate(4));
        }else{
            return null;
        }
        
    
    
    
    
    
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
      
      Connection connection = DBConnection.getInstance().getConnection();
        
        Statement stm = connection.createStatement();
        
        ResultSet rst = stm.executeQuery("SELECT * FROM scregistration");
        
        ArrayList<Registration> alRegistrations = new ArrayList<>();
        
        while(rst.next()){
            
            Registration registration = new Registration(rst.getInt(1),
                    rst.getInt(2),
                    rst.getInt(3),
                    rst.getDate(4)
            );
            
            alRegistrations.add(registration);
            
        }
        
        return alRegistrations;
        
    
    
    }
    
}
