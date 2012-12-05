package math.differentialEquations.numericalMethods;
/**
 * Implements the Runge-Kutta method of approximation for f(x) given that dy/dx = f(x,y) is known.
 */
public class RungeKutta extends Euler {
	public RungeKutta() {
		super();		
	}
	
	public RungeKutta(String function, double initialX, double targetX, double initialY, int steps){
		super(function, initialX, targetX, initialY, steps);
	}
	
	@Override
	public Point approx(){
		double k1, k2, k3, k4;
		double h = getStepSize();
		double x;
		double y;
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
			
			//Calculate k1 => k4
			k1 = h * dYdX(function, x, y);
			k2 = h * dYdX(function, (x+(h/2)), (y+(k1/2)));
			k3 = h * dYdX(function, (x+(h/2)), (y+(k2/2)));
			k4 = h * dYdX(function, (x+h), (y+k3));
			
			//Approximate the new x and y
			setY(y + (k1 + 2*k2 + 2*k3 + k4) / 6);
			setX(x + h);
		}
		
		return new Point( getX(), getY() );
	}
}
