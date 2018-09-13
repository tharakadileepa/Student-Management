/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.view.util.tblmodel;

import java.util.Date;

/**
 *
 * @author THARAKA
 */
public class RegisrerTM {
    private int sid;
    private int cid;
    private int fee;
    private Date regdate;
    
    
    

    public RegisrerTM(int sid, int cid, int fee, Date regdate) {
        this.sid = sid;
        this.cid = cid;
        this.fee = fee;
        this.regdate = regdate;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

 






}
