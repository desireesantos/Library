package out;

import java.util.List;

/**
 * User: dsantos
 * Date: 6/3/13  - Time: 11:07 PM
 */
public class Writer {

    public static final String TEXT_COLOR_PINK = "\033[95m";

    public void print(List<String> writer) {
        for (int x=0; x <= writer.size() -1 ;x++ ){
            System.out.println(writer.get(x).toString() + TEXT_COLOR_PINK);
        }
        System.out.println(" ");

    }


}
