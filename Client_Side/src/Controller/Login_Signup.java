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
    public static String username, password, gender;
    public static ArrayList<User> loggedInUser = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<User>();
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

    public void registration(ActionEvent event) {
        if (!regName.getText().equalsIgnoreCase("")
                && !regPass.getText().equalsIgnoreCase("")
                && !regEmail.getText().equalsIgnoreCase("")
                && !regFirstName.getText().equalsIgnoreCase("")
                && !regPhoneNo.getText().equalsIgnoreCase("")
                && (male.isSelected() || female.isSelected())) {

            if (checkUser(regName.getText())) {
                if (checkEmail(regEmail.getText())) {
                    User newUser = new User();
                    newUser.name = regName.getText();
                    newUser.password = regPass.getText();
                    newUser.email = regEmail.getText();
                    newUser.fullName = regFirstName.getText();
                    newUser.phoneNo = regPhoneNo.getText();

                }
            }
        }
    }

    private boolean checkUser(String username) {
        for (User user : users) {
            if (user.name.equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEmail(String email) {
        for (User user : users) {
            if (user.email.equalsIgnoreCase(email)) {
                return false;
            }
        }
        return true;
    }


    public void login(ActionEvent event) {

    }


    public void handleButtonAction(ActionEvent event) {
    }

    public void handleMouseEvent(MouseEvent mouseEvent) {
    }


}
