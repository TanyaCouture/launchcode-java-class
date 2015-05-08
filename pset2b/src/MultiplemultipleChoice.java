/**
 * Created by tanyacouture on 5/6/15.
 */
public class MultiplemultipleChoice extends Question {
    String answer;
    String query;
    private String answers;
    private String choices[];

    public MultiplemultipleChoice(String query, String answer, String answers, String choices[]) {
        super(query, answer);
        this.query = query;
        this.answers = answers;
        this.choices = choices;
    }

    public String getQuery() {
        return this.query;
    }

    public String getAnswers() {
        return this.answers;
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
        // concantenate "" to inputAnswer. There's got to be a better way of doing this.

        // convert this.getAnswers() to a string
        // if the user answer matches the correct answer, print you got the correct answer
        if(inputAnswer.equals(this.getAnswers())){
        //if(Arrays.equals(inputAnswers, this.getAnswers())){
            System.out.println("Congrats, you answered correctly!");
            return true;
        }

        else{
            System.out.println("Incorrect answer.");
            return false;
        }
    }
}
