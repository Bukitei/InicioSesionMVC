package dad.javafx.main;

import dad.javafx.mvc.InicioSesionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private InicioSesionController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new InicioSesionController();
		
		Scene scene = new Scene(controller.getRoot(), 320, 200);
		
		primaryStage.setTitle("Inicio sesión");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}