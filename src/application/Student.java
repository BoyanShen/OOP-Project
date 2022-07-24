package application;



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
