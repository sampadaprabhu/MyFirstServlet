public class UserValidator {
    String USER_NAME_REGEX="^[A-Z]{1}[A-Za-z]{2,}$";
    String PASSWORD="^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[\\d])[A-Za-z\\d\\W\\_]{8,})$";
    public static void main(String[] args) {
        System.out.println("Welcome To My First Servlet Problem!!");
    }
    public boolean validateName(String userName){
        if (userName.matches(USER_NAME_REGEX))
            return true;
        return false;
    }

    public boolean validatePassword(String password){
        if (password.matches(PASSWORD))
            return true;
        return false;
    }
}
