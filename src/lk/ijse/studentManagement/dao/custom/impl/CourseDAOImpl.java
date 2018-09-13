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
import lk.ijse.studentManagement.dao.custom.CourseDAO;
import lk.ijse.studentManagement.db.DBConnection;
import lk.ijse.studentManagement.entity.Course;
import lk.ijse.studentManagement.entity.Student;

/**
 *
 * @author THARAKA
 */
public class CourseDAOImpl implements CourseDAO{

    @Override
    public boolean save(Course entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO course VALUES (?,?,?)");
        
        Course course = (Course) entity;
        pstm.setObject(1, course.getCid());
        pstm.setObject(2, course.getCname());
        pstm.setObject(3, course.getDuration());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("UPDATE course SET cname=?,duration=? WHERE cid=?");
        
        pstm.setObject(1, entity.getCname());
        pstm.setObject(2, entity.getDuration());
        pstm.setObject(3, entity.getCid());
        
        return pstm.executeUpdate()>0;
    
    
    
    
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
     
    Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM course WHERE cid=?");
        
        pstm.setObject(1, id);
        
        return pstm.executeUpdate() >0;
    
    
    }

    @Override
    public Course find(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    Connection connection = DBConnection.getInstance().getConnection();
        
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM course WHERE cid=?");
        
        pstm.setObject(1,id);
        
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()){
            
            return new Course(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3));
        }else{
            return null;
        }
        
    
    
    }

    @Override
    public ArrayList<Course> getAll() throws Exception {
       /// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
      Connection connection = DBConnection.getInstance().getConnection();
        
        Statement stm = connection.createStatement();
        
        ResultSet rst = stm.executeQuery("SELECT * FROM course");
        
        ArrayList<Course> alCourses = new ArrayList<>();
        
        while(rst.next()){
            
            Course course = new Course(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3));
            
            alCourses.add(course);
            
        }
        
        return alCourses;
        
    
    
    
    
    
    
    }
    
}
