package javaKampGun5Odev1.core;

import javaKampGun5Odev1.entities.concretes.LoginDto;
import javaKampGun5Odev1.entities.concretes.User;

public interface ExternalAuthService {
	void register(String email);
	boolean userExists(String email);
	void login(LoginDto loginDto);
}
