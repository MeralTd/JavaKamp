package loginRegister.core;

import loginRegister.GoogleAuth.GoogleAuthManager;
import loginRegister.business.abstracts.AuthService;
import loginRegister.entities.Dto.LoginModel;
import loginRegister.entities.concretes.User;

public class GoogleAuthManagerAdapter implements AuthService{

	@Override
	public void register(User user) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.register(user.getEposta(), user.getParola());
		
	}

	@Override
	public void login(LoginModel loginModel) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(loginModel.getEposta(),loginModel.getParola());
	}

}
