package eapitest.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DisputeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea userDisputeDetails;

    @FXML
    private Button backButton;

    @FXML
    private Button updateButton;

    @FXML
    private TextArea disputeStatusMessage;

    
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
    void updateDisputeDetails(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert userDisputeDetails != null : "fx:id=\"userDisputeDetails\" was not injected: check your FXML file 'disputeView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'disputeView.fxml'.";
        assert updateButton != null : "fx:id=\"updateButton\" was not injected: check your FXML file 'disputeView.fxml'.";
        assert disputeStatusMessage != null : "fx:id=\"disputeStatusMessage\" was not injected: check your FXML file 'disputeView.fxml'.";

    }
}
