/**
 * SocSecException Class is a custom class that extends the class Exception.
 * It will print an error message when thrown from SocSecProcessor Class
 * 
 */

public class SocSecException extends Exception {
    private String error;
    public static final long serialVersionUID = 1L; //Had a serialization error for SocSecException class in VScode

    public SocSecException(String error) {
        
        super(error);
        this.error = error;
    }  

    public String toString() {
        return "Invalid Social Security number, " + error;
    }
}