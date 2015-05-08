import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;


/**
 * Created by tanyacouture on 5/5/15.
 */
public class questionTest extends TestCase {
    @Test
    public void testQuestionInit() {
        Question q = new Question("2 + 2 = ", "4");
        assertEquals("2 + 2 = ", q.getQuery());
        assertEquals("4", q.getAnswer());
    }

    // test fillin input and output
    public void testFillinInit() {
        FillinBlank q1 = new FillinBlank("Two plus __ is four", "two");
        assertEquals("Two plus __ is four", q1.getQuery());
        assertEquals("two", q1.getAnswer());
    }

    // test numeric input and output
    public void testNumericInit(){
        NumericQuestions q2 = new NumericQuestions("2 + 2 = ", "4");
        assertEquals("2 + 2 = ", q2.getQuery());
        assertEquals("4", q2.getAnswer());
    }

    // test Multiple Choice input and output
    public void testMultiplechoiceInit(){
        String[] choices = {"a. 3", "b. 4", "c. 5", "d. 6"};
        MultipleChoice q3 = new MultipleChoice("2 + 2 = ", "b. 4", choices);
        assertEquals("2 + 2 = ", q3.getQuery());
        assertEquals("b. 4", q3.getAnswer());
    }

    public void testCheckAnswer(){
        // check numeric answer
        Question q = new Question("2 + 2 = ", "4");
        assertEquals(true, q.checkAnswer("4"));
        assertEquals(false, q.checkAnswer("5"));

        // check Fillin answer
        FillinBlank q1 = new FillinBlank("Two plus __ is four", "two");
        assertEquals(true, q1.checkAnswer("two"));
        assertEquals(false, q1.checkAnswer("three"));

        // MultipleChoice answer
        String[] choices = {"a. 3", "b. 4", "c. 5", "d. 6"};
        MultipleChoice q3 = new MultipleChoice("2 + 2 = ", "b. 4", choices);
        assertEquals(true, q3.checkAnswer("b. 4"));
        assertEquals(false, q3.checkAnswer("c. 5"));

        // MultipleChoice, more that one answer
        choices = new String[]{"a. 3 + 3 = ", "b. 2 + 2 = ", "c. 2 * 2 = ", "d. 3 * 3 = "};
        String answers = "b. 2 + 2 = c. 2 * 2 = ";
        String wrongAnswers = "a. 3 + 3 = d. 3 * 3 = ";
        MultiplemultipleChoice q4 = new MultiplemultipleChoice("How many of the following give the following answer: 4", "b. 2 + 2 = ", answers, choices);
        assertEquals(true, q4.checkAnswer(answers));
        assertEquals(false, q4.checkAnswer(wrongAnswers));
    }
}
