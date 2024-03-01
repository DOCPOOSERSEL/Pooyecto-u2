package Controllers;
import Proyector.*;
import Repositories.*;
import java.util.*;

public class BookController {
    static Scanner sc = new Scanner(System.in);
    static int pildora,auxn,indice;
    static String auxs;
    public static void bookMetodo() {
        do {
            do { //Menu Principal de libros
               MenuHolder.menuBookPrincipal();
                pildora = sc.nextInt();
                if (pildora != 1 && pildora != 2 && pildora !=3 && pildora !=4 && pildora !=5){
                    System.out.println("Nah uh");
                }
            }while(pildora != 1 && pildora != 2 && pildora !=3 && pildora !=4 && pildora !=5);

            switch (pildora){
                case 1: //Crear un libro

                    Book bok = new Book();
                    String Title, Author, ISBN;
                    Boolean Disponibilidad;
                    Date publishedDate = new Date();
                    int indexAuthor;

                    /*Seleccionar author*/
                    if (AuthorRepository.authorArrayList.isEmpty()){
                        System.out.println("No hay autores disponibles");
                        System.out.printf(" %-10s \n","------------------");
                        break;
                    }
                    MenuHolder.menuBookSeleccionarAuthorParaCrearLibro();
                    do {
                        System.out.printf(">> Selecciona al author: ");
                        indexAuthor = sc.nextInt();
                        sc.nextLine();
                    }while(indexAuthor > AuthorRepository.authorArrayList.size() || indexAuthor<=0);
                    indexAuthor--;
                    Author = AuthorRepository.authorArrayList.get(indexAuthor).getProfileAuthorName();

                    /*Resto de datos*/
                    System.out.printf("Ingrese El Titulo:  ");
                    Title = sc.nextLine();
                    System.out.printf("Ingrese El ISBN:  ");
                    ISBN = sc.nextLine();
                    System.out.println("> > Fecha < < ");
                    System.out.printf("Ingrese El Dia:  ");
                    auxn = sc.nextInt();
                    sc.nextLine();
                    publishedDate.setDate(auxn);
                    System.out.printf("Ingrese El Mes:  ");
                    auxn = sc.nextInt();
                    sc.nextLine();
                    publishedDate.setMonth(auxn);
                    System.out.printf("Ingrese El Año:  ");
                    auxn = sc.nextInt();
                    sc.nextLine();
                    publishedDate.setYear(auxn);
                    Boolean available=true;
                    bok.bookCreator(ISBN,Title,Author,publishedDate,available);
                    AuthorRepository.authorArrayList.get(indexAuthor).authorBooks.add(bok);
                    BookRepository.libraryBooks.add(bok);
                    break;
                case 2://Editar un libro

                    /*Comprobar si hay libros y seleccionar a editar*/
                    if (BookRepository.libraryBooks.isEmpty()){
                        System.out.println("No hay libros que se puedan editar");
                        break;
                    }else{
                        MenuHolder.menuBookShowLibraryBooks();
                        System.out.println("");
                        do {
                            System.out.printf(">> Que libro desea editar: ");
                            indice = sc.nextInt();
                        }while (indice> BookRepository.libraryBooks.size() || indice<=0);
                    }

                    do {/*Menu de edicion*/
                        MenuHolder.menuBookEdit();
                        System.out.printf(">> ");
                        auxn = sc.nextInt();
                        sc.nextLine();
                    }while(auxn>5 || auxn<=0);

                    switch (auxn){
                        case 1:
                            System.out.printf(">> Titulo: ");
                            auxs = sc.nextLine();
                            BookRepository.libraryBooks.get(indice).setTitle(auxs);
                            break;
                        case 2:
                            System.out.printf(">> ISBN: ");
                            auxs = sc.nextLine();
                            BookRepository.libraryBooks.get(indice).setISBN(auxs);
                            break;
                        case 3:
                            Date modifiedDate = new Date();
                            System.out.println(" < < Fecha > > ");

                            System.out.printf(">> Dia: ");
                            auxn = sc.nextInt();
                            modifiedDate.setDate(auxn);

                            System.out.printf(">> Mes: ");
                            auxn = sc.nextInt();
                            modifiedDate.setMonth(auxn);

                            System.out.printf(">> Año: ");
                            auxn = sc.nextInt();
                            modifiedDate.setYear(auxn);

                            BookRepository.libraryBooks.get(indice).setPublishDate(modifiedDate);
                            break;

                        case 4://Cambiar el Autor de un libro
                            String autorTemp,autorTemp2,newAuthorName;
                            int i=0,j=0;
                            do {/*nuevo autor*/
                                MenuHolder.menuBookSeleccionarAuthorParaCrearLibro();
                                System.out.printf(">> Seleccionar nuevo autor: ");
                                auxn = sc.nextInt();
                                sc.nextLine();
                            }while (auxn>AuthorRepository.authorArrayList.size() || auxn<=0);
                            auxn--;
                            do {/*libro al que se le cambia el autor*/
                                MenuHolder.menuBookShowLibraryBooks();
                                indice = sc.nextInt();
                                sc.nextLine();
                            }while(indice>BookRepository.libraryBooks.size() || indice<=0);
                            indice--;
                            auxs = BookRepository.libraryBooks.get(indice).getAuthor();
                            do {/*Nombre de el author que coinsida con el del libro*/
                                autorTemp = AuthorRepository.authorArrayList.get(i).getProfileAuthorName();
                                i++;
                            }while(auxs != autorTemp);
                            auxs = BookRepository.libraryBooks.get(indice).getTitle();
                            do {
                                autorTemp2 = AuthorRepository.authorArrayList.get(i).authorBooks.get(j).getTitle();
                                j++;
                            }while(auxs != autorTemp2);
                            /*Logica de remplaso y cambio de autor en el objeto*/
                            AuthorRepository.authorArrayList.get(auxn).authorBooks.add(AuthorRepository.authorArrayList.get(i).authorBooks.get(j));
                            newAuthorName = AuthorRepository.authorArrayList.get(auxn).getProfileAuthorName();
                            AuthorRepository.authorArrayList.get(i).authorBooks.get(j).setAuthor(newAuthorName);
                            AuthorRepository.authorArrayList.get(i).authorBooks.remove(j);
                            break;
                        case 5:
                            System.out.println("Regresando al menu anterior");
                            break;
                    }
                case 4://mostrar libros
                    MenuHolder.menuBookShowLibraryBooks();
                    break;
                case 5:
                    System.out.println("Regresando al menu anterior");
                    break;

            }
        }while (pildora != 5 );
    }
}
