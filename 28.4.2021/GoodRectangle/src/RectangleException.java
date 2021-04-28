public class RectangleException extends Exception{
    int errorType;

    public RectangleException(int x) {
        this.errorType = x;
    }

    public String getErrorMessage() {
        if(errorType == 0) {
            return "Error Width";
        }
        return "unfimiliar error";
    }
}
