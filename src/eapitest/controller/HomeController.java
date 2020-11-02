package eapitest.controller;

import eapitest.model.Account;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {
    
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logOutButton;

    @FXML
    private Button disputeButton;

    @FXML
    private Button statusButton;

    @FXML
    private Text activeUserName;
    
    private Account activeUser;

    

    
    
    
    @FXML
    void launchAccount(ActionEvent event) throws IOException {
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("/eapitest/view/accountView.fxml"));
        Parent accountScene = accountLoader.load();
        Scene accountUI = new Scene(accountScene);
        AccountController aController = accountLoader.getController();
        Stage accountWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        accountWindow.setScene(accountUI);
        aController.setActiveUser(activeUser);
        aController.getLoans();
        aController.getLoanApps();
        aController.setPreviousScene(((Node) event.getSource()).getScene());
        accountWindow.show();
    }

    @FXML
    void launchDispute(ActionEvent event) throws IOException {
        FXMLLoader disputeLoader = new FXMLLoader(getClass().getResource("/eapitest/view/disputeView.fxml"));
        Parent dispute = disputeLoader.load();
        Scene disputeUI = new Scene(dispute);
        DisputeController dController = disputeLoader.getController();
        Stage disputeWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        disputeWindow.setScene(disputeUI);
        //dController.setActiveUser(activeUser);
        dController.setPreviousScene(((Node) event.getSource()).getScene());
        disputeWindow.show();
    }

    @FXML
    void launchLoanApp(ActionEvent event) throws IOException {
        FXMLLoader loanAppLoader = new FXMLLoader(getClass().getResource("/eapitest/view/loanAppView.fxml"));
        Parent loanApp = loanAppLoader.load();
        Scene loanAppUI = new Scene(loanApp);
        LoanAppController laController = loanAppLoader.getController();
        Stage loanAppWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loanAppWindow.setScene(loanAppUI);
        laController.setActiveUser(activeUser);
        laController.setPreviousScene(((Node) event.getSource()).getScene());
        loanAppWindow.show();
    }

    @FXML
    void launchLoanStatus(ActionEvent event) throws IOException {
        FXMLLoader loanStatusLoader = new FXMLLoader(getClass().getResource("/eaopitest/view/loanStatusView.fxml"));
        Parent loanStatus = loanStatusLoader.load();
        Scene loanStatusUI = new Scene(loanStatus);
        LoanStatusController lsController = loanStatusLoader.getController();
        Stage loanStatusWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loanStatusWindow.setScene(loanStatusUI);
        //lsController.setActiveUser(activeUser);
        lsController.setPreviousScene(((Node) event.getSource()).getScene());
        loanStatusWindow.show();
    }

    @FXML
    void logOut(ActionEvent event) {
        System.exit(1);

    }
    
    
    public void updatePage(String username) {
        activeUserName.setText(username);
    }
    
    //get & se active user

    public Account getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Account activeUser) {
        this.activeUser = activeUser;
    }
    
    
    
    

    @FXML
    void initialize() {
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'homeView.fxml'.";
        assert disputeButton != null : "fx:id=\"disputeButton\" was not injected: check your FXML file 'homeView.fxml'.";
        assert statusButton != null : "fx:id=\"statusButton\" was not injected: check your FXML file 'homeView.fxml'.";
        assert activeUserName != null : "fx:id=\"activeUserName\" was not injected: check your FXML file 'homeView.fxml'.";

    }
}
