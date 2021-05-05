package inheritanceIntro.Manager;

import inheritanceIntro.User;

public class InstructorManager extends UserManager {
	@Override
	public void add(User user) {
		System.out.println("Instructor added: "+ user.getFirstName());
	}
}
