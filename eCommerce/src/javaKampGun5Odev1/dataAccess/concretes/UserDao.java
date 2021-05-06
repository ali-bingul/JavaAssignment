package javaKampGun5Odev1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import javaKampGun5Odev1.dataAccess.abstracts.IUserDao;
import javaKampGun5Odev1.entities.concretes.User;

public class UserDao implements IUserDao{

	private List<User> users = new ArrayList<>();
	
	public UserDao() {
		super();
		
		User alibingul = new User(1, "Ali", "Bingül", "alibingul40@gmail.com", "123456", true);
		User emregozkaya = new User(2, "Emre", "Gözkaya", "emregozkaya@gmail.com", "1238239", true);
		User berkaybicak = new User(3, "Berkay", "Bicak", "berkaybicak@gmail.com", "028371", true);
		
		users.add(alibingul);
		users.add(emregozkaya);
		users.add(berkaybicak);
	}
	
	@Override
	public void add(User user) {
		users.add(user);
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream()
				.filter(u -> u.getId() == user.getId())
				.findFirst()
				.orElse(null);
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setName(user.getName());
		userToUpdate.setSurname(user.getSurname());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u -> u.getId() == userId)
				.findFirst()
				.orElse(null);
		users.remove(userToDelete);
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u -> u.getEmail() == email)
				.findFirst()
				.orElse(null);
		return user;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
}
