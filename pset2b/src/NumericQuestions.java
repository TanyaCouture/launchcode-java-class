/**
 * Created by tanyacouture on 5/5/15.
 */
public class NumericQuestions extends Question {
    String query;
    String answer;

    public NumericQuestions(String query, String answer){
        super(query, answer);
        this.query = query;
        this.answer = answer;
    }

    public String getQuery() {
        return this.query;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void printQuery() {
            System.out.println(this.query);
        }

    public boolean checkAnswer(String inputAnswer) {
        // if the user answer matches the correct answer, print you got the correct answer
        if(new String(inputAnswer).equals(this.getAnswer())){
            System.out.println("Congrats, you answered correctly!");
            return true;
        }
        // else print you got the wrong answer
        else{
            System.out.println("Incorrect answer.");
            return false;
        }
    }
}
