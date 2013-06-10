package menu;

import exception.WrongOptionException;
import menuoptions.OptionsAdmin;
import menuoptions.OptionsUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o menu principal do sistema
 */
public class MenuUser {

    private static OptionsUser manage = new OptionsUser();


    public List<String> printMenu() {
        List<String> stringListToPrint = new ArrayList<String>();

        stringListToPrint.add(" ");
        stringListToPrint.add("1 - List all Books ");
        stringListToPrint.add("2 - Available Books ");
        stringListToPrint.add("3 - Reserved Books ");
        stringListToPrint.add("4 - Your profile ");
        stringListToPrint.add("5 - Reserve Books ");
        stringListToPrint.add("6 - Change User ");
        stringListToPrint.add("7 - Exit ");
        stringListToPrint.add(" ");

        return stringListToPrint;
    }



    public List<String> commandUser(int userType) {
        switch (userType) {

            case 1:
                return(manage.showListBooks());
            case 2:
                return(manage.availableBooks());
            case 3:
                return(manage.reservedBooks());
            case 4:
                return(manage.userProfile());
            case 5:
                return(manage.reserveBook());
            case 6:
                manage.logout();
            case 7:
                manage.exit();
            default:
                try {
                    throw new WrongOptionException();
                } catch (WrongOptionException e) {
                    System.err.println(e.getMessage());

                }
        }
        return null;
    }



}
