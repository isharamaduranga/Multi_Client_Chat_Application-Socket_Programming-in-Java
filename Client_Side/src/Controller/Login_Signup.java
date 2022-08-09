/**
 * @author : Ishara Maduarnga
 * Project Name: Multi_Client_Chat_Application
 * Date        : 8/9/2022
 * Time        : 10:10 AM
 * Year        : 2022
 */

package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Login_Signup {
    public Pane pnSignUp;
    public ImageView btnBack;
    public PasswordField regPass;
    public TextField regFirstName;
    public TextField regEmail;
    public Button getStarted;
    public Label controlRegLabel;
    public Label success;
    public Label goBack;
    public TextField regName;
    public RadioButton male;
    public ToggleGroup Gender;
    public RadioButton female;
    public Label nameExists;
    public Label checkEmail;
    public TextField regPhoneNo;
    public Pane pnSignIn;
    public TextField userName;
    public PasswordField passWord;
    public Button btnSignUp;
    public Label loginNotifier;

    public static String username, password, gender;
    public static ArrayList<User> loggedInUser = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<User>();

    public void registration(ActionEvent event) {

    }


    public void login(ActionEvent event) {

    }


    public void handleButtonAction(ActionEvent event) {
    }

    public void handleMouseEvent(MouseEvent mouseEvent) {
    }




}
