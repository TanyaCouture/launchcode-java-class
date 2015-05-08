import java.util.Scanner;

/**
 * Created by tanyacouture on 5/6/15.
 */
public class Quiz {

    private Question[] questions;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public static void main(String[] args) {
        NumericQuestions q = new NumericQuestions("2 + 2 = ", "4");
        FillinBlank q1 = new FillinBlank("Two plus __ is four", "two");
        String[] choices = {"a. 3", "b. 4", "c. 5", "d. 6"};
        MultipleChoice q2 = new MultipleChoice("2 + 2 = ", "b. 4", choices);
        String[] choices1 = new String[]{"a. 3 + 3 = ", "b. 2 + 2 = ", "c. 2 * 2 = ", "d. 3 * 3 = "};
        //String[] answers = {"b. 2 + 2 = ", "c. 2 * 2 ="};
        String answers = "b. 2 + 2 = c. 2 * 2 =";
        MultiplemultipleChoice q3 = new MultiplemultipleChoice("How many of the following give the answer 4?", "b. 2 + 2 = ", answers, choices1);

        Question [] mathTests = {q, q1, q2, q3};


        // for each mathTest in mathTests
        for(int i = 0; i < mathTests.length; i++) {
            mathTests[i].printQuery();


                // get user input
                Scanner in = new Scanner(System.in);
                String userInput = in.nextLine();
                mathTests[i].checkAnswer(userInput);
            }
        }
    }
