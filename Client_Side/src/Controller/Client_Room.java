/**
 * @author : Ishara Maduarnga
 * Project Name: Multi_Client_Chat_Application
 * Date        : 8/9/2022
 * Time        : 11:50 AM
 * Year        : 2022
 */

package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Client_Room extends Thread implements Initializable {
    public Label clientName;
    public Button profileBtn;
    public Circle showProPic;
    public Pane profile;
    public Label fullName;
    public Label email;
    public Label phoneNo;
    public Label gender;
    public ImageView proImage;
    public TextField fileChoosePath;
    public TextArea msgRoom;
    public TextField msgField;
    public Pane chat;
    public Button a;
    public Button b;
    public Button c;
    public Button d;
    public Button e;
    public Button f;
    public Button g;
    public Button h;
    public Button i;
    public Button j;
    public Button k;
    public Button l;
    public Rectangle emojiBox;

    public boolean toggleChat = false, toggleProfile = false;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    private FileChooser fileChooser;
    private File filePath;

    public void connectSocket(){
        try {
            socket = new Socket("localhost", 5005);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleProfileBtn(ActionEvent event) {

    }

    public void chooseImageButton(ActionEvent event) {
    }

    public void saveImage(ActionEvent event) {
    }

    public void mouseClickedAnotherArea(MouseEvent mouseEvent) {
    }

    public void handleSendEvent(MouseEvent mouseEvent) {
    }

    public void sendMessageByKey(KeyEvent event) {
    }

    public void cameraIconMouseClicked(MouseEvent mouseEvent) {
    }

    public void clickEmoji1(MouseEvent mouseEvent) {
    }

    public void clickEmoji2(MouseEvent mouseEvent) {
    }

    public void clickEmoji3(MouseEvent mouseEvent) {
    }

    public void clickEmoji4(MouseEvent mouseEvent) {
    }

    public void clickEmoji5(MouseEvent mouseEvent) {
    }

    public void clickEmoji6(MouseEvent mouseEvent) {
    }

    public void clickEmoji7(MouseEvent mouseEvent) {
    }

    public void clickEmoji8(MouseEvent mouseEvent) {
    }

    public void clickEmoji9(MouseEvent mouseEvent) {
    }

    public void clickEmoji10(MouseEvent mouseEvent) {
    }

    public void clickEmoji11(MouseEvent mouseEvent) {
    }

    public void clickEmoji12(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}