package units;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 2:28 PM
 */
public class Message {

    final static String ERROR_MESSAGE = "Choose a valid option";
    final static String ERROR_USERINFORMATION = "Not valid information";
    final static String THANK_MESSAGE = "Thank you ! Enjoy the book";
    final static String SORRY_MESSAGE = "Sorry we don't have that book yet";
    final static String WELCOME = " ** Welcome to Reservation Book Software **";


    public static String getWELCOME() {
        return WELCOME;
    }

    public static String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }

    public static String getTHANK_MESSAGE() {
        return THANK_MESSAGE;
    }

    public static String getSORRY_MESSAGE() {
        return SORRY_MESSAGE;
    }

    public static String getERROR_USERINFORMATION() {
        return ERROR_USERINFORMATION;
    }
}
