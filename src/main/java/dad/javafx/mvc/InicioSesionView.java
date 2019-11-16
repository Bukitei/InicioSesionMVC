package dad.javafx.mvc;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioSesionView extends VBox {

	private TextField userText;
	private Button loginBt, cancelBt;
	private Label userLabel, passwdLabel;
	private PasswordField passText;
	
	public InicioSesionView() {
		userLabel = new Label("Usuario:");
		userLabel.setPrefWidth(80);
		
		passwdLabel = new Label("Contraseña:");
		passwdLabel.setPrefWidth(80);
		
		userText = new TextField();
		userText.setPromptText("Usuario");
		userText.setPrefColumnCount(10);
		
		passText = new PasswordField();
		passText.setPromptText("Contraseña");
		passText.setPrefColumnCount(10);
		
		loginBt = new Button("Acceder");
		loginBt.setDefaultButton(true);
		
		cancelBt = new Button("Cancelar");
		
		HBox userBox = new HBox(20, userLabel, userText);
		userBox.setFillHeight(false);
		userLabel.setAlignment(Pos.BASELINE_LEFT);
		
		HBox passBox = new HBox(20, passwdLabel, passText);
		passBox.setFillHeight(false);
		passBox.setAlignment(Pos.BASELINE_LEFT);
		
		HBox btBox = new HBox(5, loginBt, cancelBt);
		btBox.setFillHeight(false);
		btBox.setAlignment(Pos.BASELINE_CENTER);
		
		getChildren().addAll(userBox, passBox, btBox);
		setAlignment(Pos.CENTER);
		setSpacing(10);
		setFillWidth(false);
		
	}

	public TextField getUserText() {
		return userText;
	}

	public Button getLoginBt() {
		return loginBt;
	}

	public Label getUserLabel() {
		return userLabel;
	}

	public Label getPasswdLabel() {
		return passwdLabel;
	}

	public PasswordField getPassText() {
		return passText;
	}
        
        public Button getCancelBt() {
		return cancelBt;
	}
	
}
