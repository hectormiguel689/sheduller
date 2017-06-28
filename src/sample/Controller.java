package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
import javax.xml.soap.Text;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import static java.sql.Date.valueOf;

public class Controller {
    @FXML
    TextField customerFirstName = new TextField();
    @FXML
    TextField customerLastName = new TextField();
    @FXML
    DatePicker appointmentDate = new DatePicker();
    @FXML
    ComboBox appointmentTimeComboBox = new ComboBox();
    @FXML
    Button bookButton = new Button();
    @FXML
    Button cancelButton = new Button();

    @SuppressWarnings("Since15")
    @FXML
    public void setBookButtonClicked(){
        String FirstName = customerFirstName.getText();
        String LastName = customerLastName.getText();
        String Date = appointmentDate.getValue().toString();
        String time = new SimpleDateFormat("HH:mm:ss").format(appointmentTimeComboBox.getSelectionModel().getSelectedItem());
        Main.dbconnect.addAppointment(FirstName,LastName,Date,time,"CONFIRMED");
        JOptionPane.showMessageDialog(null,"Appointment Confirmation for: \n" +
                "Name: " + FirstName  + " " + LastName + "\n" +
                 "Date: " + Date + "\n"
                  ,"Confirmation",JOptionPane.INFORMATION_MESSAGE);
    }
    @FXML
    public void onMouseEnterStage(){

    }

}
