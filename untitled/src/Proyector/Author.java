package Proyector;
import java.util.*;
public class Author {
    private Profile profile;
    public ArrayList<Book> authorBooks = new ArrayList<Book>();

    public void setProfileAuthorCompleto(String nom, String apellido, Date birthdate){
        profile = new Profile(nom,apellido,birthdate);
    }
    public void setProfileAuthorName(String name){
        profile.setSkibiname(name);
    }
    public void setProfileAuthorLastName(String name){
        profile.setSkibidiapellido(name);
    }
    public void setProfileAuthoDate(Date birthday){
        profile.setSkibidifecha(birthday);
    }

    public String getProfileAuthorName(){
        return profile.getSkibiname();
    }

    public String getProfileAuthorLastName(){
        return profile.getSkibidiapellido();
    }

    public Date getProfileAuthorBirthdate(){
        return profile.getSkibidifecha();
    }

}
