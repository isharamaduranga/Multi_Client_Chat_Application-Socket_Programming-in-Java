/**
 * @author : Ishara Maduarnga
 * Project Name: Multi_Client_Chat_Application
 * Date        : 8/9/2022
 * Time        : 11:50 AM
 * Year        : 2022
 */

package Controller;

import animatefx.animation.FadeIn;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static Controller.Login_Signup.users;
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

    /** Changing profile pic */

    public boolean saveControl = false;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    private FileChooser fileChooser;
    private File filePath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showProPic.setStroke(Color.valueOf("#90a4ae"));
        Image image;
        if (Login_Signup.gender.equalsIgnoreCase("Male")) {
            image = new Image("View/icons/user.png", false);
        } else {
            image = new Image("View/icons/female.png", false);
            proImage.setImage(image);
        }
        showProPic.setFill(new ImagePattern(image));
        clientName.setText(Login_Signup.username);
        connectSocket();
    }

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
    @Override
    public void run() {
        try {
            while (true) {
                String msg = reader.readLine();
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];
                System.out.println(cmd);
                StringBuilder fulmsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println(fulmsg);
                if (cmd.equalsIgnoreCase(Login_Signup.username + ":")) {
                    continue;
                } else if (fulmsg.toString().equalsIgnoreCase("bye")) {
                    break;
                }
                msgRoom.appendText(msg + "\n");
            }
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleProfileBtn(ActionEvent event) {
        if (event.getSource().equals(profileBtn) && !toggleProfile) {
            new FadeIn(profile).play();
            profile.toFront();
            chat.toBack();
            toggleProfile = true;
            toggleChat = false;
            profileBtn.setText("Back");
            setProfile();
        } else if (event.getSource().equals(profileBtn) && toggleProfile) {
            new FadeIn(chat).play();
            chat.toFront();
            toggleProfile = false;
            toggleChat = false;
            profileBtn.setText("Profile");
        }
    }
    public void setProfile() {
        for (User user : users) {
            if (Login_Signup.username.equalsIgnoreCase(user.name)) {
                fullName.setText(user.fullName);
                fullName.setOpacity(1);
                email.setText(user.email);
                email.setOpacity(1);
                phoneNo.setText(user.phoneNo);
                gender.setText(user.gender);
            }
        }
    }


    public void handleSendEvent(MouseEvent mouseEvent) {
        send();
        for(User user : users) {
            System.out.println(user.name);
        }
    }
    String msg="";
    public void send() {
        msg = msgField.getText();
        writer.println(Login_Signup.username + ": " + msg);
        msgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        msgRoom.appendText("Me: " + msg + "\n");
        msgField.setText("");
        if(msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
            System.exit(0);
        }
    }

    public void chooseImageButton(ActionEvent event) {
    }

    public void saveImage(ActionEvent event) {
        if (saveControl) {
            try {
                BufferedImage bufferedImage = ImageIO.read(filePath);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                proImage.setImage(image);
                showProPic.setFill(new ImagePattern(image));
                saveControl = false;
                fileChoosePath.setText("");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void mouseClickedAnotherArea(MouseEvent mouseEvent) {
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


}
