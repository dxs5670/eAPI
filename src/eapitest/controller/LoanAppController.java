package eapitest.controller;

import eapitest.model.LoanApp;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoanAppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField occupationField;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    private RadioButton yesButton;

    @FXML
    private RadioButton noButton;

    @FXML
    private TextField incomeField;
    
    private LoanApp thisApp;

    
    // Declaration of the scene accessed previously
    private Scene previousScene;
    
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    } 
    
    
    
    @FXML
    void createApplication(ActionEvent event) {
        int personalCredit = 0;
        if (thisApp.getUser().getGender().equals("female")){
            personalCredit += 2;
        }
        
        List<String>maritalStatusTemp = thisApp.getMaritalStatus();
        if (maritalStatusTemp.get(0).equals("married")){
            if(Integer.parseInt(maritalStatusTemp.get(1))>0){
                personalCredit+=3;
            }else{
                personalCredit+=2;
            }
        }else{
            personalCredit+=1;
        }
        
        String[]Educations = {"High School","Undergraduate","Graduate","PhD"};
        
        for(int i=0; i < Educations.length; i++){
            if(thisApp.getEducation().equals(Educations[i])){
                personalCredit+=i+1;
            }
        }
        
        if(thisApp.isHousingStatus() == true){
            personalCredit+=2;
        }
        
        thisApp.setPersonalInfoCredit(personalCredit);
        
        
    }


    public void calculateWorkCredit(){
        int workCredit = 0;
        if (thisApp.getUser().getOccupation().equals("Programmer")){
            workCredit += 10;
        } else if (!thisApp.getUser().getOccupation().equals("NONE")){
            workCredit += 2;
        }
        
        workCredit += thisApp.getWorkingYear();
        
        if(thisApp.getAnnualIncome()>=50000){
            workCredit+=5;
        }else if (thisApp.getAnnualIncome()>0){
            workCredit+=2;
        }
        
        thisApp.setWorkInfoCredit(workCredit);
    }
    

    @FXML
    void returnHome(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }

    @FXML
    void setEducationStatus1(ActionEvent event) {

    }

    @FXML
    void setEducationStatus2(ActionEvent event) {

    }

    @FXML
    void setEducationStatus3(ActionEvent event) {

    }

    @FXML
    void setEducationStatus4(ActionEvent event) {

    }

    @FXML
    void setEducationStatus5(ActionEvent event) {

    }

    @FXML
    void setEducationStatus6(ActionEvent event) {

    }

    @FXML
    void setEducationStatus7(ActionEvent event) {

    }

    @FXML
    void setOwnsHomeFalse(ActionEvent event) {

    }

    @FXML
    void setOwnsHomeTrue(ActionEvent event) {

    }

    @FXML
    void setStatusDivorced(ActionEvent event) {

    }

    @FXML
    void setStatusEngaged(ActionEvent event) {

    }

    @FXML
    void setStatusMarried(ActionEvent event) {

    }

    @FXML
    void setStatusSingle(ActionEvent event) {

    }

    @FXML
    void setStatusWidowed(ActionEvent event) {

    }
    
    
    
    
    
    

    @FXML
    void initialize() {
        assert occupationField != null : "fx:id=\"occupationField\" was not injected: check your FXML file 'loanAppView.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
        assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
        assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
        assert incomeField != null : "fx:id=\"incomeField\" was not injected: check your FXML file 'loanAppView.fxml'.";

    }


        

    
    
    
    
}
