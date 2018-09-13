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
import lk.ijse.studentManagement.dao.custom.StudentDAO;
import lk.ijse.studentManagement.db.DBConnection;
import lk.ijse.studentManagement.entity.Student;

/**
 *
 * @author THARAKA
 */
public class StudentDAOImpl implements StudentDAO{

  
   public boolean save(Student entity) throws Exception{
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO student VALUES (?,?,?)");
        
        Student student = (Student) entity;
        pstm.setObject(1, student.getSid());
        pstm.setObject(2, student.getSname());
        pstm.setObject(3, student.getAddress());
        
        return pstm.executeUpdate() > 0;
        
    }

    @Override
    public boolean update(Student entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
       Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("UPDATE student SET sname=?, address=? WHERE sid=?");
        
        pstm.setObject(1, entity.getSname());
        pstm.setObject(2, entity.getAddress());
        pstm.setObject(3, entity.getSid());
        
        return pstm.executeUpdate()>0;
    
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
    Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM student WHERE sid=?");
        
        pstm.setObject(1, id);
        
        return pstm.executeUpdate() >0;
    
    
    
    }

    @Override
    public Student find(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
      Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student WHERE sid=?");
        
        pstm.setObject(1,id);
        
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()){
            
            return new Student(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3));
        }else{
            return null;
        }
        
        
    
    
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
       Connection connection = DBConnection.getInstance().getConnection();
        
        Statement stm = connection.createStatement();
        
        ResultSet rst = stm.executeQuery("SELECT * FROM student");
        
        ArrayList<Student> alStudent = new ArrayList<>();
        
        while(rst.next()){
            
            Student student = new Student(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3));
            
            alStudent.add(student);
            
        }
        
        return alStudent;
        
    
    
    
    
    
    
    }
    
    
}
