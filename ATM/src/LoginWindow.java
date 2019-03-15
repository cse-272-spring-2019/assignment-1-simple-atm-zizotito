import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginWindow {
	Card card;
	Stage mainStage;
	Scene scene;
	WindowsInterface windowsInterface;
	MenuWindow menuWindow;

	public LoginWindow(WindowsInterface windowsInterface, Stage mainStage, Card card) {
		this.windowsInterface = windowsInterface;
		this.mainStage = mainStage;
		this.card = card;
	}
	
	public void loadScene() {
		Label title = new Label("Login");
		title.setAlignment(Pos.CENTER);
		title.setStyle("-fx-font-size: 20;");
		
		Label separator = new Label("---------------------------------");
		
		Label field = new Label("Insert card number");
		field.setMinSize(145, 25);
		field.setStyle("-fx-background-color: white;-fx-text-fill: grey;");
		
		Label message = new Label();
		message.setMinSize(135, 15);
		message.setStyle("-fx-text-fill: red;-fx-font-size: 10;");
		
		Button[] numb = new Button[12];
		for( int i=0; i<10; i++ ) {
			numb[i] = new Button(Integer.toString(i));
			numb[i].setMinSize(45, 25);
		}
		numb[10] = new Button("Clear");
		numb[10].setMinSize(45, 25);
		numb[11] = new Button("Enter");
		numb[11].setFont(new Font("",12));
		numb[11].setMinSize(45, 25);
		
		GridPane grid = new GridPane();
		grid.setVgap(5); 
	    grid.setHgap(5); 
		for( int i=0,j,k=-1; i<9; i++ ) {
			j=i%3;
			grid.add(numb[i+1], j, (i%3)==0?(++k):k);
		}
		grid.add(numb[10], 0, 3);
		grid.add(numb[0], 1, 3);
		grid.add(numb[11], 2, 3);
		
		VBox vbox = new VBox();
		vbox.setSpacing(5);   
        vbox.setPadding(new Insets(5,20,20,20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(100, 100);
		vbox.getChildren().addAll(title, separator, field, message, grid);
		
		numb[11].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if( card.checkCardNumber(field.getText()) ) windowsInterface.openMenuWindow(0,null);
				else message.setText("(invalid card number)");
			}
		});
		numb[10].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if(field.getText().length() == 1 || (field.getText()).contains("Insert")) field.setText("Insert card number");	
				else field.setText(field.getText().substring(0, field.getText().length()-1));
			}
		});
		numb[0].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(0));	
				else field.setText(field.getText() + Integer.toString(0));
			}
		});
		numb[1].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(1));	
				else field.setText(field.getText() + Integer.toString(1));
			}
		});
		numb[2].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(2));	
				else field.setText(field.getText() + Integer.toString(2));
			}
		});
		numb[3].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(3));	
				else field.setText(field.getText() + Integer.toString(3));
			}
		});
		numb[4].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(4));	
				else field.setText(field.getText() + Integer.toString(4));
			}
		});
		numb[5].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(5));	
				else field.setText(field.getText() + Integer.toString(5));
			}
		});
		numb[6].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(6));	
				else field.setText(field.getText() + Integer.toString(6));
			}
		});
		numb[7].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(7));	
				else field.setText(field.getText() + Integer.toString(7));
			}
		});
		numb[8].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(8));	
				else field.setText(field.getText() + Integer.toString(8));
			}
		});
		numb[9].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).equals("Insert card number")) field.setText(Integer.toString(9));	
				else field.setText(field.getText() + Integer.toString(9));
			}
		});
		
		scene = new Scene(vbox);
	}
	
	public Scene getScene() {
		return this.scene;
	}
}
