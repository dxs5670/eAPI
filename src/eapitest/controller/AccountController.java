package eapitest.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private PasswordField updatePasswordField;

    @FXML
    private TextField updateUsernameField;

    @FXML
    private PasswordField confirmUpdatePasswordField;

    @FXML
    private Button updateButton;

    
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

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updatePasswordField != null : "fx:id=\"updatePasswordField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updateUsernameField != null : "fx:id=\"updateUsernameField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert confirmUpdatePasswordField != null : "fx:id=\"confirmUpdatePasswordField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updateButton != null : "fx:id=\"updateButton\" was not injected: check your FXML file 'accountView.fxml'.";

    }
}
