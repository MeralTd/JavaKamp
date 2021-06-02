package loginRegister;

import loginRegister.business.abstracts.AuthService;
import loginRegister.business.abstracts.UserService;
import loginRegister.business.concretes.AuthManager;
import loginRegister.business.concretes.EmailManager;
import loginRegister.business.concretes.UserManager;
import loginRegister.business.concretes.UserValidationManager;
import loginRegister.core.GoogleAuthManagerAdapter;
import loginRegister.dataAccess.concretes.InMemoryUserDao;
import loginRegister.entities.Dto.LoginModel;
import loginRegister.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new InMemoryUserDao());
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());
		User meral = new User(1, "Meral", "Taþdemir","meral@gmail.com", "meral123", false);
		authService.register(meral);
		
		LoginModel user = new LoginModel(meral.getEposta(), meral.getParola());
		authService.login(user);
		userService.verifyUser(1);
		authService.login(user);
		
		
		AuthService googleAuthService = new GoogleAuthManagerAdapter();
		User user2 = new User(1, "meral12@gmail.com", "meral1234", "Meral", "Taþdemir", true);
		LoginModel userLogin = new LoginModel("meral12@gmail.com", "meral1234");
		googleAuthService.register(user2);
		googleAuthService.login(userLogin);
	}

}
