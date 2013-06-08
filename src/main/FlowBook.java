package main;

import exception.WrongOptionException;
import in.Input;
import output.Writer;
import units.Login;
import units.Menu;
import units.Message;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: dsantos
 * Date: 6/5/13  - Time: 9:22 PM
 */
public class FlowBook {

    private Input input = new Input();
    private Menu menu = new Menu();
    public static final int USERWANT_RESERVEBOOK = 5;


    public void init(){
        Login login =  new Login();

        printInicialMessage();
        if( login.execute(input.getInformationsFromConsole()))
            flow();

        else {
            try {
                throw new WrongOptionException();
            } catch (WrongOptionException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void flow(){

        printMenu();
        int number = informationFromScanner();
        if(isToReserveBook(number)){
            listAllBooksToReserv();
        }else {
            List<String> stringListToPrint = menu.commandUser(number);
            printStringListsOnFlow(stringListToPrint);
        }
    }


    public int flowToReservBook(List<String> listBook) {
        printOnlyOneUnit(listBook);
        return input.getInformationsFromScanner();

    }

    private void listAllBooksToReserv() {
        List<String> stringReservList = menu.commandUser(USERWANT_RESERVEBOOK);
        printStringListsOnFlow(stringReservList);
    }

    private boolean isToReserveBook(int number) {

        return number == USERWANT_RESERVEBOOK ? true : false;
    }

    private static void printStringListsOnFlow(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printONFlow(stringListToPrint);
    }

    private static void printOnlyOneUnit(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printMenu(stringListToPrint);
    }

    private static int informationFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printMenu() {
        Menu menu = new Menu() ;
        printOnlyOneUnit(menu.printMenu());
    }

    private static void printInicialMessage() {
        List<String> stringList = new ArrayList<String>();
        stringList.add(Message.getWELCOME());
        stringList.add(" ");
        printOnlyOneUnit(stringList);
    }


}