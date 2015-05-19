import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit tests for Student and Course
 * @author dshook
 *
 */
public class StudentAndCourseTest extends TestCase {
	@Test
	public void testStudentInit() {
		Student s = new Student("Doug", "Shook", 111111);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		//No credits, no GPA
		assertEquals(0.0, s.getGPA(), .01);
		assertEquals(0, s.getCredits());

		//Generate some random students, and test
		for (int i = 0; i < 20; ++i) {
			double a = (Math.random() * 5000);
			double b = (Math.random() * 5000);
			int c = (int) (Math.random() * 5000);
			Student s3 = new Student("" + a, "" + b, c);
			assertEquals(a + " " + b, s3.getName());
			assertEquals(0.0, s3.getGPA(), .01);
			assertEquals(0, s3.getCredits());
		}
	}

	//More tests should go here
	//testing Student class methods
	public void testStudentEntry() {
		// test tostring: make student with name and ID
		Student s = new Student("Doug", "Shook", 111111);
		assertEquals("Doug Shook 111111", s.toString());
		// test getclassStanding
		Student s1 = new Student("Doug", "Shook", 111111, 60, 0.00f);
		assertEquals("junior", s1.getClassStanding());

		// add test for exception
		//Student s8 = new Student("Doug", "Shook", 111111, -1, 0.00f);
		//assertEquals("Credits must be greater or equal to 0.", s8.getClassStanding());

		// test submitGrade
		Student s2 = new Student(111111, 0, 0, 0.00f);
		assertEquals(3.f, s2.submitGrade(3, 4));
		// test computetuition
		Student s3 = new Student(111111, 32, 0, 0);
		assertEquals(42666.d, s3.computeTuition());
		// test createLegacy
		Student s4 = new Student("Doug", "Shook", 111111, 90, 3.14f);
		Student s5 = new Student("Pat", "Book", 198765, 92, 3.75f);
		assertTrue(s4.createLegacy(s5).toString().matches("^Doug Shook Pat Book \\d{6}$"));
	}

	public void testCourseEntry() {
		// Test courses class
		// test toString
		Course a = new Course("Math", 1234, 4, 5, 5, null);
		assertEquals("1234 4", a.toString());

		// test addStudent
		Student s6 = new Student("Doug", "Shook", 111111);
		Course r = new Course("Math", 1234, 4, 1, 1, null);
		// test boolean
		assertEquals(true, r.addStudent(s6));
		// test remaining seats
		assertEquals(0, r.getSeatRemain());
		// try to add another student
		Student s7 = new Student("Pat", "Book", 111112);
		assertEquals(false, r.addStudent(s7));

		// test GPA's in class
		// create students for class
		Student s8 = new Student("Doug", "Shook", 111111, 90, 3.14f);
		Student s9 = new Student("Pat", "Book", 111112, 92, 3.75f);
		// create class
		Course r1 = new Course("Math", 1234, 4, 2, 2, null);
		// add students to course
		r1.addStudent(s8);
		r1.addStudent(s9);
		// test getGPA
		assertEquals(3.45f, r1.averageGPA());
	}
}

