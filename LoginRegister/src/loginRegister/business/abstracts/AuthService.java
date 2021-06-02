package loginRegister.business.abstracts;

import loginRegister.entities.Dto.LoginModel;
import loginRegister.entities.concretes.User;

public interface AuthService {
	void register(User user);
    void login(LoginModel loginModel);
}
