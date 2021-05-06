package javaKampGun5Odev1.business.concretes;

import java.util.List;

import javaKampGun5Odev1.business.abstracts.AuthService;
import javaKampGun5Odev1.business.abstracts.UserService;
import javaKampGun5Odev1.core.utils.Utils;
import javaKampGun5Odev1.dataAccess.concretes.UserDao;
import javaKampGun5Odev1.entities.concretes.LoginDto;
import javaKampGun5Odev1.entities.concretes.User;

public class AuthManager implements AuthService{

	private UserService userService;
	private UserDao userDao;
	
	public AuthManager(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if(userValidate(user) && passwordValidate(user.getPassword()) && !userExists(user.getEmail()) && Utils.emailValidate(user.getEmail())) {
			userService.add(user);
		}
		else {
			System.out.println("Kayıt eklenmedi.");
		}
	}

	@Override
	public void verify(User user, String token) {
		if(user != null && token.length() > 15) {
			User _user = userService.get(user.getEmail());
			_user.setVerify(true);
			
			userService.update(_user);
			
			System.out.println("Email doğrulandı.");
		}
		else {
			System.out.println("Email doğrulanamadı.");
		}
	}

	@Override
	public void login(LoginDto loginDto) {
		User _user = userService.get(loginDto.getEmail());
		
		if(_user != null && _user.getPassword().equals(loginDto.getPassword())) {
			System.out.println("Sisteme başarıyla giriş yaptınız.");
		}
		else {
			System.out.println("Sisteme giriş yapılamadı.");
		}
		
	}

	@Override
	public boolean userExists(String email) {
		User user = userService.get(email);
		
		if(user != null && user.getEmail().isEmpty()) {
			return true;
		}
		else {
			System.out.println("Email zaten mevcut.");
			return false;
		}
	}
	
	public boolean userValidate(User user) {
		if(user != null && !user.getName().isEmpty() && !user.getSurname().isEmpty()
				&& !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		}
		System.out.println("Boş alan bırakmayınız.");
		return false;
	}
	
	public boolean passwordValidate(String password) {
		if(password.length() >= 6) {
			return true;
		}
		System.out.println("Şifre en az 6 karakterden oluşmalıdır.");
		return false;
	}
}
