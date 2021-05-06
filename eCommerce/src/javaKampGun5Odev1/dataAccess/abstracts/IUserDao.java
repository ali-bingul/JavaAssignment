package javaKampGun5Odev1.dataAccess.abstracts;

import java.util.List;

import javaKampGun5Odev1.entities.concretes.User;

public interface IUserDao {
	void add(User user);
	void update(User user);
	void delete(int userId);
	User get(String email);
	List<User> getAll();
}
