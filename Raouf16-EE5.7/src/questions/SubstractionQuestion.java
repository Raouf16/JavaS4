package questions;

import quiz.IntQuestions;

public class SubstractionQuestion implements IntQuestions {
	private int a, b;  // The numbers in the problem.

    public SubstractionQuestion() { // constructor
    	 
        do{
        	a = (int)(Math.random() * 50 + 1);
        	b = (int)(Math.random() * 50);
        }while(a<b);
        	
        
    }

    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a - b;
    }

}
