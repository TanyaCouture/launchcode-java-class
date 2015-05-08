/**
 * Created by tanyacouture on 5/5/15.
 */
public class MultipleChoice extends Question{
    String query;
    String answer;
    private String choices[];

    public MultipleChoice(String query, String answer, String choices[]) {
        super(query, answer);
        this.query = query;
        this.answer = answer;
        this.choices = choices;
    }

    public String getQuery() {
        return this.query;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String[] getChoices(){
        return this.choices;
    }

    public void printQuery() {
        System.out.println(this.getQuery());
        if(this.choices != null){
            // iterate through array and print questions
            for(String choice : this.choices){
                System.out.println(choice);
            }
        }
    }

    public boolean checkAnswer(String inputAnswer) {
        // if the user answer matches the correct answer, print you got the correct answer
        if(inputAnswer.equals(this.getAnswer())){
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
