package javaKampGun5Odev1.business.abstracts;

import java.util.List;

import javaKampGun5Odev1.entities.concretes.User;

public interface UserService {
	void add(User user);
	void add(String email);
	void update(User user);
	void delete(int userId);
	User get(String email);
	List<User> getAll();
}
