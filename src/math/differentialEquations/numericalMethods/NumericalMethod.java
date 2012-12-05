package math.differentialEquations.numericalMethods;

public abstract class NumericalMethod {
	boolean verbose;
	MathEval math = new MathEval();
	String exp;
	double initialX, x, targetX;
	double initialY, y;
	
	public NumericalMethod(){
		setExp("0");
		setInitialX(0);
		setX(getInitialX());
		setTargetX(0);
		setInitialY(0);
		setY(getInitialY());
	}
	
	public NumericalMethod(String expression, double initialX, double targetX, double initialY){
		setExp(expression);
		setInitialX( initialX );
		setX( getInitialX() );
		setTargetX( targetX );
		setInitialY( initialY );
		setY(getInitialY());
	}
	
	public NumericalMethod(String expression, double initialX, double targetX, double initialY, boolean verbose){
		setExp(expression);
		setInitialX( initialX );
		setX( getInitialX() );
		setTargetX( targetX );
		setInitialY( initialY );
		setY(getInitialY());
		setVerbose(verbose);
	}
	//============================================================================
	// Set Functions
	//============================================================================
	public void setExp(String exp){
		this.exp = exp;
	}
	
	public void setInitialX(double x){
		this.initialX = x;
	}
	
	public void setX(double x){
		this.x = x; 
	}
	
	public void setTargetX(double target){
		this.targetX = target;
	}
	
	public void setInitialY(double y){
		this.initialY = y;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setVerbose(boolean v){
		this.verbose = v;
	}
	
	//============================================================================
	// Get Functions
	//============================================================================
	public String getExp(){
		return this.exp;
	}
	
	public double getInitialX(){
		return this.initialX;
	}
	
	public double getX(){
		return this.x; 
	}
	
	public double getTargetX(){
		return this.targetX;
	}
	
	public double getInitialY(){
		return this.initialY;
	}
	
	public double getY(){
		return this.y;
	}
	
	public boolean getVerbose(){
		return this.verbose;
	}

	//============================================================================
	// Other Functions
	//============================================================================
	public double dYdX(String function, double x, double y){
		math.setVariable("x", x);
		math.setVariable("y", y);
		return math.evaluate(function);
	}
	
	public abstract Point approx();
}
