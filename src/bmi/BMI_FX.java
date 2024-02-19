package bmi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BMI_FX extends Application{
	Font titleFont = new Font("Stencil",19);
	Font txtFont = new Font("Georgia",15);
	Font errorFont = new Font("Times New Roman",12);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		// TODO Auto-generated method stub
		Pane p1 = new Pane();
		Scene t = new Scene(p1,285,350);
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
		mesSysLbl.setFont(txtFont);
		mesSysLbl.setTranslateX(3);
		mesSysLbl.setTranslateY(30);
		
		//Drop down for measurement system
		ChoiceBox<String> mesCb = new ChoiceBox<String>();
		mesCb.getItems().add("Imperial");
		mesCb.getItems().add("Metric");
		mesCb.setTranslateX(153);
		mesCb.setTranslateY(28);
		
		//Height label and Text Field
		Label heightLbl = new Label("Height(in/m):");
		heightLbl.setTranslateX(3);
		heightLbl.setTranslateY(63);
		heightLbl.setFont(txtFont);
		
	    TextField heightTxtF = new TextField();
	    heightTxtF.setTranslateX(100);
	    heightTxtF.setTranslateY(60);
		
	    //Weight label and Text Field 
	    Label weightLbl = new Label("Weight(lbs/kg):");
	    weightLbl.setTranslateX(3);
	    weightLbl.setTranslateY(96);
	    weightLbl.setFont(txtFont);
	    
	    TextField weightTxtF = new TextField();
	    weightTxtF.setTranslateX(110);
	    weightTxtF.setTranslateY(93);
	    
	    //Error Message
	    Text errorTxt = new Text("Please only enter valid numbers and fill in all blanks");
	    errorTxt.setFill(Color.RED);
	    errorTxt.setX(7);
	    errorTxt.setY(135);
	    errorTxt.setFont(errorFont);
	    errorTxt.setVisible(false);
	    
	    //BMI Text
	    Text bmiTxt = new Text("");
	    bmiTxt.setX(3);
	    bmiTxt.setY(185);
	    
	    //Weight Class Text
	    Text classTxt = new Text("");
	    classTxt.setX(3);
	    classTxt.setY(203);
	    
	    //Calc Button
	    Button calcBtn = new Button("Calculate BMI");
	    calcBtn.setTranslateX(95);
	    calcBtn.setTranslateY(140);
	    
	    calcBtn.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					//Creation of the Person object
					Person user = new Person();
					user.setHeight(Double.parseDouble(heightTxtF.getText()));
					user.setWeight(Double.parseDouble(weightTxtF.getText()));
					
					//Determine which measurement system to use
					if(mesCb.getValue().matches("Imperial")) {
						bmiTxt.setText("Your Body Mass Index(BMI) is " + String.format("%.1f",user.calcInBMI()));
					}else if(mesCb.getValue().matches("Metric")) {
						bmiTxt.setText("Your Body Mass Index(BMI) is " + String.format("%.1f",user.calcMBMI()));
					}
					
					//Determine weight class
					user.calcStatus();
					classTxt.setText("You are " + user.getStatus());
	
				}catch(Exception e) {
					errorTxt.setVisible(true);
				}
				
			}
	    	
	    });
	    
		Pane calcPane = new Pane();
		calcPane.getChildren().addAll(titleText,mesSysLbl,mesCb,heightLbl,heightTxtF,weightLbl,weightTxtF,errorTxt,calcBtn,bmiTxt,classTxt);
		return calcPane;
	}

}
