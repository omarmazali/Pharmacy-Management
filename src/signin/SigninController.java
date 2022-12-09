package signin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import main.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SigninController {

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button signupButton;

    @FXML
    private PasswordField pwdField;

    @FXML
    public TextField usernameField;

    @FXML
    private Label wrongLabel;

    ConnectionDB dbConnection = new ConnectionDB();
    Connection cnx = ConnectionDB.getCnx();
    Main m = new Main();

    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void login(ActionEvent event) {

        if(!usernameField.getText().isBlank() && !pwdField.getText().isBlank()){
            checkLogin();

        } else {
            wrongLabel.setText("Please enter your personal details");
        }
    }

    private void checkLogin(){

        try{

            Statement statement = cnx.createStatement();
            ResultSet results = statement.executeQuery("SELECT count(1) FROM users WHERE username = '" +
                    usernameField.getText()+"' AND password ='"+pwdField.getText()+"'");


            while (results.next()){
                if(results.getInt(1) == 1){
                    m.changeScene("/home/home.fxml");
                } else{
                    wrongLabel.setText("Invalid login. Please try again");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void signup(ActionEvent actionEvent) {
        m.changeScene("/signup/signup.fxml");
    }

    public TextField getUsernameField(){
        return usernameField;
    }

}
