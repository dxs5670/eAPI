package eapitest.controller;

import eapitest.model.Account;
import eapitest.model.LoanApp;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class LoanAppController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
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
    @FXML
    private MenuButton loanTypeMenu;
    @FXML
    private MenuButton maritalStatusMenu;
    @FXML
    private MenuButton educationMenu;
    @FXML
    private TextField workingYearField;
    
    private Account activeUser;
    
    // location & name of stored loanapp data:
    private static final String LOANAPP_CSV_FILE = "./loanapps.csv";
    
    private List<LoanApp> loanAppList = new ArrayList<>();
    
    
    // the currently created LoanApp
    private LoanApp thisApp = new LoanApp();

    
    // Declaration of the scene accessed previously
    private Scene previousScene;
    
    
    // Used for setting the previous scene to be used with the back button
    public void setPreviousScene(Scene scene) { 
        
        previousScene = scene;
        backButton.setDisable(false);
        
    } 
    
    
    // Used for writing a list of loan applications to a .csv file in the project directory
    private void writeToCSV(List<LoanApp> appList) throws IOException {
        try ( 
            // create a writer for the indicated CSV file path
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(LOANAPP_CSV_FILE));

            // creating printer from apache commons csv API
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("userName", "loanType", "personalInfoCredit", "maritalStatus", "education", "ownsHome", "workCredit", "workYear", "income", "totalCredit", "loanStatus")); // include the header
        ) {
            // for each loan app in the student list,
            for (LoanApp app: loanAppList) {
                // print the csv record to a file with the corresponding name, id, and gpa
                csvPrinter.printRecord(app.getUser().getUserName(), app.getLoanType(), app.getPersonalInfoCredit(), app.getMaritalStatus(), app.getEducation(), app.isHousingStatus(), app.getWorkInfoCredit(), app.getWorkingYear(), app.getAnnualIncome(), app.getTotalCredit(), app.getLoanStatus());
            }

            // send the changes and close the printer
            csvPrinter.flush();            
        }
    }
    
    
    // set the personal credit attribute of thisApp
    @FXML
    void createApplication(ActionEvent event) throws IOException {
        
        int personalCredit = 0;
        
        calculateWorkCredit();
        
        //if (thisApp.getUser().getGender().equals("female")) personalCredit += 2;
          
        if(thisApp.isHousingStatus() == true) personalCredit+=2;
        
        if (thisApp.getMaritalStatus().equals("married")) personalCredit += 2;
        
        thisApp.setPersonalInfoCredit(personalCredit);
        
        thisApp.setAnnualIncome(Long.parseLong(incomeField.getText()));  
        
        thisApp.setUser(activeUser);
        
        thisApp.setWorkingYear(Integer.parseInt(workingYearField.getText()));
        
        thisApp.setTotalCredit(personalCredit + thisApp.getWorkInfoCredit());
        
        thisApp.setLoanStatus("Pending");
        
        loanAppList.add(thisApp);
                
        writeToCSV(loanAppList);
    }

    // calculate the work credit 
    public void calculateWorkCredit(){
        int workCredit = 0;
        
        /*
        if (activeUser.getOccupation().equals("Programmer")){
            workCredit += 10;
        } else if (!thisApp.getUser().getOccupation().isEmpty()){
            workCredit += 2;
        }
        */
        
        workCredit += thisApp.getWorkingYear();
        
        if(thisApp.getAnnualIncome()>=50000){
            workCredit+=5;
        }else if (thisApp.getAnnualIncome()>0){
            workCredit+=2;
        }
        
        thisApp.setWorkInfoCredit(workCredit);
    }
    
    // Return to the previous scene when the back button is clicked
    @FXML
    void returnHome(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }
    
    
    @FXML
    void setLoanAuto(ActionEvent event) {
       loanTypeMenu.setText("Auto");
       thisApp.setLoanType("Auto");
    }

    @FXML
    void setLoanBusiness(ActionEvent event) {
       loanTypeMenu.setText("Business");
       thisApp.setLoanType("Business");
    }

    @FXML
    void setLoanPersonal(ActionEvent event) {
       loanTypeMenu.setText("Personal");
       thisApp.setLoanType("Personal");
    }

    @FXML
    void setLoanProject(ActionEvent event) {
       loanTypeMenu.setText("Project");
       thisApp.setLoanType("Project");
    }

    @FXML
    void setLoanRenovation(ActionEvent event) {
       loanTypeMenu.setText("Renovation");
       thisApp.setLoanType("Renovation");
    }
    
    
    // Menu Item "Some High School"
    @FXML
    void setEducationStatus1(ActionEvent event) {
        educationMenu.setText("Some High School");
        thisApp.setEducation("Some High School");
    }

    
    // Menu Item "GED or HS Dimploma"
    @FXML
    void setEducationStatus2(ActionEvent event) {
        educationMenu.setText("GED or HS Dimploma");
        thisApp.setEducation("GED or HS Dimploma");
    }

    
    // Menu Item "Some College"
    @FXML
    void setEducationStatus3(ActionEvent event) {
        educationMenu.setText("Some College");
        thisApp.setEducation("Some College");
    }

    
    // Menu Item "Associate's Degree"
    @FXML
    void setEducationStatus4(ActionEvent event) {
        educationMenu.setText("Associate's Degree");
        thisApp.setEducation("Associate's Degree");
    }

    
    // // Menu Item "Bachelor's Degree"
    @FXML
    void setEducationStatus5(ActionEvent event) {
        educationMenu.setText("Bachelor's Degree");
        thisApp.setEducation("Bachelor's Degree");
    }

    
    // Menu Item "Master's Degree"
    @FXML
    void setEducationStatus6(ActionEvent event) {
        educationMenu.setText("Master's Degree");
        thisApp.setEducation("Master's Degree");
    }

    
    // Menu Item "Doctorate"
    @FXML
    void setEducationStatus7(ActionEvent event) {
        educationMenu.setText("Doctorate");
        thisApp.setEducation("Doctorate");
    }

    
    @FXML
    void setOwnsHomeFalse(ActionEvent event) {
        yesButton.setSelected(false);
        noButton.setSelected(true);
        thisApp.setHousingStatus(false);
    }

    
    @FXML
    void setOwnsHomeTrue(ActionEvent event) {
        noButton.setSelected(false);
        yesButton.setSelected(true);
        thisApp.setHousingStatus(true);
    }

  
    @FXML
    void setStatusDivorced(ActionEvent event) {
        maritalStatusMenu.setText("Divorced");
        thisApp.setMaritalStatus("Divorced");
    }

    
    @FXML
    void setStatusEngaged(ActionEvent event) {
        maritalStatusMenu.setText("Engaged");
        thisApp.setMaritalStatus("Engaged");
    }

    
    @FXML
    void setStatusMarried(ActionEvent event) {
        maritalStatusMenu.setText("Married");
        thisApp.setMaritalStatus("Married");
    }

    
    @FXML
    void setStatusSingle(ActionEvent event) {
        maritalStatusMenu.setText("Single"); 
        thisApp.setMaritalStatus("Single");
    }

    
    @FXML
    void setStatusWidowed(ActionEvent event) {
        maritalStatusMenu.setText("Widowed");
        thisApp.setMaritalStatus("Widowed");
    }

    public LoanApp getThisApp() {
        return thisApp;
    }
    
    
    public Account getActiveUser() {
        return activeUser;

    }

    // get & set active user
    public void setActiveUser(Account activeUser) {
        this.activeUser = activeUser;
    }

    @FXML
            void initialize() {
                assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert loanTypeMenu != null : "fx:id=\"loanTypeMenu\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert maritalStatusMenu != null : "fx:id=\"maritalStatusMenu\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert educationMenu != null : "fx:id=\"educationMenu\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert incomeField != null : "fx:id=\"incomeField\" was not injected: check your FXML file 'loanAppView.fxml'.";
                assert workingYearField != null : "fx:id=\"workingYearField\" was not injected: check your FXML file 'loanAppView.fxml'.";
    }
}
