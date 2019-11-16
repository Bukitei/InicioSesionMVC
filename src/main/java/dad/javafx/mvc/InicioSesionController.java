package dad.javafx.mvc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javafx.application.Platform;
import org.apache.commons.codec.digest.DigestUtils;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InicioSesionController {

        private final String usersFile = "users.csv";
        
	private InicioSesionModel model = new InicioSesionModel();
	private InicioSesionView view = new InicioSesionView();
	
	public InicioSesionController() {
		
		model = new InicioSesionModel();
		view = new InicioSesionView();
		
		
		model.userProperty().bindBidirectional(view.getUserText().textProperty());
		model.passwdProperty().bindBidirectional(view.getPassText().textProperty());
		
		
		view.getLoginBt().setOnAction( evt -> onLoginBtAction(evt));
		view.getCancelBt().setOnAction( evt -> Platform.exit() );
		
	}
        
        private void onLoginBtAction(ActionEvent evt) {
		
		// Aquí vamos a comprobar las credenciales
		String user = model.getUser();
		String password = model.getPasswd();
		
		// Comprobamos que las credenciales son válidas
		if( user.isEmpty() || password.isEmpty() || !isUserValid(user, password) ) {
			launchLoginError();
			model.setPasswd("");
		}
		
		else {
			
			// Es válido, hemos terminado
			launchLoginOk();
			Platform.exit();
		}
	}
        
        private boolean isUserValid(String userName, String password) {
		
		FileInputStream file = null;
		InputStreamReader in = null;
		BufferedReader buff = null;
		
		try {
			
			 file = new FileInputStream(usersFile);
			 in = new InputStreamReader(file, StandardCharsets.UTF_8);
			 buff = new BufferedReader(in);
			 
			 String line;
			 while( (line = buff.readLine()) != null ) {
				 
				 // data[0] -> user, data[1] -> password, si los dos coinciden con alguno hemos terminado
				 String[] data = line.split(",");
				 if( userName.equals(data[0]) && MD5Cod(password).equals(data[1]) ) {
					 return true;
				 }
			 }			
			 
		} catch (IOException e) {
		} finally {
			
			try {
				if( buff != null ) {
					buff.close();
				}
				
				if( in != null ) {
					in.close();
				}
				
				if( file != null ) {
					file.close();
				}
			} catch (IOException e) {
			}
		}
		
		return false;
	}
        
        private String MD5Cod(String text) { return DigestUtils.md5Hex(text).toUpperCase(); }
	
	private void launchLoginOk() {
		
		Alert confAlert = new Alert(AlertType.INFORMATION);
		confAlert.setHeaderText("Acceso permitido");
		confAlert.setContentText("Las credenciales de acceso son válidas");
		confAlert.showAndWait();
	}

	private void launchLoginError() {
		
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("Acceso denegado");
		errorAlert.setContentText("El usuario y/o la contraseña no son válidos");
		errorAlert.showAndWait();
	}
	
	public InicioSesionView getRoot() {
		return view;
	}
        
}
