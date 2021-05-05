package inheritanceIntro.Manager;

import inheritanceIntro.User;

public class StudentManager extends UserManager {

	@Override
	public void add(User user) {
		System.out.println("Student added: "+ user.getFirstName());
	}

}
