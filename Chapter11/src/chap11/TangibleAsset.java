package chap11;

public class TangibleAsset extends Asset implements Thing {
	double weight;
	String color;
	
	public TangibleAsset(String name, int price, String color) {
		super(name, price);
		this.color = color;
	}
	
	public String getColor() { return this.color; }
	public double getWeight() { return this.weight; }
	public void setWeight(double weight) { this.weight = weight; }	
}
