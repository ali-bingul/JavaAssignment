package javaKampGun5Odev1;

import javaKampGun5Odev1.business.concretes.AuthManager;
import javaKampGun5Odev1.business.concretes.UserManager;
import javaKampGun5Odev1.core.AmazonMailManagerAdapter;
import javaKampGun5Odev1.core.GoogleMailManagerAdapter;
import javaKampGun5Odev1.dataAccess.concretes.UserDao;
import javaKampGun5Odev1.entities.concretes.User;
import javaKampGun5Odev1.googleEmail.GoogleMailManager;

public class Main {
	public static void main(String[] args) {
		
		User mertcakmak = new User(4, "Mert", "Çakmak", "mertcakmak@gmail.com",  "qwerty", true);
		User kadirtokat = new User(7, "Kadir", "Tokat", "kadirtokat@gmail.com", "1432549", true);
		
	 	UserDao userDao = new UserDao();
		GoogleMailManagerAdapter googleMailManagerAdapter = new GoogleMailManagerAdapter();
		AmazonMailManagerAdapter amazonMailManagerAdapter = new AmazonMailManagerAdapter();
		
		AuthManager authManager = new AuthManager(new UserManager(userDao, googleMailManagerAdapter));
		UserManager userManager = new UserManager(userDao, amazonMailManagerAdapter);
		
		
		authManager.register(kadirtokat);
		userManager.add(kadirtokat);
		userManager.add(mertcakmak);
		
		userManager.getAll();
		
		userManager.update(mertcakmak);
		userManager.delete(kadirtokat.getId());
		
		System.out.println("-----------------------------------");
		userManager.getAll();
		
		System.out.println("------------------------------");
		System.out.println(userManager.get("kadirtokat@gmail.com").getName());
	}
}
