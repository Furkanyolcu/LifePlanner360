package planmanagementsystem;

import javax.mail.*;
import javax.mail.internet.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane login_form;

    @FXML
    private TextField si_username;

    @FXML
    private PasswordField si_password;

    @FXML
    private Button si_loginBtn;

    @FXML
    private Hyperlink si_createAccount;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private TextField su_username;

    @FXML
    private PasswordField su_password;

    @FXML
    private Button su_signupBtn;

    @FXML
    private Hyperlink su_alreadyhaveAccount;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Alert alert;

     public void loginAccount() {

        String selectData = "SELECT username, password FROM user WHERE username = '"
                + si_username.getText() + "' and password = '" + si_password.getText() + "'";

        connect = database.connectDB();

        try {

            if (si_username.getText().isEmpty() || si_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(selectData);
                result = prepare.executeQuery();

                if (result.next()) {

                    data.username = si_username.getText();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();


                    si_loginBtn.getScene().getWindow().hide();


                    Parent root = FXMLLoader.load(getClass().getResource("planController.fxml"));

                    Stage stage = new Stage();
                    stage.setTitle("Plans Management System");

                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Username/Password");
                    alert.showAndWait();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public void registerAccount() {
    String insertData = "INSERT INTO user (username, password, date) VALUES(?,?,?)";

    connect = database.connectDB();

    try {
        if (su_username.getText().isEmpty() || su_password.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {

            String checkUsername = "SELECT username FROM user WHERE username = ?";
            prepare = connect.prepareStatement(checkUsername);
            prepare.setString(1, su_username.getText());
            result = prepare.executeQuery();

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(su_username.getText() + " was already taken");
                alert.showAndWait();
            } else {

                if (su_password.getText().length() < 8) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid Password, at least 8 characters needed");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, su_username.getText());
                    prepare.setString(2, su_password.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(3, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    new Thread(() -> sendWelcomeEmail(su_username.getText())).start();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully created a new account! A welcome email has been sent.");
                    alert.showAndWait();

                    su_username.setText("");
                    su_password.setText("");

                    signup_form.setVisible(false);
                    login_form.setVisible(true);
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void sendWelcomeEmail(String username) {
    String host = "smtp.gmail.com";
    String port = "587";
    String senderEmail = "EMAİL"; // Write your email address here
    String senderPassword = "KEY"; // Add your key here
    String subject = "Welcome to the Planner!";

    String messageText = "<!DOCTYPE html>"
            + "<html lang='en'>"
            + "<head>"
            + "<meta charset='UTF-8'>"
            + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
            + "<style>"
            + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }"
            + ".email-container { background-color: #ffffff; max-width: 600px; margin: 20px auto; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); text-align: center; }"
            + ".header { background-color: #4CAF50; color: #ffffff; padding: 20px; text-align: center; border-top-left-radius: 8px; border-top-right-radius: 8px; }"
            + ".content { padding: 20px; color: #333333; line-height: 1.6; text-align: left; }"
            + ".footer { background-color: #f4f4f4; color: #777777; text-align: center; padding: 10px; border-bottom-left-radius: 8px; border-bottom-right-radius: 8px; font-size: 12px; }"
            + ".button { display: inline-block; background-color: #4CAF50; color: #ffffff; padding: 15px 30px; text-decoration: none; border-radius: 5px; margin-top: 20px; font-weight: bold; }"
            + ".button-container { margin: 20px 0; text-align: center; }"
            + "</style>"
            + "</head>"
            + "<body>"
            + "<div class='email-container'>"
            + "<div class='header'>"
            + "<h1>Welcome to the Planner!</h1>"
            + "</div>"
            + "<div class='content'>"
            + "<p>Dear " + username + ",</p>"
            + "<p>Thank you for joining our planner application. We're excited to help you organize and track your plans seamlessly. Here's what you can do with our application:</p>"
            + "<ul>"
            + "<li><strong>Plan Management:</strong> Add your tasks with start and end dates, mark them as completed, and manage your daily, weekly, or monthly goals effortlessly.</li>"
            + "<li><strong>Statistics Dashboard:</strong> View detailed insights, including your account creation date, total plans added, and completed tasks to analyze your productivity.</li>"
            + "<li><strong>Weather Integration:</strong> Check the current weather conditions and plan your outdoor or weather-dependent activities directly from the app using real-time weather APIs.</li>"
            + "<li><strong>Outlook Calendar Integration:</strong> Sync your plans with Microsoft Outlook, enabling reminders, email notifications, and alerts for your scheduled tasks. This ensures you never miss an important deadline.</li>"
            + "</ul>"
            + "<p>Our planner is designed to make your life easier by combining the power of organization and advanced features like weather forecasting and calendar synchronization. Whether you're planning your day or managing long-term goals, we've got you covered!</p>"
            + "<p>Feel free to explore the app and take advantage of the built-in tools to maximize your productivity.</p>"
            + "<div class='button-container'>"
            + "<a href='http://localhost:8080/your-dashboard' class='button'>Explore Your Planner</a>"
            + "</div>"
            + "</div>"
            + "<div class='footer'>"
            + "<p>&copy; 2025 Planner Application. All rights reserved.</p>"
            + "<p>For support or inquiries, please contact us at <a href='mailto:support@plannerapp.com'>support@plannerapp.com</a>.</p>"
            + "</div>"
            + "</div>"
            + "</body>"
            + "</html>";

    Properties properties = new Properties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", port);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmail, senderPassword);
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(username));
        message.setSubject(subject);
        message.setContent(messageText, "text/html; charset=utf-8");

        Transport.send(message);
        System.out.println("Welcome email sent successfully!");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
}


    public void switchForm(ActionEvent event) {
        if (event.getSource() == si_createAccount) {
            signup_form.setVisible(true);
            login_form.setVisible(false);
        } else if (event.getSource() == su_alreadyhaveAccount) {
            signup_form.setVisible(false);
            login_form.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
