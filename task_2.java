public class Main {
    public static void main(String[] args) {
        try {
            boolean result = validateCredentials("User123", "Pass123_", "Pass123_");
            System.out.println("Валидация успешна: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static boolean validateCredentials(String login, String password, String confirmPassword) {
        try {
            // Проверка login
            if (!login.matches("^[a-zA-Z0-9_]+$") || login.length() >= 20) {
                throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть короче 20 символов.");
            }
            // Проверка password
            if (!password.matches("^[a-zA-Z0-9_]+$") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, быть короче 20 символов и совпадать с подтверждением.");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

// Пользовательский класс исключения для ошибки логина
class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }
    
    public WrongLoginException(String message) {
        super(message);
    }
}

// Пользовательский класс исключения для ошибки пароля
class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }
    
    public WrongPasswordException(String message) {
        super(message);
    }
}
