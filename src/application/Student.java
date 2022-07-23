package application;


import javafx.event.ActionEvent;


public class Student extends User{

	private int voteCount;
	private boolean hasVoted = false;
	
	Student(String id, String password){
		super(id, password);
	}
	
	Student(String id, String password, int voteCount, boolean hasVoted) {
		super(id, password);
		// TODO Auto-generated constructor stub
		this.voteCount = voteCount;
		this.hasVoted = hasVoted;
	}

	@Override
	User login(ActionEvent event) {
		userWelcome("welcomeStudent.fxml");
		closeWindow(event);
		System.out.println(getId() + "(Student) has logged in.");
		return null;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public boolean getHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

}
