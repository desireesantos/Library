package main;


import exception.WrongOptionException;

public class InitFlowBook {

    public static void main(String[] args){
        FlowBook library = new FlowBook();
        try {
            library.init();
        } catch (WrongOptionException e) {
            e.getMessage();
        }
    }


}



