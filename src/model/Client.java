package model;

import java.util.Random;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 1:59 PM
 */
public class Client {

    private String name;
    private String idLibrary;
    private String passord;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String generateIdLibrary() {
        createIdLibrary();
        return idLibrary;
    }

    private void createIdLibrary() {
        Random sortedNumber = new Random();
        idLibrary = String.valueOf(sortedNumber.nextInt(100));
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

}
