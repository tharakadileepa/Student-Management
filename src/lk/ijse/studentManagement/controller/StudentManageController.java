/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.studentManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import lk.ijse.studentManagement.bussiness.CourseBO;
import lk.ijse.studentManagement.bussiness.StudentBO;
import lk.ijse.studentManagement.dto.CourseDTO;
import lk.ijse.studentManagement.dto.StudentDTO;
import lk.ijse.studentManagement.main.StartUp;
import lk.ijse.studentManagement.view.util.tblmodel.CourseTM;
import lk.ijse.studentManagement.view.util.tblmodel.StudentTM;

/**
 *
 * @author THARAKA
 */
public class StudentManageController implements Initializable{

    @FXML
    private JFXTextField txtid;
    @FXML
    private JFXTextField txtname;
    @FXML
    private JFXTextField txtaddress;
    @FXML
    private TableView<StudentTM> tableStudent;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnCancel;
    
    private void save(){
        try {
            int id= Integer.parseInt(txtid.getText());
            String name = txtname.getText();
            String address = txtaddress.getText();
            
            
            StudentDTO stuDTO=new StudentDTO(id, name,address);
            boolean rst=StudentBO.saveStudent(stuDTO);
            if(rst){
                loadAllStudent();
                Alert b=new Alert(Alert.AlertType.CONFIRMATION,"Added Successfully",ButtonType.OK);
                b.show();
               
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     private void loadAllStudent(){
        try {
            ArrayList<StudentDTO> allStu = StudentBO.getAllStudent();
            
            ObservableList<StudentTM> olStu = tableStudent.getItems();
            olStu.removeAll(olStu);
            
            for (StudentDTO stu : allStu) {
                StudentTM stuTM = new StudentTM(stu.getSid(), stu.getSname(), stu.getAddress());
                olStu.add(stuTM);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(StudentManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
     
     private void delete(){
            
        int stuID = tableStudent.getSelectionModel().getSelectedItem().getSid();
        
        try {
            boolean result = StudentBO.deleteStudent(stuID);
            
            if (result){
                new Alert(Alert.AlertType.CONFIRMATION, "Student has been deleted successfully", ButtonType.OK).show();
                loadAllStudent();
            }else{
                new Alert(Alert.AlertType.ERROR, "Failed to delete the customer", ButtonType.OK).show();
            }            
        } catch (Exception ex) {
            Logger.getLogger(CourseManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }

    @FXML
    private void btnAddStu(ActionEvent event) {
        save();
    }

    @FXML
    private void btnDeleteStu(ActionEvent event) {
        delete();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
     tableStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
       tableStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("sname"));
        tableStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        
    loadAllStudent();
    
    
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void btnCancel_onclick(ActionEvent event) {
        txtid.setText("");
        txtname.setText("");
        txtaddress.setText("");
    }
    
}
