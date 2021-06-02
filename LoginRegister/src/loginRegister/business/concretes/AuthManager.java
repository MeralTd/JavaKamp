package loginRegister.business.concretes;

import loginRegister.business.abstracts.AuthService;
import loginRegister.business.abstracts.EmailService;
import loginRegister.business.abstracts.UserService;
import loginRegister.business.abstracts.UserValidationService;
import loginRegister.core.utils.BusinessRules;
import loginRegister.entities.Dto.LoginModel;
import loginRegister.entities.concretes.User;

public class AuthManager implements AuthService{

	UserService userService;
	UserValidationService userValidationService;
	EmailService emailService;
	
	
	public AuthManager(UserService userService, UserValidationService userValidationService, EmailService emailService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
	}

	@Override
	public void register(User user) {
		User userToRegister = new User(user.getId(), user.getAd(),user.getSoyad(),user.getEposta(),user.getParola(),user.isAktifMi());
		
		if(!userValidationService.validate(userToRegister)) {
			System.out.println("Validasyon i�lemi ba�ar�s�z. L�tfen t�m alanlar� do�ru girdi�inizden emin olunuz.");
			return;
		}
		
		if(!BusinessRules.run(checkIfUserExists(user.getEposta()))) {
			System.out.println("Kay�t olma i�lemi ba�ar�s�z. Bu email ile bir ba�ka �ye mevcut.");
			return;
		}
		
		System.out.println("Ba�ar�yla kay�t olundu. �yeli�inizi do�rulamak i�in l�tfen e-posta adresinizi kontrol ediniz.");
		emailService.send("Deneme do�rulama mesaj�d�r. Do�rulamak i�in buraya t�lay�n�z.", userToRegister.getEposta());
		userService.add(userToRegister);
	}

	@Override
	public void login(LoginModel loginModel) {
		if(!BusinessRules.run(checkIfAllFieldsFilled(loginModel.getEposta(), loginModel.getParola()))) {
			System.out.println("Giri� ba�ar�s�z. Veriler bo� ge�ilemez");
			return;
		}
		
		User userLogin = userService.getByEmailAndPassword(loginModel.getEposta(), loginModel.getParola());
		
		if(userLogin == null) {
			System.out.println("Giri� ba�ar�s�z. E-posta adresiniz veya �ifreniz yanl��.");
			return;
		}
		
		if(!checkIfUserVerified(userLogin)) {
			System.out.println("Giri� ba�ar�s�z. �yeli�inizi do�rulamad�n�z.");
			return;
		}
		System.out.println("Giri� ba�ar�l�. Ho�geldiniz : " + userLogin.getAd() + " " + userLogin.getSoyad());
	}
	
	
	private boolean checkIfUserExists(String email) {
		return userService.getByEmail(email) == null;
	}
	private boolean checkIfUserVerified(User user) {
		return user.isAktifMi();
	}
	private boolean checkIfAllFieldsFilled(String email,String password) {
		if(email.length()<=0 || password.length() <=0) {
			return false;
		}
		return true;
	}

}
