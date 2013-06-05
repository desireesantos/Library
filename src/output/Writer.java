package output;

import main.ManageFlowBook;

import java.awt.*;
import java.io.*;
import java.util.List;

/**
 * User: dsantos
 * Date: 6/3/13  - Time: 11:07 PM
 */
public class Writer {

    private PrintStream out;
    private BufferedReader in;
    protected String readLine;
    private String string[] = null;
    Color color = new Color(0,200,255);


    public Writer(OutputStream outputStream, BufferedReader in){
        this.in = in;
        this.out = new PrintStream(outputStream);
    }


    public void writerResultMenu(List<String> writer) {

        for (int x=0; x <= writer.size() -1 ;x++ ){

            out.println( writer.get(x));
            try {
                readLine = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
           out.print("");

    }


    public void showResultMenu(List<String> writer) {

        for (int x=0; x <= writer.size() -1 ;x++ ){

           System.out.println(writer.get(x).toString());
            try {
                readLine = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.print("");
        ManageFlowBook.execute();
    }


    public void showResult(List<String> writer) {

        for (int x=0; x <= writer.size() -1 ;x++ ){
            System.out.println(writer.get(x).toString());
            try {
                readLine = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.print("");
    }
}
