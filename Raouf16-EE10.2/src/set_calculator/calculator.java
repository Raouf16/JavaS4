package set_calculator;
import java.util.TreeSet;
import text_library.TextIO;

/**
 * This class asks for two sets A and B and applies three different kind of operations on them.
 * (Union, Difference and Intersection)
 */
public class calculator {
	
	/**
	 * Main function calls the display function,
	 * manage the number of lines and the end of the program.
	 * User can quit the program when he wants by pressing return.
	 * @throws Exception any exceptions launched during the program execution
	 */
	public static void main(String[] args) {

		displayInfo();
		while(true){
			TextIO.skipBlanks();
			if(TextIO.peek() == '\n'){
				break;
			}
			try{
				parseLineInSets();	
			}catch(Exception e){
				System.out.println("Error: " + e.getMessage());
			}
			TextIO.getln();
			
		}
		TextIO.putln("--------------END-------------");
	}
	
	/**
	 * Parses the input in Set A, operator and Set B
	 * then launches the operation on the sets.
	 * @throws IllegalArgumentException when the operator is not found
	 */
	public static void parseLineInSets(){
		TreeSet<Integer> A = new TreeSet<>();
		TreeSet<Integer> B = new TreeSet<>();
		char operator;
		
		A = createSet();
		TextIO.skipBlanks(); //delete blanks until operator character
		
		if(TextIO.peek() == '+' ||	
		   TextIO.peek() == '-'	||	
		   TextIO.peek() == '*'){
			operator = TextIO.peek();
		}else{
			throw new IllegalArgumentException("There is no operator");
		}
		 TextIO.getAnyChar(); //save the operator sign
		 TextIO.skipBlanks(); //delete blanks until '[' character
		 B = createSet(); 
		 setCalculation(A,B,operator);
	}
	
	/**
	 * Applies the operator's function on the sets and print the result
	 * @param A the first set parse from the input line
	 * @param B the second set parse from the input line
	 * @param operator the character between the two sets
	 * @throws IllegalArgumentException when the operator is not in ('+','-','*')
	 */
	public static void setCalculation(TreeSet<Integer> A, TreeSet<Integer>B, char operator){

		 switch(operator) {
         case '+' : //Union
        	 A.addAll(B);
            break;
         case '-' : //Difference
        	  A.removeAll(B);
        	 break;
         case '*' : // Intersection
        	 A.retainAll(B);
             break;
         default :
        	 throw new IllegalArgumentException("There is no operator");
		 }
		 System.out.println("----------------------------------------");
		 System.out.println("Result : " + A);
	}
	
	
	/**
	 * Searches for a set and builds it when user input is valid
	 * @return a valid set of type [1,2,3] (TreeSet<Integer>
	 * @throws IllegalArgumentException if the set doesn't begin with '['
	 * @throws IllegalArgumentException if the next character after '[' 
	 * is not a number or a right square bracket
	 * @throws IllegalArgumentException if there is at less one negative integer
	 * @throws IllegalArgumentException if the set is not ended correctly
	 */
	public static TreeSet<Integer> createSet(){
		
		TreeSet<Integer> set = new TreeSet<>();
		
		if(TextIO.peek() != '[')   //search for '['
			throw new IllegalArgumentException("A set begins with \'[\'");
		TextIO.getAnyChar();       // get the '[' char
		TextIO.skipBlanks();
		if(TextIO.peek() == ']'){  //case of a void set
			TextIO.getAnyChar();
			return set;
		}
		while(true){	
			int number;
			if(! Character.isDigit(TextIO.peek()))
				throw new IllegalArgumentException("Number expected");
			if(TextIO.peek() < 0 )
				throw new IllegalArgumentException("A set must contain positive numbers");
			number = TextIO.getInt(); 
	        set.add(number);
	        TextIO.skipBlanks();
	        if(TextIO.peek() == ',')
				TextIO.getAnyChar();
	        else if(TextIO.peek() == ']'){
				TextIO.getAnyChar();
				break;
			}else
				throw new IllegalArgumentException("Not a set, expeced a comma or a right square bracket");
		}	
		return set;	
	}
	
	/**
	 * This procedure displays the rules of the Sets Calculator
	 */
	public static void displayInfo(){
		TextIO.putln("-----------------Sets of Non Negative Integers Calculator----------------");
		TextIO.putln("Please enter two sets separated by an operator ex : [1,2,3] + [4,5,6]    ");
		TextIO.putln("-------------------------------------------------------------------------");
		TextIO.putln("Available Operations : ");
		TextIO.putln(" - : Difference");
		TextIO.putln(" + : Union");
		TextIO.putln(" * : Intersection");
		TextIO.putln("Press Return to quit");
	}
}// End class Calculator
