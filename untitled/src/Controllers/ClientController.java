package Controllers;
import java.util.*;
public class ClientController {
    static Scanner sc = new Scanner(System.in);
    static int pildora,auxn,indice;
    static String auxs;

    public static void metodoClientController(){
        do {
            do {
                MenuHolder.menuInicioClient();
                indice = sc.nextInt();
                if ( pildora > 3 || pildora <= 0){
                    System.out.println("Nah uh");
                }
            }while(pildora > 3 || pildora <= 0);

            switch (pildora){
                case 2:
                    MenuHolder.menuCreacionEdicion();
            }


        }while(pildora != 3);
    }
}
