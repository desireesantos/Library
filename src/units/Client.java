package units;

import java.util.Random;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 1:59 PM
 */
public class Client {

    private String name;
    private String idLibrary;


    public Client() {
        this.idLibrary = createdIdLibrary();
    }

    private String createdIdLibrary() {
        Random sortedNumber = new Random();
        return idLibrary = String.valueOf(sortedNumber.nextInt(100));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdLibrary() {
        return idLibrary;
    }

}