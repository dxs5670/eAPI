package eapitest.controller;

import eapitest.model.LoanApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoanStatusController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Text loanStatusHeader;

    @FXML
    private TextArea loanStatusInfo;

    @FXML
    private TextArea pendingApplicationSummary;

    @FXML
    private Button cancelButton;
    
    private LoanApp currentApplication;
    
    
    
    // Declaration of the scene accessed previously
    private Scene previousScene;
    
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    } 

    @FXML
    void cancelLoanApplication(ActionEvent event) {

    }

    @FXML
    void returnHome(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }
    
    void updatePage() {
        pendingApplicationSummary.setText(getCurrentApplication().toString());
        loanStatusInfo.setText(getCurrentApplication().getLoanStatus());
    }

    public LoanApp getCurrentApplication() {
        return currentApplication;
    }

    public void setCurrentApplication(LoanApp currentApplication) {
        this.currentApplication = currentApplication;
    }

    
    
    
    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'loanStatusView.fxml'.";
        assert loanStatusHeader != null : "fx:id=\"loanStatusHeader\" was not injected: check your FXML file 'loanStatusView.fxml'.";
        assert loanStatusInfo != null : "fx:id=\"loanStatusInfo\" was not injected: check your FXML file 'loanStatusView.fxml'.";
        assert pendingApplicationSummary != null : "fx:id=\"pendingApplicationSummary\" was not injected: check your FXML file 'loanStatusView.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'loanStatusView.fxml'.";

    }
}