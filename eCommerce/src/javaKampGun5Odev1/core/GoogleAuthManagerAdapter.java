package javaKampGun5Odev1.core;

import javaKampGun5Odev1.business.abstracts.UserService;
import javaKampGun5Odev1.entities.concretes.LoginDto;
import javaKampGun5Odev1.entities.concretes.User;

public class GoogleAuthManagerAdapter implements ExternalAuthService{

	private UserService userService;
	
	public GoogleAuthManagerAdapter(UserService userService) {
		super();
		this.userService = userService;
	}
	@Override
	public void register(String email) {
		if(!userExists(email)) {
			userService.add(email);
		}
		else {
			User user = userService.get(email);
			LoginDto dto = new LoginDto();
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			login(dto);
		}
	}

	@Override
	public boolean userExists(String email) {
		if(userService.get(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void login(LoginDto loginDto) {
		if(loginDto != null && loginDto.getPassword().equals(loginDto.getPassword())) {
			System.out.println("Sisteme başarıyla giriş yaptınız.");
		}
		else {
			System.out.println("Sisteme giriş yapılamadı.");
		}
	}
	
}
