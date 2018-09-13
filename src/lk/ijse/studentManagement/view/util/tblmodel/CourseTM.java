/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.view.util.tblmodel;

/**
 *
 * @author THARAKA
 */
public class CourseTM {
    private int cid;
    private String cname;
    private String duration;

    public CourseTM(int cid, String cname, String duration) {
        this.cid = cid;
        this.cname = cname;
        this.duration = duration;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
    
}
