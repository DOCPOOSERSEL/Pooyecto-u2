package Proyector;
import java.util.*;


public class Client {
    private Profile profileClient = new Profile();
    public ArrayList<Book> borrowedBooks = new ArrayList<>();
    public ArrayList<Transaction> clientTransactions = new ArrayList<>();

    public void setProfileClient (String Name ,String Lastname, Date Birthdate) {
        profileClient.setProfile(Name,Lastname,Birthdate);
    }

    //omg un stealix hiiiiii
    public  String getCLientName(){
        return profileClient.getSkibiname();
    }
    public  String getCLientLastName(){
        return profileClient.getSkibidiapellido();
    }
    public  Date getCLientDateOfBirth(){
        return profileClient.getSkibidifecha();
    }

    //Mas Skibidi setters <3
    public void setCLientName(String newName){
        profileClient.setSkibiname(newName);
    }
    public  void setCLientLastName(String newApellido){
        profileClient.setSkibidiapellido(newApellido);
    }
    public  void setCLientDateOfBirth(Date Aguacate){
        profileClient.setSkibidifecha(Aguacate);
    }

}
