/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.studentManagement.bussiness.RegisterBO;
import lk.ijse.studentManagement.bussiness.StudentBO;
import lk.ijse.studentManagement.db.DBConnection;
import lk.ijse.studentManagement.dto.RegisterDTO;
import lk.ijse.studentManagement.dto.StudentDTO;
import lk.ijse.studentManagement.main.StartUp;
import lk.ijse.studentManagement.view.util.tblmodel.RegisrerTM;
import lk.ijse.studentManagement.view.util.tblmodel.StudentTM;

/**
 *
 * @author THARAKA
 */
public class RegisterController implements Initializable{

    
    @FXML
    private TableView<RegisrerTM> tableRegi;
    @FXML
    private JFXComboBox<String> combocourse;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXComboBox<String> comboName;
    @FXML
    private JFXDatePicker DateRegDate;
    @FXML
    private JFXTextField txtFee;
    
    public void loadAllCourse(){
        
            Connection con;
        try {
            con = DBConnection.getInstance().getConnection();
        
           String sql="select cid from course";
            PreparedStatement ptst=con.prepareStatement(sql);
            ResultSet rst = ptst.executeQuery();
            ArrayList<String> arrayList=new ArrayList<>();
            while (rst.next()) {                
             arrayList.add(String.valueOf(rst.getInt(1)));
             
            }
            ObservableList<String> arr=FXCollections.observableArrayList(arrayList);
            combocourse.setItems(arr);
            
            
          } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }  
            
            
       
    }
    
    private void loadAllRegi(){
        
        try {
            ArrayList<RegisterDTO> allregi = RegisterBO.getAllRegi();
            
            ObservableList<RegisrerTM> olRegi = tableRegi.getItems();
            olRegi.removeAll(olRegi);
            
            for (RegisterDTO regi : allregi) {
                RegisrerTM rgiTM = new RegisrerTM(regi.getSid(),regi.getCid(),regi.getFee(),regi.getRegdate());
                olRegi.add(rgiTM);
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

    public void add(){
        try {
            int name = Integer.parseInt(comboName.getValue());
            int course=Integer.parseInt(combocourse.getValue());
            int fee = Integer.parseInt(txtFee.getText());
            LocalDate localDate = DateRegDate.getValue();
                Date date = new Date();
                date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
            
            
            RegisterDTO regiDTO=new RegisterDTO(name,course,fee,date);
            
            boolean rst=RegisterBO.saveRegi(regiDTO);
            if(rst){
                 
                Alert b=new Alert(Alert.AlertType.CONFIRMATION,"Registered Successfully",ButtonType.OK);
                b.show();
            }
//            else{
//                Alert c=new Alert(Alert.AlertType.CONFIRMATION,"Try Again..",ButtonType.OK);
//                c.show();
//            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRegister(ActionEvent event) {
        add();
        loadAllRegi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   loadAllCourse();
   loadAllRegi();
   LoadAllStudentName();
    tableRegi.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
       tableRegi.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tableRegi.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fee"));
        tableRegi.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("regdate"));
    
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    private void LoadAllStudentName() {
           Connection con;
        try {
            con = DBConnection.getInstance().getConnection();
        
           String sql="select sid from student";
            PreparedStatement ptst=con.prepareStatement(sql);
            ResultSet rst = ptst.executeQuery();
            ArrayList<String> arrayList=new ArrayList<>();
            while (rst.next()) {                
             arrayList.add(String.valueOf(rst.getInt(1)));
             
            }
            ObservableList<String> arr=FXCollections.observableArrayList(arrayList);
            comboName.setItems(arr);
            
            
          } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
}
