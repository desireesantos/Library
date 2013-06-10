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

        boolean permission = isPermitted(console.readLine("Type what are you [A]Admin - [U]User: "));
        client.setPermission(permission);
        return client;
    }

    public int getInformationsFromScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    private boolean isPermitted(String permission){
      return   permission.equalsIgnoreCase("A") ? true : false;
    }
}
