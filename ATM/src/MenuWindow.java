import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuWindow {
	Card card;
	History history;
	Stage mainStage;
	Scene scene;
	WindowsInterface windowsInterface;
	Label field;

	public MenuWindow(WindowsInterface windowsInterface, Stage mainStage, Card card, History history) {
		this.windowsInterface = windowsInterface;
		this.mainStage = mainStage;
		this.card = card;
		this.history = history;
	}
	
	public void loadScene() {
		Label title = new Label("Welcome to menu");
		title.setAlignment(Pos.CENTER);
		title.setStyle("-fx-font-size: 20;");
		
		Label separator = new Label("------------------------------------------------");
		
		field = new Label("Choose an option");
		field.setAlignment(Pos.CENTER);
		field.setMinSize(145, 25);
		field.setStyle("-fx-background-color: white;-fx-text-fill: grey;");
		
		Label message = new Label();
		message.setAlignment(Pos.CENTER_LEFT);
		message.setMinSize(135, 15);
		message.setStyle("-fx-text-fill: red;-fx-font-size: 10;");
		
		Label balanceLabel = new Label("-------------------(Balance)--------------------");
		balanceLabel.setMinSize(135, 15);
		balanceLabel.setStyle("-fx-text-fill: grey;");
		
		Button diposit = new Button("Diposit");
		Button withdraw = new Button("Withdraw");
		Button balanceInquiry = new Button("Balance Inquiry");
		GridPane balanceGrid = new GridPane();
		balanceGrid.setPadding(new Insets(10,0,10,0));
		balanceGrid.setHgap(10); 
		balanceGrid.add(diposit, 0, 0);
		balanceGrid.add(withdraw, 1, 0);
		balanceGrid.add(balanceInquiry, 2, 0);
	    
		Label historyLabel = new Label("------------(Transactions History)--------------");
		historyLabel.setMinSize(135, 15);
		historyLabel.setStyle("-fx-text-fill: grey;");
		
		Button previous = new Button("Previous");
		Button next = new Button("Next");
		GridPane historyGrid = new GridPane();
		historyGrid.setPadding(new Insets(10,0,0,0));
		historyGrid.setHgap(130); 
		historyGrid.add(previous, 0, 0);
		historyGrid.add(next, 1, 0);
		
		VBox vbox = new VBox();
		vbox.setSpacing(1);   
        vbox.setPadding(new Insets(5,20,20,20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(100, 100);
		vbox.getChildren().addAll(title, separator, field, message, balanceLabel, balanceGrid, historyLabel, historyGrid);
		
		diposit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				windowsInterface.openTransactionWindow(true);
			}
		});
		withdraw.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				windowsInterface.openTransactionWindow(false);
			}
		});
		balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				field.setText("Balance: "+Double.toString(card.balanceInquiry()));
				history.resetNavigation();
				history.addBalanceInquiry(Double.toString(card.balanceInquiry()));
				history.getPrevious();
			}
		});
		previous.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				field.setText(history.getPrevious());
			}
		});
		next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				field.setText(history.getNext());
			}
		});
		
		scene = new Scene(vbox);
	}
	
	public Scene getScene(int type, String value) {
		if(type == 0) field.setText("Choose an option");
		else if(type == 1) field.setText("Successfully deposited "+value);
		else if(type == 2) field.setText("Successfully withdrawn "+value);
		return this.scene;
	}
}
