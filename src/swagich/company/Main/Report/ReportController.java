/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swagich.company.Main.Report;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import swagich.company.Main.Mail.Mail;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class ReportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    JFXComboBox depCombo;
    @FXML
    JFXButton submitBtn;
    @FXML
    private JFXTextField shortTxt;
    @FXML
    private JFXTextArea longTxt;
    Task sendingMail;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void submitReport(ActionEvent ae) throws Exception {

        String sub = "Complaint in" + " " + String.valueOf(depCombo.getValue()) + " - " + shortTxt.getText();
        String content = longTxt.getText();

        Task sendingMessage = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                Mail mail = new Mail();

                /* Enter your gmail here and google how to enable less secure account in your gmail for successful execution of sending mails   
                 * replace it with the your_sender@email.com below and ayour password at your_password then recepient mail where you want your 
                 * mail to be sent , the subject of your mail and the message
                 */
                mail.sendMail("your_sender@email.com", "your_password", "recepient@email.com", sub, content);

                return null;
            }
        };

        new Thread(sendingMessage).start();

        longTxt.setText("");
        shortTxt.setText("");
        depCombo.setPromptText("Choose a department");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        depCombo.getItems().addAll("IT", "Finance", "Administration", "Software Development", "Personal");

        // depCombo.setValue("IT");
    }

}
