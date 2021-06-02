package loginRegister.business.abstracts;

import loginRegister.entities.concretes.User;

public interface UserValidationService {
	 boolean validate(User user);
}
