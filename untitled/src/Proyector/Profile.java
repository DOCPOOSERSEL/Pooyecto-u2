package Proyector;
import java.util.Date;
public class Profile  {
    private String Skibiname;
    private String skibidiapellido;
    private Date Skibidifecha = new Date();

    public void setProfile(String skibiname, String skibidiapellido, Date skibidifecha) {
        this.Skibiname = skibiname;
        this.skibidiapellido = skibidiapellido;
        Skibidifecha = skibidifecha;
    }

    // Skibidi getters
    public String getSkibiname() {
        return Skibiname;
    }
    public String getSkibidiapellido() {
        return skibidiapellido;
    }
    public Date getSkibidifecha() {
        return Skibidifecha;
    }


    //skibidisetters
    public void setSkibiname(String skibiname) {
        this.Skibiname = skibiname;
    }
    public void setSkibidiapellido(String skibidiapellido) {
        this.skibidiapellido = skibidiapellido;
    }
    public void setSkibidifecha(Date skibidifecha) {
        Skibidifecha = skibidifecha;
    }
}
