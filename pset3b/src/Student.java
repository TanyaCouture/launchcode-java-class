/**
 * Created by tanyacouture on 4/29/15.
 */

public class Student {
    private String FirstName;
    private String LastName;
    public int StudentID;
    private int Credits;
    private int Quality_score;
    private float GPA;

    //Constructor
    public Student(String FirstName, String LastName, int StudentID){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.StudentID = StudentID;
        this.Credits = 0;
        this.Quality_score = 0;
        this.GPA = 0.00f;
    }

    //Constructor
    Student(String FirstName, String LastName, int StudentID, int Credits, float GPA){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.StudentID = StudentID;
        this.Credits = Credits;
        this.GPA = GPA;
    }

    //Constructor
    Student(int StudentID, int Credits, int Quality_score, float GPA){
        if(GPA < 0){
            throw new IllegalArgumentException("GPA cannot be a negative number.");
        }

        if(Credits < 0){
            throw new IllegalArgumentException("Credits cannot be a negative number.");
        }

        this.StudentID = StudentID;
        this.Credits = Credits;
        this.Quality_score = Quality_score;
        this.GPA = GPA;
    }

    public String getName(){
        return FirstName + " " + LastName;
    }

    public int getStudentID(){

        return this.StudentID;
    }

    public int getCredits(){
        return this.Credits;
    }

    public float getGPA(){
        return this.GPA;
    }

    public String toString(){
        return this.FirstName + " " + this.LastName + " " + this.StudentID;
    }

    public String getClassStanding(){
        // Get the number of credits

        // if there are few than 30 credits, return freshman
        if(this.Credits < 30){
            return "freshman";
        }
        // if between 30 and 60 credits, return sophomore
        else if(this.Credits >= 30 && this.Credits < 60){
            return "sophomore";
        }
        // if there are 60 - 90, return junior
        else if(this.Credits >= 60 && this.Credits < 90){
            return "junior";
        }
        // more than 90, return senior
        else if(this.Credits > 90){
            return "senior";
        }
        return null;
    }

    //takes int course grade and credits
    public float submitGrade(int grade, int crs_credits){
        int new_qualScore;
        // Calculate GPA:course credits*grade=quality score; sum of quality scores/total student credits
        // takes in new grade and number of credits for the course

        // multiply the new grade and number of credits to get quality score
        new_qualScore = grade * crs_credits;

        // add new quality score to old quality score
        this.Quality_score = new_qualScore + this.Quality_score;

        // add crs_credits to Credits
        this.Credits = crs_credits + this.Credits;

        // GPA = quality score/credits
        this.GPA = (float)this.Quality_score / this.Credits;

        // update GPA and quality score
        return this.GPA;
    }

    public double computeTuition(){
        int sem_credits;
        double sem_tuition;
        int left_credits;
        double left_tuition;
        double full_tuition = 0;

        if(this.Credits >= 15){
            sem_credits = this.Credits/15;
            sem_tuition = sem_credits*20000;

            left_credits = this.Credits%15;
            left_tuition = left_credits*1333;
            // students pay $1333 per credit for credits above 15
            full_tuition = sem_tuition + left_tuition;
        }
        return full_tuition;
    }

    public Student createLegacy(Student c){
        int newCredits;
        // generate random ID
        int ID = (int)(Math.random()*899999)+100000;

        // compare Credits to use the larger number
        if(this.Credits >= c.getCredits()) {
            newCredits = this.Credits;
        }
        else newCredits = c.getCredits();

        // average GPA of 2 parents
        float avg_GPA = (this.GPA + c.getGPA())/2;

        String par1 = this.getName();
        String par2 = c.getName();

        return new Student(par1, par2, ID, newCredits, avg_GPA);
    }

    //Main
    public static void main(String args[]) {
        // create students for class
        Student s8 = new Student("Doug", "Shook", 111111, 90, 3.14f);
        Student s9 = new Student("Pat", "Book", 111112, 92, 3.75f);
        // create class
        Course r1 = new Course("Math", 1234, 4, 2, 2, null);
        // add students to course
        r1.addStudent(s8);
        r1.addStudent(s9);

        // print class standing
        System.out.println(s9.getClassStanding());

        // print legacy student
        System.out.println(s8.createLegacy(s9));
    }
}


