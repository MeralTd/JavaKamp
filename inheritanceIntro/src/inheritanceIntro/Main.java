package inheritanceIntro;

import inheritanceIntro.Manager.InstructorManager;
import inheritanceIntro.Manager.StudentManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(1);
		student.setFirstName("meral");
		student.setLastName("taşdemir");
		student.setEmail("meral@meral.com");
		student.setLessonAttended("Java/React");
		
		Instructor instructor = new Instructor();
		instructor.setId(1);
		instructor.setFirstName("engin");
		instructor.setLastName("demiroğ");
		instructor.setEmail("engin@engin.com");
		instructor.setMyLesson("Java/React");
				
		StudentManager studentManager = new StudentManager();
		studentManager.add(student);
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor);

	}

}
