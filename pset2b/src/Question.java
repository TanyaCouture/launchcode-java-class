/**
 * Created by tanyacouture on 5/5/15.
 */
public class Question{
    private String query;
    private String answer;

    public Question(String query, String answer) {
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
        if(inputAnswer.equals(this.answer)){
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
