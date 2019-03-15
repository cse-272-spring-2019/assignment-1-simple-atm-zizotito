
public class History {
	Stack stack;
	String temp;
	
	public History() {
		stack = new Stack();
	}
	
	public void addDeposit(String amount) {
		stack.addToQueue("deposited "+amount);
	}
	
	public void addWithdraw(String amount) {
		stack.addToQueue("withdrawn "+amount);
	}
	
	public void addBalanceInquiry(String amount) {
		stack.addToQueue("balance inquire "+amount);
	}
	
	public String getPrevious() {
		temp = stack.getPreviousInQueue();
		if(temp == null) return "No previous transactions";
		return "Previous transaction: "+temp;
	}
	
	public String getNext() {
		temp = stack.getNextInQueue();
		if(temp == null) return "No next transactions";
		return "Next transaction: "+temp;
	}
	
	public void resetNavigation() {
		stack.resetTop();
	}
}
