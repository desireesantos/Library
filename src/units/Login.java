package units;

import com.sun.tools.javac.util.List;
import output.Writer;

import java.io.*;
import java.util.ArrayList;


/**
 * User: dsantos
 * Date: 6/5/13  - Time: 11:14 AM
 */
public class Login {



    public boolean execute(){

        Console console = System.console();
        String userName = console.readLine("Type your Username: ");
        String password = new String(console.readPassword ("Type your password: "));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));
        ArrayList<String> stringList = new ArrayList<String>();

        if(userName.equals("admin") && password.equals("admin")){
            stringList.add( " ");
            stringList.add( "Welcome " + userName);
            writer.writerResultMenu(stringList);
            return true;

        } else {

            stringList.add( " ");
            stringList.add( Message.getERROR_USERINFORMATION());
            writer.writerResultMenu(stringList);
            return false;
        }
    }

}

