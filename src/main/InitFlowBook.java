package main;


import exception.WrongOptionException;
import in.Input;
import output.Writer;
import units.Login;
import units.Message;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InitFlowBook {

    public static void main(String[] args){
        init();

    }


    private static void init()  {
        Login login =  new Login();
        Input input = new Input();
        printInicialMessage();

        if( login.execute(input.getInformationsFromConsole())) {
            FlowBookAdmin admin = new FlowBookAdmin();
            admin.flow();
        }

        else {
            FlowBookUser user = new FlowBookUser();
            user.flow();
        }
    }

    private static void printInicialMessage() {
        List<String> stringList = new ArrayList<String>();
        stringList.add(Message.WELCOME);
        stringList.add(" ");
        printOnlyOneUnit(stringList);
    }


    private static void printOnlyOneUnit(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printMenu(stringListToPrint);
    }

}



