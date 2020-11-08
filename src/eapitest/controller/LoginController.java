package eapitest.controller;

import eapitest.model.Account;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

// commons csv API import statements
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;




public class LoginController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField usernameFieldExisting;
    @FXML
    private PasswordField passwordFieldExisting;
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameFieldRegister;
    @FXML
    private TextField nameField;
    @FXML
    private TextField occupationField;
    @FXML
    private PasswordField passwordFieldRegister;
    @FXML
    private RadioButton maleButton;
    @FXML
    private RadioButton femaleButton;
    @FXML
    private TextField specifyGenderField;
    @FXML
    private Button registerButton;
    @FXML
    private TitledPane loginPane;  
    @FXML
    private TitledPane registerPane;
    @FXML
    private Accordion window;   
    
    
    // location & name of stored account data:
    private static final String ACCOUNT_CSV_FILE = "./accounts.csv";
    
    // list of account objects
    private List<Account> accountList;
    
    
    // Used for writing a list of students to a .csv file in the project directory
    private void writeToCSV(List<Account> accountList) throws IOException {
        try ( 
            // create a writer for the indicated CSV file path
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(ACCOUNT_CSV_FILE));

            // creating printer from apache commons csv API
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("userName", "password", "name", "gender", "occupation")); // include the header
        ) {
            // for each student in the student list,
            for (Account user: accountList) {
                // print the csv record to a file with the corresponding name, id, and gpa
                csvPrinter.printRecord(user.getUserName(), user.getPassword(), user.getName(), user.getGender(), user.getOccupation());
            }

            // send the changes and close the printer
            csvPrinter.flush();            
        }
    }
    
    
    public List<Account> getUsers() throws IOException {
        
        accountList = new ArrayList<>();
        
        try (
            // create a reader for the indicated CSV file path
            Reader reader = Files.newBufferedReader(Paths.get(ACCOUNT_CSV_FILE));
                
            // creating parser from apache commons csv API
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader() // ignore the header
                    .withIgnoreHeaderCase()
                    .withTrim());
        ) {
            
            // For each record that the parser records, 
            for (CSVRecord csvRecord : csvParser) {
                
                // Accessing values by Header names
                String fullName = csvRecord.get("name");
                String username = csvRecord.get("userName");
                String password = csvRecord.get("password");
                String occupation = csvRecord.get("occupation");
                String gender = csvRecord.get("gender");
                
                // Create a new account object with the corresponding csv record
                Account account = new Account(username, password, fullName, gender, occupation);
                
                // add the account to accountList of type List<Student>
                accountList.add(account);
                
            }
            
        }
        return accountList;
    }
  
    
    
    
    @FXML
    void createAccount(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registration Error");
        alert.setHeaderText(null);
        alert.setContentText("Please ensure you have input all of the necessary "
                + "fields and try again.");
        
        
        if (nameField.getText().isEmpty() 
                || usernameFieldRegister.getText().isEmpty() 
                || passwordFieldRegister.getText().isEmpty() 
                || occupationField.getText().isEmpty()) {
            alert.showAndWait();
            
        } else {
            String fullName = nameField.getText();
            String username = usernameFieldRegister.getText();
            String password = passwordFieldRegister.getText();
            String occupation = occupationField.getText();
            String gender = "";
            
            if (!specifyGenderField.getText().isEmpty()) {
                gender = specifyGenderField.getText().toLowerCase();
            } else if (maleButton.isSelected()) {
                gender = "male";
            } else if (femaleButton.isSelected()) {
                gender = "female";
            } else {
                System.out.println("Your problem is here");
                alert.showAndWait();
            }
            
            if (!gender.isEmpty()) {
                Account newUser = new Account(username, password, fullName, gender, occupation);
                accountList = getUsers();
                accountList.add(newUser);
                System.out.println(newUser);
                writeToCSV(accountList);
            }
        }
        

        
        
    }

    
    
    @FXML
    void login(ActionEvent event) throws IOException {
        
        if (verifyUser(usernameFieldExisting.getText(), passwordFieldExisting.getText())) {
            
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/eapitest/view/homeView.fxml"));
                Parent homeView = loader.load();
                Scene homeViewScene = new Scene(homeView);
                HomeController controller = loader.getController();
                controller.updatePage(usernameFieldExisting.getText());
                Stage homeWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
                homeWindow.setScene(homeViewScene);
                homeWindow.show();
                
            } catch (IOException e){
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error loading home page");
                alert.setHeaderText(null);
                alert.setContentText("Unable to load the home page. Error: " + e);
                alert.showAndWait(); 
            }
            
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login error");
            alert.setHeaderText(null);
            alert.setContentText("The specified user does not exist. "
                    + "Please confirm your username and password and try again.");
            alert.showAndWait();
        }
    }
    
    
    
    
    // Verifies the user credentials match user in the database
    // Returns true if the user is found
    private boolean verifyUser(String username, String password) throws IOException {
        
        accountList = getUsers();
        
        Predicate<Account> search = a -> a.getUserName().equals(username)
                && a.getPassword().equals(password);
        
        boolean confirmed = accountList.stream().anyMatch(search);

        return confirmed;
    }

    
    
    
    // Get & Set mehtods used for testing 
    
    public TextField getUsernameFieldExisting() {
        return usernameFieldExisting;
    }

    public void setUsernameFieldExisting(TextField usernameFieldExisting) {
        this.usernameFieldExisting = usernameFieldExisting;
    }

    public PasswordField getPasswordFieldExisting() {
        return passwordFieldExisting;
    }

    public void setPasswordFieldExisting(PasswordField passwordFieldExisting) {
        this.passwordFieldExisting = passwordFieldExisting;
    }

    public TextField getUsernameFieldRegister() {
        return usernameFieldRegister;
    }

    public void setUsernameFieldRegister(TextField usernameFieldRegister) {
        this.usernameFieldRegister = usernameFieldRegister;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextField getOccupationField() {
        return occupationField;
    }

    public void setOccupationField(TextField occupationField) {
        this.occupationField = occupationField;
    }

    public PasswordField getPasswordFieldRegister() {
        return passwordFieldRegister;
    }

    public void setPasswordFieldRegister(PasswordField passwordFieldRegister) {
        this.passwordFieldRegister = passwordFieldRegister;
    }

    public RadioButton getMaleButton() {
        return maleButton;
    }

    public void setMaleButton(RadioButton maleButton) {
        this.maleButton = maleButton;
    }

    public RadioButton getFemaleButton() {
        return femaleButton;
    }

    public void setFemaleButton(RadioButton femaleButton) {
        this.femaleButton = femaleButton;
    }

    public TextField getSpecifyGenderField() {
        return specifyGenderField;
    }

    public void setSpecifyGenderField(TextField specifyGenderField) {
        this.specifyGenderField = specifyGenderField;
    }

    
    
    
    
    
    @FXML
    void initialize() {
        assert usernameFieldExisting != null : "fx:id=\"usernameFieldExisting\" was not injected: check your FXML file 'mainView.fxml'.";
        assert passwordFieldExisting != null : "fx:id=\"passwordFieldExisting\" was not injected: check your FXML file 'mainView.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert usernameFieldRegister != null : "fx:id=\"usernameFieldRegister\" was not injected: check your FXML file 'mainView.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert occupationField != null : "fx:id=\"occupationField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert passwordFieldRegister != null : "fx:id=\"passwordFieldRegister\" was not injected: check your FXML file 'mainView.fxml'.";
        assert maleButton != null : "fx:id=\"maleButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert femaleButton != null : "fx:id=\"femaleButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert specifyGenderField != null : "fx:id=\"specifyGenderField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'mainView.fxml'.";

        window.setExpandedPane(loginPane);
        
    }
}
