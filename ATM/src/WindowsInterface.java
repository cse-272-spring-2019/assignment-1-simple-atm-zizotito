import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowsInterface {
	Card card;
	History history;
	Stage mainStage;
	WindowsInterface windowsInterface;
	LoginWindow loginWindow;
	MenuWindow menuWindow;
	TransactionWindow transactionWindow;

	public WindowsInterface(Stage mainStage, Card card, History history) {
		this.mainStage = mainStage;
		this.card = card;
		this.history = history;
	}

	public void openWindow() {
		loginWindow = new LoginWindow(windowsInterface, mainStage, card);
		menuWindow = new MenuWindow(windowsInterface, mainStage, card, history);
		transactionWindow = new TransactionWindow(windowsInterface, mainStage, card, history);
		
		loginWindow.loadScene();
		menuWindow.loadScene();
		transactionWindow.loadScene();
		
		openLoginWindow();
		mainStage.show();
	}
	
	public void openLoginWindow() {
		mainStage.setScene(loginWindow.getScene());
		mainStage.setTitle("Login");
	}
	
	public void openMenuWindow(int type, String amount) {
		mainStage.setScene(menuWindow.getScene(type, amount));
		mainStage.setTitle("Menu");
	}
	
	public void openTransactionWindow(boolean type) {
		if(type) {
			mainStage.setScene(transactionWindow.getScene(type));
			mainStage.setTitle("Deposit");
		}
		else {
			mainStage.setScene(transactionWindow.getScene(type));
			mainStage.setTitle("Withdraw");
		}	
	}
	
	public void setWindowsInterface(WindowsInterface windowsInterface) {
	this.windowsInterface = windowsInterface;
	}
}
