import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client02 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/Login_Signup.fxml"));
        primaryStage.setTitle("Group-Messenger!");
        primaryStage.setScene(new Scene(root, 330, 560));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
