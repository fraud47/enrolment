package zw.apkmechanik.enrolment.utils;

import lombok.Getter;
import lombok.experimental.UtilityClass;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 15/3/2023
 */
@UtilityClass
@Getter
public class StringUtils {

    public static final String ACCESS_TOKEN_TYPE = "Bearer";

    public static final String SUCCESS = "Success";
    public static final String CREATED = "Created";
    public static final String ERROR = "Error";
    public static final String BAD_REQUEST = "Bad request, please try again later";


    public static final String SAME_PASSWORD = "Old and new passwords are similar";
    public static final String DIFFERENT_PASSWORDS = "Passwords are not matching";
    public  static final String EMAIL_SUBJECT = "Default Credentials";
   public static String EMAIL_MESSAGE = "Username: %s\nPassword: %s\n\nNB: You are advised to change your default password!";


    public static String alreadyExists(String name) {
        return String.format("%s already exists", name);
    }

    public static String notFound(String name) {
        return String.format("%s not found", name);
    }

    public static String passwordMessage(String password) {
        return String.format("Your new password is : %s", password);
    }

}
