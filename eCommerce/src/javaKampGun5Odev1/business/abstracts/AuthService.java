package javaKampGun5Odev1.business.abstracts;

import java.util.List;

import javaKampGun5Odev1.entities.concretes.LoginDto;
import javaKampGun5Odev1.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void verify(User user, String token);
	void login(LoginDto loginDto);
	boolean userExists(String email);
}
