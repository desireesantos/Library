package main;

import exception.WrongOptionException;
import in.Input;
import menu.MenuAdmin;
import menu.MenuUser;
import output.Writer;
import units.*;

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

    public static final String ADMIN = "admin";
    public static final String USER = "user";
    private Login login =  new Login();
    private Input input = new Input();
    private MenuAdmin menuAdmin = new MenuAdmin();
    private MenuUser menuUser = new MenuUser();
    public static final int USERWANT_RESERVEBOOK = 5;


    public void init() throws WrongOptionException {

        printInicialMessage();
        if( login.execute(input.getInformationsFromConsole()))
            flowToAdmin();
        else {
            flowToUser ();
        }
    }

    public void flowToAdmin(){
        printMenuAdmin();
        flow(ADMIN);
    }

    public void flowToUser(){
        printMenuUser();
        flow(USER);
    }


    public int flowToReservBook(List<String> listBook) {
        printOnlyOneUnit(listBook);
        return input.getInformationsFromScanner();
    }


    public boolean flowToCreateClient() {
        List<String> result = new ArrayList<String>();
        login.execute(input.getInformationsFromConsole());
        result.add(Message.CREATED_USER);
        printOnlyOneUnit(result);
        return true;
    }

    private void flow(String typeUser){
        int number = informationFromScanner();
        if(isToReserveBook(number))
            listAllBooksToReserv();
        else if (ADMIN.equalsIgnoreCase(typeUser)) {
            flowprintAdmin(number);
        } else flowprintUser(number);

    }

    private void flowprintUser(int number) {
        List<String> stringListToPrint = menuUser.commandUser(number);
        printStringListsOnFlowUser(stringListToPrint);
    }

    private void flowprintAdmin(int number) {
        List<String> stringListToPrint = menuAdmin.commandUser(number);
        printStringListsOnFlow(stringListToPrint);
    }





    private void listAllBooksToReserv() {
        List<String> stringReservList = menuAdmin.commandUser(USERWANT_RESERVEBOOK);
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

    private static void printStringListsOnFlowUser(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printONFlowUser(stringListToPrint);
    }




    private static int informationFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printMenuAdmin() {
        MenuAdmin menu = new MenuAdmin() ;
        printOnlyOneUnit(menu.printMenu());
    }

    private static void printMenuUser() {
        MenuUser menu = new MenuUser() ;
        printOnlyOneUnit(menu.printMenu());
    }

    private static void printInicialMessage() {
        List<String> stringList = new ArrayList<String>();
        stringList.add(Message.WELCOME);
        stringList.add(" ");
        printOnlyOneUnit(stringList);
    }


}
