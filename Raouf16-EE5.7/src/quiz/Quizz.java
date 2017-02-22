package quiz;

import intPackage.IntQuestions;
import questionsImplementation.AdditionQuestion;
import questionsImplementation.SubstractionQuestion;
import textLibrary.TextIO;

/**
 * This class builds a quizz, administers it and gives user a grade
 *
 */
public class Quizz {
	private static IntQuestions[] questions;  // The questions for the quiz

    private static int[] userAnswers;   // The user's answers to the ten questions.
    
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the addition quiz!");
        System.out.println();
        createQuiz();
        administerQuiz();
        gradeQuiz();
    }
    
    
    /**
     * Creates the array of objects that holds the quiz questions
     * Substraction or addition is a random choice
     */
    private static void createQuiz() {
        questions = new IntQuestions [10];
        for ( int i = 0; i < 7; i++ ) {
        	int a = (int)(Math.random()+0.5);
        	if (a == 0) {
        		questions[i] = new SubstractionQuestion();
        	}
        	else {
        		questions[i] = new AdditionQuestion();
        	}
        }
        
      questions[7] = new IntQuestions() {
            @Override
			public String getQuestion() {
                return "How many specialization are there in Dauphine's Master MIAGE?";
            }
            @Override
			public int getCorrectAnswer() {
                return 3;
            }
      };
      questions[8] = new IntQuestions() {
            @Override
			public String getQuestion() {
                return "In what year did the First World War begin?";
            }
            @Override
			public int getCorrectAnswer() {
                return 1914;
            }
      };
      questions[9] = new IntQuestions() {
            @Override
			public String getQuestion() {
                return "What is the answer to the ultimate question " +
                              "of life, the universe, and everything?";
            }
            @Override
			public int getCorrectAnswer() {
                return 42;
            }
      };
    }
    
    
    /**
     * Asks the user each of the ten quiz questions and gets the user's answers.
     * The answers are stored in an array, which is created in this subroutine.
     */
    private static void administerQuiz() {
        userAnswers = new int[10];
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("Question %2d:  %s ",
                                  questionNum, questions[i].getQuestion());
            userAnswers[i] = TextIO.getlnInt();
        }
    }
    
    
    /**
     * Shows all the questions, with their correct answers, and computes a grade
     * for the quiz.  For each question, the user is told whether they got
     * it right.
     */
    private static void gradeQuiz() {
        System.out.println();
        System.out.println("Here are the correct answers:");
        int numberCorrect = 0;
        int grade;
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("   Question %2d:  %s  Correct answer is %d  ",
                questionNum, questions[i].getQuestion(), questions[i].getCorrectAnswer());
            if ( userAnswers[i] == questions[i].getCorrectAnswer() ) {
                System.out.println("You were CORRECT.");
                numberCorrect++;
            }
            else {
                System.out.println("You said " + userAnswers[i] + ", which is INCORRECT.");
            }
        }
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("You got " + numberCorrect + " questions correct.");
        System.out.println("Your grade on the quiz is " + grade);
        System.out.println();
    }
}

