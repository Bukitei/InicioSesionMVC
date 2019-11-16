package dad.javafx.mvc;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InicioSesionModel {

	private StringProperty user = new SimpleStringProperty();
	private StringProperty passwd = new SimpleStringProperty();
	
	public final StringProperty userProperty() {
		return this.user;
	}
	
	public final String getUser() {
		return this.userProperty().get();
	}
	
	public final void setUser(final String user) {
		this.userProperty().set(user);
	}
	
	public final StringProperty passwdProperty() {
		return this.passwd;
	}
	
	public final String getPasswd() {
		return this.passwdProperty().get();
	}
	
	public final void setPasswd(final String passwd) {
		this.passwdProperty().set(passwd);
	}
	
	
	
}
