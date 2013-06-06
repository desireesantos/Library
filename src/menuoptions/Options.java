package menuoptions;

import exception.WrongOptionException;
import main.FlowBook;
import main.InitFlowBook;
import units.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 2:08 PM
 */
public class Options {

    public static final int ONE = 1;
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

    public List<String> reserveBook() {

        List<String> listBook = listBooksToReserv();
        return  reserve(listBook);


    }


    private List<String> reserve(List<String> listBook) {
        FlowBook flow = new FlowBook();
        int indexBook = flow.flowToReservBook(listBook);

      return reservBook(indexBook);

    }

    private List<String> listBooksToReserv() {

        List<String> listBook = new ArrayList<String>();
        for (int x=0; x <= this.listBooks.size() - ONE; x++){
            listBook.add((x+ ONE) +" - "+this.listBooks.get(x).getName());
        }
        listBook.add(" ");
      return listBook;
    }



    public List<String> reservBook(int bookIndex) {
        List<String> reservedBook = new ArrayList<String>();
        if(bookIndex <= this.listBooks.size()){

            if(this.listBooks.get(bookIndex - ONE).isReserved()){
                reservedBook.add(Message.getSORRY_MESSAGE());
                return reservedBook;
            } else {
                this.listBooks.get(bookIndex-ONE).setReserved(true);
                System.out.println(this.listBooks.get(bookIndex - ONE).isReserved());
                reservedBook.add(Message.getTHANK_MESSAGE());
                return reservedBook;
            }

        } else {

            try {
                throw new WrongOptionException();
            } catch (WrongOptionException e) {
                System.err.println(e.getMessage());
            }
            return reservedBook;
        }
    }

    public void logout() {

        InitFlowBook.main(null);
    }

    public void exit() {
        System.exit(1);
    }
}
