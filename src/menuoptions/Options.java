package menuoptions;

import exception.WrongOptionException;
import main.ManageFlowBook;
import units.*;
import output.Writer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 2:08 PM
 */
public class Options {

    private List<Book> listBooks = new ArrayList<Book>();

    public Options() {
        this.listBooks = listBooks();

    }

    public List<String> userProfile() {
        List<String> user = new ArrayList<String>();
        Client client = new Client();
        client.setName("Paulo Cesar Santos");

        user.add("Dados Cadastrais: ");
        user.add(" ");
        user.add("Nome Completo: " + client.getName());
        user.add("Id: " + client.getIdLibrary());
        user.add(" ");

        return user;
    }

    public List<String> availableBooks() {

        List<String> bookList = new ArrayList<String>();

        bookList.add("Available Book(s) ");
        bookList.add(" ");
        for(Book book: this.listBooks){
            if(!book.isReserved()){
                bookList.add(book.getName());
            }
        }
        bookList.add(" ");

        return bookList;
    }

    public List<String> reservedBooks() {
        List<String> bookList = new ArrayList<String>();

        bookList.add("Reserved Book(s): ");
        bookList.add(" ");
        for(Book book: this.listBooks){
            if(book.isReserved()){
                bookList.add(book.getName());
            }

        }
        bookList.add(" ");
        return bookList;
    }

    public List<String> showListBooks() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("Reserved Books: ");
        stringList.add(" ");
        for(Book book: this.listBooks){
            stringList.add(book.getName() + " - Reserved: " + book.isReserved());
        }
        stringList.add(" ");

        return  stringList;
    }


    public List<Book> listBooks(){


        Book book = new Book();
        book.setName("Thinking Java");
        book.setReserved(false);
        listBooks.add(book);

        Book book2 = new Book();
        book2.setName("Padrões de Software");
        book2.setReserved(false);
        listBooks.add(book2);

        Book book3 = new Book();
        book3.setName("Agile Samurai");
        book3.setReserved(true);
        listBooks.add(book3);


        return listBooks;
    }

    public List<String> getBooks() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        List<String> listBook = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        listBook.add("Type number book");
        listBook.add(" ");

        for (int x=0; x <= this.listBooks.size() -1; x++){
            listBook.add((x+1) +" - "+this.listBooks.get(x).getName());
        }
        listBook.add(" ");

        writer.showResult(listBook);
        Scanner scanner = new Scanner(System.in);
        int bookIndex = scanner.nextInt();

        if(bookIndex <= this.listBooks.size()){

            if(this.listBooks.get(bookIndex - 1).isReserved()){
                result.add(Message.getSORRY_MESSAGE());
                return result;
            } else {
                this.listBooks.get(bookIndex-1).setReserved(true);
                System.out.println(this.listBooks.get(bookIndex-1).isReserved());
                result.add(Message.getTHANK_MESSAGE());
                return result;
            }

        } else {

            try {
                throw new WrongOptionException();
            } catch (WrongOptionException e) {
                System.err.println(e.getMessage());
            }
               return result;
        }

    }

    public void logout() {

        ManageFlowBook.main(null);
    }

    public void exit() {
        System.exit(1);
    }
}
