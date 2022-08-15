/**
 * @author : Ishara Maduarnga
 * Project Name: Multi_Client_Chat_Application
 * Date        : 8/9/2022
 * Time        : 11:50 AM
 * Year        : 2022
 */

package Controller;

import animatefx.animation.FadeIn;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    public TextField msgField;
    public Pane chat;


    public boolean toggleChat = false, toggleProfile = false;

    /**
     * Changing profile pic
     */

    public boolean saveControl = false;
    public VBox vbox;


    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    String msg = "";
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

    public void connectSocket() {
        try {
            socket = new Socket("localhost", 5012);
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

//                txtTextArea.appendText(cmd+"\n");
                StringBuilder fullMsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fullMsg.append(tokens[i]);
                }


                String[] msgToAr = msg.split(" ");
                String st = "";
                for (int i = 0; i < msgToAr.length - 1; i++) {
                    st += msgToAr[i + 1] + " ";
                }
//======================================================================


                Text text = new Text(st);
                String firstChars = "";
                if (st.length() > 3) {
                    firstChars = st.substring(0, 3);

                }


                if (firstChars.equalsIgnoreCase("img")) {
                    //for the Images

                    st = st.substring(3, st.length() - 1);


                    File file = new File(st);
                    Image image = new Image(file.toURI().toString());

                    ImageView imageView = new ImageView(image);

                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);


                    HBox hBox = new HBox(10);
                    hBox.setAlignment(Pos.BOTTOM_RIGHT);


                    if (!cmd.equalsIgnoreCase(Login_Signup.username)) {

                        vbox.setAlignment(Pos.TOP_LEFT);
                        hBox.setAlignment(Pos.CENTER_LEFT);


                        Text text1 = new Text("  " + cmd + " :");
                        hBox.getChildren().add(text1);
                        hBox.getChildren().add(imageView);

                    } else {
                        hBox.setAlignment(Pos.BOTTOM_RIGHT);
                        hBox.getChildren().add(imageView);
                        Text text1 = new Text(": Me ");
                        hBox.getChildren().add(text1);

                    }

                    Platform.runLater(() -> vbox.getChildren().addAll(hBox));


                } else {
                    //For the Text
                    text.setFill(Color.WHITE);
                    text.getStyleClass().add("message");
                    TextFlow tempFlow = new TextFlow();

                    if (!cmd.equalsIgnoreCase(Login_Signup.username + ": ")) {
                        Text txtName = new Text(cmd );
                        txtName.getStyleClass().add("txtName");
                        tempFlow.getChildren().add(txtName);
                    }

                    tempFlow.getChildren().add(text);
                    tempFlow.setMaxWidth(200); //200

                    TextFlow flow = new TextFlow(tempFlow);

                    HBox hBox = new HBox(12); //12
                    hBox.setMinHeight(50);
                    hBox.setMaxHeight(50);
                    hBox.setPrefHeight(50);
                    hBox.setFillHeight(false);




                    //=================================================


                    if (!cmd.equalsIgnoreCase(Login_Signup.username + ": ")) {
                        tempFlow.getStyleClass().add("tempFlowFlipped");
                        flow.getStyleClass().add("textFlowFlipped");
                        vbox.setAlignment(Pos.TOP_LEFT);
                        hBox.setAlignment(Pos.CENTER_LEFT);
                        hBox.getChildren().add(flow);

                    } else {
                     text.setFill(Color.WHITE);
                        tempFlow.getStyleClass().add("tempFlow");
                       flow.getStyleClass().add("textFlow");

                        hBox.setAlignment(Pos.BOTTOM_RIGHT);
                        hBox.getChildren().add(flow);
                    }
                    hBox.getStyleClass().add("hbox");
                    Platform.runLater(() -> vbox.getChildren().addAll(hBox));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 /*   public void run() {
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
    }*/

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
        for (User user : users) {
            System.out.println(user.name);
        }
    }

    public void send() {
        msg = msgField.getText();
        writer.println(Login_Signup.username + ": " + msg);

       /* msgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        msgRoom.appendText("Me: " + msg + "\n");*/


        msgField.setText("");
        if (msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
            System.exit(0);
        }
    }

    public void chooseImageButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        this.filePath = fileChooser.showOpenDialog(stage);
        fileChoosePath.setText(filePath.getPath());
        saveControl = true;
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

    public void sendMessageByKey(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            send();
        }
    }


    public void cameraIconMouseClicked(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        this.filePath = fileChooser.showOpenDialog(stage);
        writer.println(Login_Signup.username + " " + "img" + filePath.getPath());
    }

    public void addNewStage(MouseEvent mouseEvent) throws IOException {


      /*  Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Login_Signup.fxml"))));
        stage.setTitle("Messenger!");
        stage.setResizable(false);
        stage.show();
*/
    }
}
