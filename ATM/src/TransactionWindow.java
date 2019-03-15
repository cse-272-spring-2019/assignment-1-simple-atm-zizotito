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

public class TransactionWindow {
	Card card;
	History history;
	Stage mainStage;
	Scene scene;
	WindowsInterface windowsInterface;
	Label title;
	Label field;
	boolean type;

	public TransactionWindow(WindowsInterface windowsInterface, Stage mainStage, Card card, History history) {
		this.windowsInterface = windowsInterface;
		this.mainStage = mainStage;
		this.card = card;
		this.history = history;
	}
	
	public void loadScene() {
		title = new Label("*");
		title.setAlignment(Pos.CENTER);
		title.setStyle("-fx-font-size: 20;");
		
		Label separator = new Label("---------------------------------");
		
		field = new Label("Insert * amount");
		field.setMinSize(145, 25);
		field.setStyle("-fx-background-color: white;-fx-text-fill: grey;");
		
		Label message = new Label();
		message.setMinSize(135, 15);
		message.setStyle("-fx-text-fill: red;-fx-font-size: 9;");
		
		Button[] numb = new Button[12];
		for( int i=0; i<10; i++ ) {
			numb[i] = new Button(Integer.toString(i));
			numb[i].setMinSize(45, 25);
		}
		numb[10] = new Button("Clear");
		numb[10].setMinSize(45, 25);
		numb[11] = new Button(".");
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
		
		Button back = new Button("Back");
		Button enter = new Button("Enter");
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10,0,0,0));
	    grid2.setHgap(65); 
	    grid2.add(back, 0, 0);
	    grid2.add(enter, 1, 0);
	    
		VBox vbox = new VBox();
		vbox.setSpacing(5);   
        vbox.setPadding(new Insets(5,20,20,20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(100, 100);
		vbox.getChildren().addAll(title, separator, field, message, grid, grid2);
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				windowsInterface.openMenuWindow(0,null);
			}
		});
		enter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if((field.getText()).contains("Insert")) {
					message.setText("(amount must be greater than 0.0)");
					return;
				}
				boolean valid;
				if(type) {
					if(Double.parseDouble(field.getText()) > 0) {
						card.deposit(Double.parseDouble(field.getText()));
						history.resetNavigation();
						history.addDeposit(Double.toString(Double.parseDouble(field.getText())));
						message.setText("");
						windowsInterface.openMenuWindow(1,Double.toString(Double.parseDouble(field.getText())));
						history.getPrevious();
					}
					else message.setText("(amount must be greater than 0.0)");
				}
				else {
					if(Double.parseDouble(field.getText()) > 0) {
						valid = card.withdraw(Double.parseDouble(field.getText()));
						if(valid) {
							history.resetNavigation();
							history.addWithdraw(Double.toString(Double.parseDouble(field.getText())));
							message.setText("");
							windowsInterface.openMenuWindow(2,Double.toString(Double.parseDouble(field.getText())));
							history.getPrevious();
						}
						else message.setText("(insufficient balance)");
					}
					else message.setText("(amount must be greater than 0.0)");
					
				}
			}
		});
		numb[11].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(".");
				else if((field.getText()).contains(".")) return;
				else field.setText(field.getText() + ".");
			}
		});
		numb[10].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if(field.getText().length() == 1 || (field.getText()).contains("Insert")) {
					if(type) field.setText("Insert deposit amount");
					else field.setText("Insert withdrawal amount");
				}
				else field.setText(field.getText().substring(0, field.getText().length()-1));
			}
		});
		numb[0].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(0));	
				else field.setText(field.getText() + Integer.toString(0));
			}
		});
		numb[1].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(1));	
				else field.setText(field.getText() + Integer.toString(1));
			}
		});
		numb[2].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(2));	
				else field.setText(field.getText() + Integer.toString(2));
			}
		});
		numb[3].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(3));	
				else field.setText(field.getText() + Integer.toString(3));
			}
		});
		numb[4].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(4));	
				else field.setText(field.getText() + Integer.toString(4));
			}
		});
		numb[5].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(5));	
				else field.setText(field.getText() + Integer.toString(5));
			}
		});
		numb[6].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(6));	
				else field.setText(field.getText() + Integer.toString(6));
			}
		});
		numb[7].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(7));	
				else field.setText(field.getText() + Integer.toString(7));
			}
		});
		numb[8].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(8));	
				else field.setText(field.getText() + Integer.toString(8));
			}
		});
		numb[9].setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				message.setText("");
				if((field.getText()).contains("Insert")) field.setText(Integer.toString(9));	
				else field.setText(field.getText() + Integer.toString(9));
			}
		});
		
		scene = new Scene(vbox);
	}
	
	public Scene getScene(boolean type) {
		this.type = type;
		if(type) {
			title.setText("Deposit");
			field.setText("Insert deposit amount");
			return this.scene;
		}
		else {
			title.setText("Withdrawal");
			field.setText("Insert withdrawal amount");
			return this.scene;
		}
	}
}
