package javaKampGun5Odev1.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javaKampGun5Odev1.business.concretes.EmailValidator;

public class Utils {
	public static boolean emailValidate(String email) {
		/*
	    if(EmailValidator.isEmailValid(email)) {
			return true;
		}
		return false;
		*/
	    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

	    Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(email);
	    System.out.println(email +" : "+ matcher.matches());
	    return matcher.matches();
	    
	}
}
