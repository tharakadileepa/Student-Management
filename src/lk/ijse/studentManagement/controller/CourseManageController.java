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
import lk.ijse.studentManagement.dto.CourseDTO;
import lk.ijse.studentManagement.dto.StudentDTO;
import lk.ijse.studentManagement.main.StartUp;
import lk.ijse.studentManagement.view.util.tblmodel.CourseTM;

/**
 *
 * @author THARAKA
 */
public class CourseManageController implements Initializable{

    @FXML
    private JFXTextField txtid;
    @FXML
    private JFXTextField txtname;
    @FXML
    private JFXTextField txtduratiion;
    @FXML
    private TableView<CourseTM> tableCourse;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnCancel;
    
    private void save(){
        try {
            int id= Integer.parseInt(txtid.getText());
            String name = txtname.getText();
            String duration = txtduratiion.getText();
            
            
            CourseDTO courseDTO=new CourseDTO(id, name,duration);
            boolean rst=CourseBO.saveCourse(courseDTO);
            if(rst){
                loadAllCourse();
                Alert b=new Alert(Alert.AlertType.INFORMATION);
                b.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(CourseManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     private void loadAllCourse(){
        try {
            ArrayList<CourseDTO> allCourse = CourseBO.getAllCourse();
            
            ObservableList<CourseTM> olCourse = tableCourse.getItems();
            olCourse.removeAll(olCourse);
            
            for (CourseDTO course : allCourse) {
                CourseTM courseTM = new CourseTM(course.getCid(), course.getCname(), course.getDuration());
                olCourse.add(courseTM);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CourseManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
     
     private void delete(){
            
        int courseID = tableCourse.getSelectionModel().getSelectedItem().getCid();
        
        try {
            boolean result = CourseBO.deleteCourse(courseID);
            
            if (result){
                new Alert(Alert.AlertType.CONFIRMATION, "Coures has been deleted successfully", ButtonType.OK).show();
                loadAllCourse();
            }else{
                new Alert(Alert.AlertType.ERROR, "Failed to delete the customer", ButtonType.OK).show();
            }            
        } catch (Exception ex) {
            Logger.getLogger(CourseManageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
     
     
    @FXML
    private void btnAddCu(ActionEvent event) {
        save();
    }

    @FXML
    private void btnDeleteCu(ActionEvent event) {
        delete();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    tableCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
       tableCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cname"));
        tableCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        
    loadAllCourse();
    
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void btnCancel_onclick(ActionEvent event) {
        txtid.setText("");
        txtname.setText("");
        txtduratiion.setText("");
    }
    
}
