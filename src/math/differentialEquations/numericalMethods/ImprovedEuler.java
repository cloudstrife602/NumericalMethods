package math.differentialEquations.numericalMethods;

/**
 * An improvement upon the approximation of Euler's method using the average of
 * the slope at the initial point, and the slope at the point given by Euler's method.
 */
public class ImprovedEuler extends Euler {
	
	public ImprovedEuler() {
		super();		
	}
	
	public ImprovedEuler(String function, double initialX, double targetX, double initialY, int steps){
		super(function, initialX, targetX, initialY, steps);
	}
	
	@Override
	public Point approx(){
		double slopeAvg, slopeStart, slopeEnd;
		double h = getStepSize();
		double x, tempX;
		double y, tempY;
		String function = getExp();
		
		for(int i = 0; i < getNumberOfSteps(); i++){
			//If the program is running in verbose mode we want to print each point along the way.
			if(getVerbose()){
				Point p = new Point(getX(), getY());
				System.out.println( p );
			}
			
			//Set some locals so they are easier to work with.
			x = getX();
			y = getY();
			
			//Get approximate position using Euler's method.
			slopeStart = dYdX(function, x, y);
			tempX = x + h;
			tempY = y + h * slopeStart;
			
			//Find the slope at the approximated position. 
			slopeEnd = dYdX(function, tempX, tempY);
			
			//Average the slope at the current point and the approximate point to get a better slope.
			slopeAvg = (slopeStart + slopeEnd) / 2;
			
			//Use the average slope to get a better approximation.
			setY(y + h * slopeAvg);
			setX(x + h);
		}
		
		return new Point( getX(), getY() );
	}
}
