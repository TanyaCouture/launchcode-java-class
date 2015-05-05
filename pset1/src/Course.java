/**
 * Created by tanyacouture on 4/29/15.
 */

public class Course{
    private String CourseName;
    private int CourseNumber;
    private int Credits;
    private int SeatRemain;
    private int TotalSeats;
    private Student Rosters[];

    public Course(String CourseName, int CourseNumber, int Credits, int SeatRemain, int TotalSeats, Student Rosters[]){
        this.CourseName = CourseName;
        this.CourseNumber = CourseNumber;
        this.Credits = Credits;
        this.SeatRemain = SeatRemain;
        this.TotalSeats = TotalSeats;
        this.Rosters = new Student[TotalSeats];
    }

    public int getSeatRemain(){
      return this.SeatRemain;
    }

    public Student getRosters(){
        return this.Rosters[SeatRemain];
    }

    public String toString(){
        return this.CourseNumber + " " + this.Credits;
    }

    public boolean addStudent(Student newStudent){
        // while there are seats remaining
        while(this.SeatRemain > 0){
                // iterate through roster
                for(int i = (TotalSeats-SeatRemain); i < TotalSeats; i++){
                    // if the student is already in the roster
                    if (this.Rosters[i] != newStudent){
                        this.Rosters[i] = newStudent;
                        // update SeatRemain
                        this.SeatRemain = this.SeatRemain - 1;
                        return true;
                    }
                }
        }
        return false;
    }

    public void printRoster(){
        for(Student student : this.Rosters){
            System.out.println(student.getName());
        }
    }

    public float averageGPA(){
        float sumGPA = 0f;
        float count = 0f;

        for(Student student : this.Rosters){
            sumGPA = sumGPA + student.getGPA();
            count++;
        }
        sumGPA = Math.round(sumGPA*(float)10.00)/(float)10.00;
        return sumGPA /count;
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

        // print roster
        r1.printRoster();

        // print average GPA for course
        System.out.println(r1.averageGPA());

    }


}
