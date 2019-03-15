
public class Card {
	String cardNumber;
	double balance;
	
	public Card() {
		cardNumber = "5608";
		balance = 0.0;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public boolean withdraw(double amount) {
		if(amount > balance) return false;
		balance = balance - amount;
		return true;
	}
	
	public double balanceInquiry() {
		return balance;
	}
	
	public boolean checkCardNumber(String Number) {
		if(cardNumber.equals(Number)) return true;
		else return false;
	}
}
