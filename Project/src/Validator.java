public class Validator {

    public static boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }
}