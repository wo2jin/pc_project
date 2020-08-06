package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class controller implements Initializable {
	@FXML
	private Button exit;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		exit.setOnMouseClicked( event ->{Platform.exit();});
	}

}
