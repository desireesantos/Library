package units;



import output.Writer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * User: dsantos
 * Date: 6/5/13  - Time: 11:14 AM
 */
public class Login {

    public boolean execute(Client client){


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));
        List<String> stringList = new ArrayList<String>();


        if(client.getName().equals("admin") && client.getPassord().equals("admin")){
            stringList.add( " ");
            stringList.add( "Welcome " + client.getName());
            writer.printMenu(stringList);
            return true;

        } else {

            stringList.add( " ");
            stringList.add( Message.getERROR_USERINFORMATION());
            writer.printMenu(stringList);
            return false;
        }
    }

}

