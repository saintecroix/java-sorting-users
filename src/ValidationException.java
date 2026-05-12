public class ValidationException extends  Exception {

    public ValidationException(String field, String msg) {
        super(field + ": " + msg);
    }

}
