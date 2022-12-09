package home;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

public class HomeController {

    @FXML
    private FontAwesomeIcon SIGN;

    @FXML
    private Button addButton;

    @FXML
    private Label customersLabel;

    @FXML
    private Button dashbordButton;

    @FXML
    private Label incomeLabel;

    @FXML
    private Button sellButton;

    @FXML
    private Label sellersLabel;

    @FXML
    private Button signoutButton;

    @FXML
    private Button userButton;
    Main m = new Main();

    @FXML
    void add(ActionEvent event) {
        m.changeScene("/home/stock/stock.fxml");
    }

    @FXML
    void dashboard(ActionEvent event) {

    }

    @FXML
    void sell(ActionEvent event) {

    }
    @FXML
    void getUsers(ActionEvent event){
        m.changeScene("/home/users/users.fxml");
    }

    @FXML
    void signout(ActionEvent event) {
        m.changeScene("/signin/signin.fxml");
    }

}

