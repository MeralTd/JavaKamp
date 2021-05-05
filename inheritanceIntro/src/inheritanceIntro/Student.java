package inheritanceIntro;

public class Student extends User{
	private String lessonAttended;

	public String getLessonAttended() {
		return lessonAttended;
	}

	public void setLessonAttended(String lessonAttended) {
		this.lessonAttended = lessonAttended;
	}
}
