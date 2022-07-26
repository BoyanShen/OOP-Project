package application;

public class Status {
	private boolean canView;
	Status(boolean canView){
		this.canView = canView;
	}
	
	public boolean getCanView() {
		return canView;
	}

	public void setCanView(boolean canView) {
		this.canView = canView;
	}
}
