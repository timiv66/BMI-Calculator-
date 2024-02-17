package bmi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BMI_FX extends Application{
	Font titleFont = new Font("Impact",19);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		// TODO Auto-generated method stub
		Pane p1 = new Pane();
		Scene t = new Scene(p1,420,350);
		t.setRoot(calc(t));
		mainStage.setScene(t);
		mainStage.show();
		mainStage.setTitle("BMI Calculator");
	}
	
	public Pane calc(Scene t) {
		//Title
		Label titleText = new Label("Welcome to BMI Calculator");
		titleText.setFont(titleFont);
		titleText.setTranslateX(3);
		
		//Measurement system label
		Label mesSysLbl = new Label("Measurement System:");
		mesSysLbl.setTranslateY(30);
		
		//Drop down for measurement system
		ChoiceBox<String> mesCb = new ChoiceBox<String>();
		mesCb.getItems().add("Imperial");
		mesCb.getItems().add("Metric");
		mesCb.setTranslateX(120);
		mesCb.setTranslateY(27);
		
		
		Pane calcPane = new Pane();
		calcPane.getChildren().addAll(titleText,mesSysLbl,mesCb);
		return calcPane;
	}

}
