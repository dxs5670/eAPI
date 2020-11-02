package eapitest.controller;

import eapitest.model.Account;
import eapitest.model.Loan;
import eapitest.model.LoanApp;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class AccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab editAccountTab;
    
    
    @FXML
    private Button backButton;

    @FXML
    private TextField updateNameField;
    @FXML
    private TextField updateUsernameField;
    @FXML
    private TextField updateOccupationField;    
    @FXML
    private PasswordField updatePasswordField;
    @FXML
    private PasswordField confirmUpdatePasswordField;
    @FXML
    private TextField updateGenderField;

    @FXML
    private Button updateButton;
    
    
    @FXML
    private Tab loanAppsTab;
    
    @FXML
    private TableView<LoanApp> loanAppsTable;
    @FXML
    private TableColumn<LoanApp, String> loanTypeColumn;
    @FXML
    private TableColumn<LoanApp, Long> loanIncomeColumn;
    @FXML
    private TableColumn<LoanApp, String> loanStatusColumn;
    
    
    @FXML
    private Tab loansTab;
    
    
    @FXML
    private Label loanType;
    @FXML
    private Label loanCreatedDate;
    @FXML
    private Label loanPaymentDate;
    @FXML
    private Label loanPaymentMinimum;
    @FXML
    private Label loanTotal;
    @FXML
    private Label loanBalance;
    
    @FXML
    private Button lastLoan;
    
    @FXML
    private TextField loanIndexField;   
    
    @FXML
    private Button nextLoan;
    
    private Account activeUser;
    

    // location & name of stored loan data:
    private static final String LOAN_CSV_FILE = "./loans.csv";
    
    // location & name of stored loanapp data:
    private static final String LOANAPP_CSV_FILE = "./loanapps.csv";
    
    
    private List<Loan> loans = new ArrayList<>();
    private ListIterator<Loan> loanIterator = null;
    
    
    private List<LoanApp> apps = new ArrayList<>();

    private int loanIndex = 0;
    
    // Declaration of the scene accessed previously
    private Scene previousScene;
    
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    } 
    
    
    @FXML
    void returnHome(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }

    @FXML
    void updateAccountDetails(ActionEvent event) {

    }

    public void getLoanApps() throws IOException {
        try (
            // create a reader for the indicated CSV file path
            Reader reader = Files.newBufferedReader(Paths.get(LOANAPP_CSV_FILE));
                
            // creating parser from apache commons csv API
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader() // ignore the header
                    .withIgnoreHeaderCase()
                    .withTrim());
        )  {
            
            // For each record that the parser records, 
            for (CSVRecord csvRecord : csvParser) {
                
                // Accessing values by Header names
                String username = csvRecord.get("userName");
                String loantype = csvRecord.get("loanType");
                int personalInfoCredit = Integer.parseInt(csvRecord.get("personalInfoCredit"));
                String maritalStatus = csvRecord.get("maritalStatus");
                String education = csvRecord.get("education");
                boolean ownsHome = Boolean.parseBoolean(csvRecord.get("ownsHome"));
                int workCredit = Integer.parseInt(csvRecord.get("workCredit"));
                int workYear = Integer.parseInt(csvRecord.get("workYear"));
                long annualIncome = Long.parseLong(csvRecord.get("income"));
                int totalCredit = Integer.parseInt(csvRecord.get("totalCredit"));
                String loanStatus = csvRecord.get("loanStatus");
                
                Account user = new Account(username);
                
                // Create a new LoanApp object with the corresponding csv record
                LoanApp addApp = new LoanApp(user, loantype, personalInfoCredit, maritalStatus, education, ownsHome, workCredit, workYear, annualIncome, totalCredit, loanStatus);
                System.out.println(addApp);
                
                // add the loan app to apps of type List<LoanApp>
                if (addApp.getUser().getUserName().equals(activeUser.getUserName())) apps.add(addApp);
      
            }
        
        // After the loop has executed, call method setTableData to add the data to the TableView
        setTableData(apps);   
        }
    }
    
    public void getLoans() throws IOException {
        try (
            // create a reader for the indicated CSV file path
            Reader reader = Files.newBufferedReader(Paths.get(LOAN_CSV_FILE));
                
            // creating parser from apache commons csv API
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader() // ignore the header
                    .withIgnoreHeaderCase()
                    .withTrim());
        )  {
            
            // For each record that the parser records, 
            for (CSVRecord csvRecord : csvParser) {
                
                // Accessing values by Header names
                String username = csvRecord.get("userName");
                String loantype = csvRecord.get("loanType");
                int personalInfoCredit = Integer.parseInt(csvRecord.get("personalInfoCredit"));
                String maritalStatus = csvRecord.get("maritalStatus");
                String education = csvRecord.get("education");
                boolean ownsHome = Boolean.parseBoolean(csvRecord.get("ownsHome"));
                int workCredit = Integer.parseInt(csvRecord.get("workCredit"));
                int workYear = Integer.parseInt(csvRecord.get("workYear"));
                long annualIncome = Long.parseLong(csvRecord.get("income"));
                int totalCredit = Integer.parseInt(csvRecord.get("totalCredit"));
                String loanStatus = csvRecord.get("loanStatus");
                boolean isAccepted = Boolean.parseBoolean(csvRecord.get("accepted"));
                boolean isDispersed = Boolean.parseBoolean(csvRecord.get("dispersed"));
                float moneyAmount = Float.parseFloat(csvRecord.get("moneyAmount"));
                float approvedAmount = Float.parseFloat(csvRecord.get("approvedAmount"));
                
                
                Account user = new Account(username);
                
                
                // Create a new loan object with the corresponding csv record
                Loan addLoan = new Loan(isAccepted, isDispersed, moneyAmount, approvedAmount, user, loantype, personalInfoCredit, maritalStatus, education, ownsHome, workCredit, workYear, annualIncome, totalCredit, loanStatus);
                System.out.println(addLoan);
                System.out.println(activeUser.getUserName());
                // add the loan to loans of type List<Loan>
                if (addLoan.getUser().getUserName().equals(activeUser.getUserName())) loans.add(addLoan);
                loanIterator = loans.listIterator();
                setLoanPage(loans.get(loanIndex));
      
            }
        

        }
    }
    
    public void setTableData(List<LoanApp> appList) {
        
        ObservableList<LoanApp> loanAppData;
        // initialize the studentData variable
        loanAppData = FXCollections.observableArrayList();

        // add the student objects to an observable list object for use with the GUI table
        appList.forEach(s -> { loanAppData.add(s); });
        
        // set the the table items to the data in studentData; refresh the table
        loanAppsTable.setItems(loanAppData);
        loanAppsTable.refresh();
    }
    
    
    @FXML
    void lastLoan(ActionEvent event) throws InvocationTargetException {
        setLoanPage(loanIterator.previous());
    }

    @FXML
    void nextLoan(ActionEvent event) throws InvocationTargetException {
        setLoanPage(loanIterator.next());
    }
    
    public void setLoanPage(Loan loan) {
        loanType.setText(loan.getLoanType());
        loanTotal.setText("Total: " + loan.getApprovedAmount());
        loanBalance.setText("Balance: " + loan.getMoneyAmount());
        
    }
    
    
    
    //get & set active user

    public Account getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Account activeUser) {
        this.activeUser = activeUser;
    }
    
    
    
    
    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updatePasswordField != null : "fx:id=\"updatePasswordField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updateUsernameField != null : "fx:id=\"updateUsernameField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert confirmUpdatePasswordField != null : "fx:id=\"confirmUpdatePasswordField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updateButton != null : "fx:id=\"updateButton\" was not injected: check your FXML file 'accountView.fxml'.";

        loanTypeColumn.setCellValueFactory(new PropertyValueFactory<>("loanType"));
        loanIncomeColumn.setCellValueFactory(new PropertyValueFactory<>("annualIncome"));
        loanStatusColumn.setCellValueFactory(new PropertyValueFactory<>("loanStatus"));
        
        // Try to get the student data from file when the application is loaded
        
        
    }
}
