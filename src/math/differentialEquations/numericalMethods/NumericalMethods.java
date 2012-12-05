package math.differentialEquations.numericalMethods;

import java.util.Scanner;

/**
 * Contains Numerical Methods for solving Differential Equations
 * @author James Michael Monroe
 *
 */
public class NumericalMethods {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int choice = 0;
				
		do{
			try{
				choice = Menu();
			}catch(Exception e){
				System.err.println("Caught " + e.getClass() + ": "+  e.getMessage());
			}
		}while(choice != 0);

	}
	
	/**
	 * @param none
	 * @return int : The integer corresponding to which menu element they selected.
	 */
	public static int Menu(){
		int method;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please choose the numerical method you would like to use.");
		System.out.println("1: Euler");
		System.out.println("2: ImprovedEuler");
		System.out.println("3: RungeKutta");
		System.out.println("0: Exit");
		
		method = input.nextInt();
		
		switch(method){
			case 1:
				Euler(); 
				return 1;
			case 2:
				ImprovedEuler();
				return 2;
			case 3:
				RungeKutta();
			    return 3;
			case 0:
				System.out.println("Exiting.");
				return 0;
			default: 
				System.out.println("That choice is not available. Please make a new selection.");
				throw new IllegalArgumentException("Invalid choice made during method selection.");
		}
	}
	
	public static void notImplemented(){
		System.out.println("This method has not been implemented yet");
	}
	
	public static void Euler(){
		Scanner input = new Scanner(System.in);
		
		//String function, double initialX, double targetX, double initialY, int steps
		System.out.println("**************** EULER'S METHOD *******************");
		
		System.out.println("Please enter the function of x and y.");
		String s = input.nextLine();
		
		System.out.println("Please enter x0.");
		double initialX = input.nextDouble();
		
		System.out.println("Please enter the target value of x.");
		double targetX = input.nextDouble();
		
		System.out.println("Please enter the known value of y(x0).");
		double initialY = input.nextDouble();
		
		System.out.println("Please enter the number of steps desired.");
		int steps = input.nextInt();
		
		Euler euler = new Euler(s, initialX, targetX, initialY, steps);
		
		System.out.println("Run in verbose mode? true or false");
		boolean verbose = input.nextBoolean(); 
		euler.setVerbose(verbose);
		
		System.out.println( euler.approx() );
	}
	
	public static void ImprovedEuler(){
		Scanner input = new Scanner(System.in);
		
		//String function, double initialX, double targetX, double initialY, int steps
		System.out.println("************ IMPROVED EULER'S METHOD ***************");
		
		System.out.println("Please enter the function of x and y.");
		String s = input.nextLine();
		
		System.out.println("Please enter x0.");
		double initialX = input.nextDouble();
		
		System.out.println("Please enter the target value of x.");
		double targetX = input.nextDouble();
		
		System.out.println("Please enter the known value of y(x0).");
		double initialY = input.nextDouble();
		
		System.out.println("Please enter the number of steps desired.");
		int steps = input.nextInt();
		
		ImprovedEuler impEuler = new ImprovedEuler(s, initialX, targetX, initialY, steps);
		
		System.out.println("Run in verbose mode? true or false");
		boolean verbose = input.nextBoolean();
		impEuler.setVerbose(verbose);

		
		System.out.println( impEuler.approx() );
	}
	
	public static void RungeKutta(){
		Scanner input = new Scanner(System.in);
		
		//String function, double initialX, double targetX, double initialY, int steps
		System.out.println("************** RUNGE-KUTTA METHOD *****************");
		
		System.out.println("Please enter the function of x and y.");
		String s = input.nextLine();
		
		System.out.println("Please enter x0.");
		double initialX = input.nextDouble();
		
		System.out.println("Please enter the target value of x.");
		double targetX = input.nextDouble();
		
		System.out.println("Please enter the known value of y(x0).");
		double initialY = input.nextDouble();
		
		System.out.println("Please enter the number of steps desired.");
		int steps = input.nextInt();
		
		RungeKutta rungeKutta = new RungeKutta(s, initialX, targetX, initialY, steps);
		
		System.out.println("Run in verbose mode? true or false");
		boolean verbose = input.nextBoolean();
		rungeKutta.setVerbose(verbose);

		
		System.out.println( rungeKutta.approx() );
	}
}