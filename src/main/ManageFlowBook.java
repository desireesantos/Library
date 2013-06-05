package main;

import units.Login;
import units.Menu;
import units.Message;
import output.Writer;

import java.io.*;
import java.util.Scanner;


public class ManageFlowBook {

    public static void main(String[] args){
        Login login =  new Login();

        if(login.execute()){

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));
            Menu menuList = new Menu();
            Scanner scanner = new Scanner(System.in);

            System.out.println(Message.getWELCOME());
            menuList.printMenu();
            writer.showResultMenu(menuList.commandUser(scanner.nextInt()));

        } else {
            System.out.println( " ");
            System.err.println(Message.getERROR_USERINFORMATION());
        }
    }


    public static void execute(){
        Menu menuList = new Menu();
        Scanner scanner = new Scanner(System.in);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        menuList.printMenu();
        writer.showResultMenu(menuList.commandUser(scanner.nextInt()));
    }

}



