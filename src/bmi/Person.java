package bmi;

public class Person {
	private double height;
	private double weight;
	private double BMI;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBMI() {
		return BMI;
	}
	public void setBMI(double bMI) {
		BMI = bMI;
	}
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
		setBMI(BMI);
		return BMI;
 	}
	
	//Calculates BMI based off metric system
	public double calcMBMI() {
		double BMI;
		BMI = getWeight()/Math.pow(getHeight(), 2);
		setBMI(BMI);
		return BMI;
	}
	
	public String calcStatus() {
		String status = "";
		if(getBMI() <= 18.4) {
			setStatus("underweight");
			return status;
		}else if(getBMI() >= 18.5 && getBMI() <= 24.9) {
			setStatus("normal");
			return status;
		}else if(getBMI() >= 25.0 && getBMI() <= 39.9) {
			setStatus("overweight");
			return status;
		}else if(getBMI() >= 40.0) {
			setStatus("obese");
			return status;
		}
		
		return status;
	}
	

}
