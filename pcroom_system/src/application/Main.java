package application;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml")); 
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Hello javaFx");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		
//		VBox root = new VBox();
//		root.setPrefSize(400,400);
//		root.setAlignment(Pos.CENTER);
//		
//		Button btn = new Button("종료");
//		btn.setPrefWidth(80);
//		btn.setOnAction(event->Platform.exit());
//		root.getChildren().add(btn);
//	
//		Scene scene = new Scene(root);
//		primaryStage.setTitle("Hello JavaFx");
//		primaryStage.setResizable(false);
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
