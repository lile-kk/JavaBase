package pure.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.lang.model.element.Element;


/*
 * ×¢½â
 */
public class Zhujie {

	public static void trackUseCases(List<Integer> useCaeses,Class<?> cl){
		for(Method m : cl.getDeclaredMethods()){
			UseCase us = m.getAnnotation(UseCase.class);
			if(us != null){
				System.out.println("Found Use Case:" + us.id() +" " +us.description());
				useCaeses.remove(new Integer(us.id()));
			}
		}
		for(int i : useCaeses){
			System.out.println("Warning : Missing use case-" + i);
		}
	}
	
	public static void main(String[] args){
		List<Integer> usecases = new ArrayList<Integer>();
		Collections.addAll(usecases, 47,48,49,50);
		trackUseCases(usecases, PasswordUtils.class);
	}
}


class PasswordUtils{
	@UseCase(id = 47,description = "Passwords must contain at least one numeric")
	public boolean validatePassword(String password){
		return (password.matches("\\w*\\d\\w*"));
	}
	@UseCase(id = 48)
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	@UseCase(id = 49,description = "New password can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPassword,String password){
		return !prevPassword.contains(password);
	}
	
}