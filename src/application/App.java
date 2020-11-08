package application;

import eapitest.controller.Handler;
import eapitest.controller.LoanHandleHigh;
import eapitest.controller.LoanHandleLow;
import eapitest.controller.LoanHandleMid;
import eapitest.controller.processLoan;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
    
    public static void main(String[] args) 
    {   
        Handler h1 = new LoanHandleLow();
        
        Handler h2 = new LoanHandleMid();
        
        Handler h3 = new LoanHandleHigh();
        
        h1.handleRequest(new processLoan("Low Loan", 1000));
        h2.handleRequest(new processLoan("Mid Loan", 10000));
        h3.handleRequest(new processLoan("High Loan", 1000000));
        
        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {                                
      // Load loginView upon running the application
      Parent root = FXMLLoader.load(getClass().getResource("/eapitest/view/loginView.fxml")); 
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Login or Register for eFinance");
      primaryStage.show();
    }
}