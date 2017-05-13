import java.util.ArrayList;
import java.util.Scanner;

/**
* The Set Operation Program allows users to execute simple commands via the console on arrays that will output said operations
*
* @author  Trey Foster
* @version 0.01
* @since   2017-03-26 
*/

public class SetOperation {
	
	private Set a, b; // Declare the two sets to be manipulated
	private boolean isOver = false; // Master Boolean to keep polling for input
	private Scanner sc; // Declare scanner object for input

	/**
	   * Construtor Method that initializes the program
	   */
	public SetOperation(){
		init(); // Initialize Variables
		loop(); // Main Program Loop
		System.exit(0); // Close program and dispose of resources
	}
	
	private void loop() {

		// Loop until program ends
		while(!isOver){
			
			String input = sc.nextLine(); // grab input 
			
			// if user types exit, then break the loop by setting the isOver master boolean to true
			if(input.contains("exit")){ 
				isOver = true;
			}else{
				// Take input and break up and execute
				String[] breakup = input.split(" ");
				if(breakup.length == 3){
					printOperation(breakup[0].charAt(0), breakup[2].charAt(0), breakup[1].charAt(0), input);
				}else if(breakup.length == 1){
					if(breakup[0].length() == 3){
						printOperation(breakup[0].charAt(0), breakup[0].charAt(1), breakup[0].charAt(2), input);
					}else{
						printOperation(' ', ' ', ' ', input);
					}
				}
				
			}
			
		}
		
	}

	/**
	   * This is the main method which makes use of addNum method.
	   * @param input1 The first variable of the operation
	   * @param input2 The second variable of the operation
	   * @param operation The operator for the operation
	   * @param command The unfiltered input from the user
	   * @return n/a
	   */
	private void printOperation(char input1, char input2, char operation, String command){
		switch(operation){
			case '+': 
				if(input1 == 'a' || input1 == 'A'){
					if(input2 == 'a' || input2 == 'A'){
						a.union(a.getSet());
					}else if(input2 == 'b' || input2 == 'B'){
						a.union(b.getSet());
					}
				}else if(input1 == 'b' || input1 == 'B'){
					if(input2 == 'a' || input2 == 'A'){
						b.union(a.getSet());
					}else if(input2 == 'b' || input2 == 'B'){
						b.union(b.getSet());
					}
				}
					break;
			case '^': 
				if(input1 == 'a' || input1 == 'A'){
					if(input2 == 'a' || input2 == 'A'){
						a.intersection(a.getSet());
					}else if(input2 == 'b' || input2 == 'B'){
						a.intersection(b.getSet());
					}
				}else if(input1 == 'b' || input1 == 'B'){
					if(input2 == 'a' || input2 == 'A'){
						b.intersection(a.getSet());
					}else if(input2 == 'b' || input2 == 'B'){
						b.intersection(b.getSet());
					}
				}
					break;
			case '-': 
				if(input1 == 'a' || input1 == 'A'){
					if(input2 == 'a' || input2 == 'A'){
						a.compliment(a.getSet());
					}else if(input2 == 'b' || input2 == 'B'){
						a.compliment(b.getSet());
					}
				}else if(input1 == 'b' || input1 == 'B'){
					if(input2 == 'a' || input2 == 'A'){
						b.compliment(a.getSet());
					}else if(input2 == 'b' || input2 == 'B'){
						b.compliment(b.getSet());
					}
				}
					break;
			default: System.out.println(command + ": Badly Formed Operation");
		}
	}

	private void init() {
		int[] one = {1,2,3,4}, two = {5,2,3,8}; // Initialize Two Arrays
		a = new Set(one); 
		b = new Set(two);
		
		System.out.println("Given these sets: A = " + a.toString() + " and B = " + b.toString()); // Display Sets
		System.out.println("Possible Operations: X + Y, X ^ Y, X - Y"); // Display possible operations 
		
		sc = new Scanner(System.in); // Initialize scanner object
		
	}

	public static void main(String[] args) {
		new SetOperation(); // Start Program
	}
	

}
