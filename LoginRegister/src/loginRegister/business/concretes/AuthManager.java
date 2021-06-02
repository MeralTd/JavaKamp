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
			System.out.println("Validasyon iþlemi baþarýsýz. Lütfen tüm alanlarý doðru girdiðinizden emin olunuz.");
			return;
		}
		
		if(!BusinessRules.run(checkIfUserExists(user.getEposta()))) {
			System.out.println("Kayýt olma iþlemi baþarýsýz. Bu email ile bir baþka üye mevcut.");
			return;
		}
		
		System.out.println("Baþarýyla kayýt olundu. Üyeliðinizi doðrulamak için lütfen e-posta adresinizi kontrol ediniz.");
		emailService.send("Deneme doðrulama mesajýdýr. Doðrulamak için buraya týlayýnýz.", userToRegister.getEposta());
		userService.add(userToRegister);
	}

	@Override
	public void login(LoginModel loginModel) {
		if(!BusinessRules.run(checkIfAllFieldsFilled(loginModel.getEposta(), loginModel.getParola()))) {
			System.out.println("Giriþ baþarýsýz. Veriler boþ geçilemez");
			return;
		}
		
		User userLogin = userService.getByEmailAndPassword(loginModel.getEposta(), loginModel.getParola());
		
		if(userLogin == null) {
			System.out.println("Giriþ baþarýsýz. E-posta adresiniz veya þifreniz yanlýþ.");
			return;
		}
		
		if(!checkIfUserVerified(userLogin)) {
			System.out.println("Giriþ baþarýsýz. Üyeliðinizi doðrulamadýnýz.");
			return;
		}
		System.out.println("Giriþ baþarýlý. Hoþgeldiniz : " + userLogin.getAd() + " " + userLogin.getSoyad());
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
