/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.entity;

/**
 *
 * @author THARAKA
 */
public class Registration_PK {
    private int sid;
    private int cid;

    public Registration_PK() {
    }

    public Registration_PK(int sid, int cid) {
        this.sid = sid;
        this.cid = cid;
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
    
    
}
