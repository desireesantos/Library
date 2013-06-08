package in;

import units.Client;

import java.io.Console;
import java.util.Scanner;

/**
 * User: dsantos
 * Date: 6/5/13  - Time: 7:40 PM
 */
public class Input {

    public Client getInformationsFromConsole(){
        Client client = new Client();

        Console console = System.console();
        client.setName(console.readLine("Type your Username: "));
        client.setPassord(new String(console.readPassword ("Type your password: ")));
        client.setPermission(Boolean.parseBoolean(console.readLine("Permission [y] Yes  [n]Not :")));
        return client;
    }

    public int getInformationsFromScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
