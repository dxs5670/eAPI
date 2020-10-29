package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
    
    public static void main(String[] args) 
    {
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