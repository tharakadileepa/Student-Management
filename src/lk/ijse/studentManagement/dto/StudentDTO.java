/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.dto;

/**
 *
 * @author THARAKA
 */
public class StudentDTO {
     private int sid;
    private String sname;
    private String address;

    public StudentDTO() {
    }

    public StudentDTO(int sid, String sname, String address) {
        this.sid = sid;
        this.sname = sname;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "sid=" + sid + ", sname=" + sname + ", address=" + address + '}';
    }
    
    
}
