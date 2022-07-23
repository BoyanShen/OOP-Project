package application;

import javafx.event.ActionEvent;

public abstract class User extends WindowManager{
	private String id;
    private String password;
    
    public User(String id, String password) {
		this.setId(id);
		this.setPassword(password);
    }
    
    abstract User login(ActionEvent event);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}