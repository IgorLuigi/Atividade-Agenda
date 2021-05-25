package Validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarEmail {
	public static boolean validarEmail(String email) {
		boolean validar = false;
		if(email != null) {
			String validate = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(validate, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			return matcher.find();
		}
		return validar;
		
	}
	
}
