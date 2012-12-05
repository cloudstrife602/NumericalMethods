package math.differentialEquations.numericalMethods;

public class Point {
	double x, y;
	
	public Point(){
		setX(0);
		setY(0);
	}
	
	public Point(double x, double y){
		setX(x);
		setY(y);
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public String toString(){
		return "(" + getX() + "," + getY() + ")";
	}
}
