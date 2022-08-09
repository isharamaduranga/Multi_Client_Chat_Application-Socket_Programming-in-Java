import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author : Ishara Maduarnga
 * Project Name: Chat_Application
 * Date        : 7/30/2022
 * Time        : 12:03 AM
 * Year        : 2022
 */

public class Client02 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/sample.fxml"));
        primaryStage.setTitle("Messenger!");
        primaryStage.setScene(new Scene(root, 330, 560));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
