package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Date;

public class Controller {

    @FXML
    public Label lblreceipt;
    @FXML
    public Label lbloutputname;
    @FXML
    public Label lbloutputage;
    @FXML
    public Label lbloutputid;
    @FXML
    public Label lbloutputcity;
    @FXML
    public Label lbloutputvtype;
    @FXML
    public Label lbldate;
    @FXML
    public Button btnback;
    @FXML
    public Label lbltopic;
    @FXML
    public Label lbldet;
    @FXML
    public Label lblfname;
    @FXML
    public Label lbllname;
    @FXML
    public Label lblage;
    @FXML
    public Label lblid;
    @FXML
    public Label lblcity;
    @FXML
    public Label lblvtype;
    @FXML
    public TextField txtfname;
    @FXML
    public TextField txtlname;
    @FXML
    public TextField txtage;
    @FXML
    public TextField txtid;
    @FXML
    public TextField txtcity;
    @FXML
    public TextField txtvtype;
    @FXML
    public Button btnsubmit;

    @FXML

    public void submit(){
        Date date=new Date();

        String fname =txtfname.getText();
        String lname=txtlname.getText();
        String age=txtage.getText();
        String city=txtage.getText();
        String id=txtid.getText();
        String vactype=txtvtype.getText();


        lbloutputname.setText("Patient Name      :"+fname+" "+lname);
        lbloutputage.setText("Age                :"+age);
        lbloutputid.setText("NIC or Passport No  :"+id);
        lbloutputcity.setText("City              :"+city);
        lbloutputvtype.setText("Vaccine Type     :"+vactype);


        lbldate.setText(String.valueOf(date));

        System.out.println(date);
    }
}
