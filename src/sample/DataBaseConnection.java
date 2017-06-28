package sample;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.transform.Result;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hector on 6/26/17.
 */
public class DataBaseConnection {
    private Connection sqlConnection;
    private Statement sqlStatement;
    PreparedStatement preparedStatement;

    public DataBaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConnection = DriverManager.getConnection("jdbc:mysql://192.168.1.126:3306/appointments", "hector", "7895123.zZ");
            sqlStatement = sqlConnection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAppointment(String FirstName, String LastName, String appointmentDate, String appointmentTime, String ConfirmationString) {
        String sqlString = "INSERT INTO appointments(FirstName,LastName,appointmentDate,appointmentTime,confirmation,scheduled) VALUES(?,?,?,?,?,1) ";
        try {
            preparedStatement= sqlConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setString(3, appointmentDate);
            preparedStatement.setString(4, appointmentTime);
            preparedStatement.setString(5, ConfirmationString);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  getOpenAppointmentSlots() {
        String getAvailableSlots = "SELECT * FROM appointments WHERE appointmentDate > "
                + new SimpleDateFormat("YYYY-MM-DD").format(new java.util.Date());
        try {
            Main.currentAppointments = sqlStatement.executeQuery(getAvailableSlots);
         } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

