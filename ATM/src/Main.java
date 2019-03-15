import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	Card card;
	History history;
	WindowsInterface windowsInterface;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage mainStage) throws Exception {
		card = new Card();
		history = new History();
		windowsInterface = new WindowsInterface(mainStage, card, history);
		
		windowsInterface.setWindowsInterface(windowsInterface);
		windowsInterface.openWindow();
	}
}