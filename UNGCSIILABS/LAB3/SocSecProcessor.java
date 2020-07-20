import java.util.Scanner;

/**
 * SocSecProcessor Class will prompt user to enter name and SSN. Program will
 * check if SSN is valid or not. If it is not valid SocSecException will be
 * thrown with corresponding error message.
 * 
 * 
 * 
 */
public class SocSecProcessor {
    /**
     * Main method of SocSecProcessor, prompts will be looped until user enters 'N'
     * or 'n' to quit.
     * 
     * Prompts: User will be prompted to enter name, enter ssn, and isValid() method
     * will be called to check if ssn entered is true(valid). If it is not valid a
     * SocSecExecption message will be thrown.
     * 
     * @throws SocSecException
     */
    public static void main(String[] args) throws SocSecException {
        String name, ssn = " ";
        char quit = 'Y';
        Scanner in = new Scanner(System.in); // initialize scanner
        do {

            System.out.println("Please enter your name: ");
            name = in.next(); // scans name

            System.out.println("Please enter your Social Security Number (Example: 123-54-6789): ");
            ssn = in.next(); // scans SSN "123-45-1234" in string format

            try {
                isValid(ssn); // checks if SSN is valid see isValid() method
                System.out.println(name + " " + ssn + " is valid");

            } catch (SocSecException exception) {
                System.out.println(exception.getMessage()); // prints exception message when error occurs
                isValid(ssn); // catches error for isValid if flase exception.getMessage() will print error in
                              // terminal

            }
            // prompt users if they want to continue
            System.out.println("Continue? (Y/N)");
            quit = in.next().charAt(0); // scans 'Y/N' to see if user wants to continue using program or not

        } while (!(quit == 'N' || quit == 'n'));
        in.close(); // closes scanner
    }

    /**
     * isValid(String ssn) method checks if user has entered ssn with no errors. If
     * there are errors it will throw a SocSecException with the corresponding error
     * message. Format for ssn: 123-45-2345 Must contain ONLY digits, dashes has to
     * be in position (3,4) and (6, 7), and characters in String ssn has to be
     * EXACTLY 11 characters including "-"
     * 
     * 
     * @param ssn user enters ssn
     * @return flag is true if there are no errors for String ssn, if there are
     *         errors SocSecException will be thrown accordingly with corresponding
     *         error messages.
     * @throws SocSecException - custom exception class to catch any errors for
     *                         SocSecProcessor, retrieves error message
     * 
     */
    public static boolean isValid(String ssn) throws SocSecException {
        // set flag to true
        boolean flag = true;
        char[] ch = ssn.toCharArray(); // convert ssn to character array
        String[] divide = ssn.split("-"); // splits ssn into 3 separate arrays separated by "-"
        if (ch.length != 11) {
            flag = false;
            throw new SocSecException("Number of characters are not equal to 11");
        } else if (divide[0].length() != 3 || divide[1].length() != 2 || divide[2].length() != 4) {
            flag = false;
            throw new SocSecException("Your dashes are at the wrong positions");

        } else if (ch.length == 11) {
            for (int i = 0; i < divide.length; i++) {
                if (!(isInt(divide[i]))) {
                    flag = false;
                    throw new SocSecException("Contains a character that is not a digit");
                }
            }

        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * isInt() method checks if the characters entered by user is actually a ineger
     * or not. By utilizing the Integer library it will parseInt from a string and
     * using radix 10 it check if they are base 10 number '0-9'. Will return true if
     * number is integer, otherwise it will return an false.
     * 
     * @param ssn user enters SSN
     * @return true if all characters entered are integers, false if all characters
     *         entered are not integers
     */
    public static boolean isInt(String ssn) {
        try {

            Integer.parseInt(ssn, 10);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}