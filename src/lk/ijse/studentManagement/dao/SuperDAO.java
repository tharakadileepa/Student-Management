/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.dao;

import java.util.ArrayList;

/**
 *
 * @author THARAKA
 */
public interface SuperDAO<T, ID> {
    
    public boolean save(T entity) throws Exception;
    
    public boolean update(T entity) throws Exception;
    
    public boolean delete(ID id) throws Exception;
    
    public T find(ID id) throws Exception;
    
    public ArrayList<T> getAll() throws Exception;
    
}
