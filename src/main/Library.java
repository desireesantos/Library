package main;

import flow.FlowBookUser;
import in.Input;
import output.Writer;
import units.Client;
import units.Message;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: dsantos
 * Date: 6/11/13  - Time: 9:12 AM
 */
public class Library {

    public void init()  {
        Input input = new Input();

        printWelcomeMessage();
        Client client = input.createUser(input.getInformationsFromConsole());
        FlowBookUser user = new FlowBookUser(client);
        user.execute();
    }

    private static void printWelcomeMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        List<String> stringList = new ArrayList<String>();
        stringList.add(Message.WELCOME);
        writer.printMenu(stringList);
    }

}
