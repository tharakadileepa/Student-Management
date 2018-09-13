/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.entity;

import java.util.Date;

/**
 *
 * @author THARAKA
 */
public class Registration {
    private Registration_PK registration_PK;
    private int fee;
     private Date regdate;
    public Registration() {
    }

    public Registration(Registration_PK registration_PK,int fee,Date regdate) {
        this.registration_PK = registration_PK;
        this.fee = fee;
        this.regdate = regdate;
    }
    
    public Registration(int sid,int cid, int fee ,Date regdate) {
        this.registration_PK = new Registration_PK(sid, cid);
        this.fee = fee;
        this.regdate = regdate;
    }

    public Registration_PK getRegistration_PK() {
        return registration_PK;
    }

    public void setRegistration_PK(Registration_PK registration_PK) {
        this.registration_PK = registration_PK;
    }

    

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    
    /**
     * @return the regdate
     */
    public Date getRegdate() {
        return regdate;
    }

    /**
     * @param regdate the regdate to set
     */
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    
    @Override
    public String toString() {
        return "Registration{" + "registration_PK=" + getRegistration_PK() + ", fee=" + getFee() + ", regdate=" + getRegdate() + '}';
    }

    
    
    
    
}
