package javaKampGun5Odev1.business.concretes;

import java.util.List;


import javaKampGun5Odev1.business.abstracts.UserService;
import javaKampGun5Odev1.core.EmailService;
import javaKampGun5Odev1.dataAccess.concretes.UserDao;
import javaKampGun5Odev1.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private EmailService emailService;
	
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}
	
	@Override
	public void add(User user) {
		if(userValidate(user)) {
			userDao.add(user);
			emailService.send(user.getEmail(), "Kayıt oldunuz.");
		}
	}
	
	@Override
	public void add(String email) {
		if(!email.isEmpty()) {
			User user = new User();
			user.setEmail(email);
			userDao.add(user);
			emailService.send(email, "Kayıt oldunuz.");
		}
	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);	
		}
	}

	@Override
	public List<User> getAll() {
		List<User> users = userDao.getAll();
		for (User user : userDao.getAll()) {
			System.out.println(user.getId() + " " + user.getEmail() + " " + user.getName() + " " + user.getSurname());
		}
		return users;
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	}
	
	public boolean userValidate(User user) {
		if(user.getName().length() >= 2 && user.getSurname().length() >= 2) {
			return true;
		}
		else {
			System.out.println("Adınız ve soyadınız en az iki karakterden oluşmalıdır.");
			return false;
		}
	}

	

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
	}
}
