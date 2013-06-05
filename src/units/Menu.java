package units;

import exception.WrongOptionException;
import main.ManageFlowBook;
import menuoptions.Options;

import java.util.List;

/**
 * Classe que representa o menu principal do sistema
 */
public class Menu {

    private static Options manage = new Options();


    public void printMenu() {

        System.out.println(" ");
        System.out.println("1 - List all Books ");
        System.out.println("2 - Available Books ");
        System.out.println("3 - Reserved Books ");
        System.out.println("4 - Your profile ");
        System.out.println("5 - Reserve Books ");
        System.out.println("6 - Change User ");
        System.out.println("7 - Exit ");
        System.out.println(" ");

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
                return(manage.getBooks());
            case 6:
                manage.logout();
            case 7:
                manage.exit();
            default:
                try {
                    throw new WrongOptionException();
                } catch (WrongOptionException e) {
                    System.err.println(e.getMessage());
                    ManageFlowBook.execute();
                }


        }
        return null;
    }

}
