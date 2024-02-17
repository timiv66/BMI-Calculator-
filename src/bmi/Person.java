package bmi;

public class Person {
	private double height;
	private double weight;
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	Person(){
		
	}

	//Calculates BMI based off imperial system
	public double calcInBMI() {
		double BMI;
		BMI = 703 * (getWeight()/Math.pow(getHeight(), 2));
		return BMI;
 	}
	
	//Calculates BMI based off metric system
	public double calcMBMI() {
		double BMI;
		BMI = getWeight()/Math.pow(getHeight(), 2);
		return BMI;
	}

}
