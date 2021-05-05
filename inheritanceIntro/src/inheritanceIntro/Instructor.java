package inheritanceIntro;

public class Instructor extends User{
	private String myLesson;

	public String getMyLesson() {
		return myLesson;
	}

	public void setMyLesson(String myLesson) {
		this.myLesson = myLesson;
	}
}
