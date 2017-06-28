package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.sql.*;

public class Main extends Application {
    static DataBaseConnection dbconnect;
    static ResultSet currentAppointments;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Appointment Maker");
        primaryStage.setMaxHeight(275);
        primaryStage.setMaxWidth(300);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        dbconnect = new DataBaseConnection();
        dbconnect.getOpenAppointmentSlots();
        launch(args);
    }

}
