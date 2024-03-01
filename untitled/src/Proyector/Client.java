package Proyector;
import java.util.ArrayList;
import java.util.Date;

public class Client {
    private Profile profileClient;
    public ArrayList<Book> borrowedBooks;

    public void setProfileClient (String Name ,String Lastname, Date Birthdate) {
        profileClient = new Profile(Name,Lastname,Birthdate);
    }

}
