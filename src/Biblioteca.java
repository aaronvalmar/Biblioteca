import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//clase que gestiona una biblioteca
public class Biblioteca {
    //Ruta al escritorio
    private static final String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
    //Ruta completa al archivo json
    private static final String nombreArchivo= escritorio + File.separator +"bibilioteca.json";
    //Lista que almacena los lirbos de la biblioteca
    private ArrayList<Libro> catalogo;
    //Códigos ansi para los colores en la consola
    final String amarillo= "\u001B[33m";
    final String cian = "\u001B[36m";

    /**
     * Constructor
     * Inicializa el catálogo y carga los datos desde el archivo json
     */
    public Biblioteca() {
        catalogo = new ArrayList<>();
        cargarCatalogo();

    }

    /**
     * Guarda el catálogo de libros en formato JSON en el archivo indicado
     * Si el archivo no existe o hay un error,crea una lista vacía
     */
    public void guardarCatalogo(){
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fileWriter = new FileWriter(nombreArchivo)){
            gson.toJson(catalogo,fileWriter);
            System.out.println("Catálogo guardado en " + nombreArchivo);
        } catch (Exception e) {
            System.err.println("Error al guardar el catálogo:" + e.getMessage());
        }
    }
    /**
     * Carga el catálogo de libros desde el archivo JSON
     * Si el archivo no existe o hay un error,crea una lista vacía
     */
    public void cargarCatalogo(){
        try(FileReader fileReader = new FileReader(nombreArchivo)){
            Gson gson = new Gson();
            Type tipoListaLibros = new TypeToken<ArrayList<Libro>>(){}.getType();
            catalogo = gson.fromJson(fileReader,tipoListaLibros);
            if(catalogo==null){
                catalogo= new ArrayList<>();
            }
            System.out.println("Catálogo cargado desde " + nombreArchivo);
        } catch (Exception e) {
            System.err.println("Error al cargar el catálogo:" + e.getMessage());
            catalogo=new ArrayList<>();
        }
    }

    /**
     * Añade un nuevo libro al catálogo
     * @param libro
     */

    public void anadirLibro(Libro libro){
        if(libro == null){
            System.out.println("No se puede añadir un libro nulo");
            return;
        }
        catalogo.add(libro);
        System.out.println("Añadido correctamente el libro " + libro.getTitulo());
    }

    /**
     * Muestra por consola todos los libros guardados en el catálogo
     */
    public void listarLibros(){
        if(catalogo.isEmpty()){
            System.out.println("No hay libros");
        }else{
            System.out.println(cian + "Listado de libros en la biblioteca:" + amarillo);
            for(Libro libro:catalogo){
                System.out.println(libro.toString());
            }

        }

    }

    /**
     * Busca libros por títulos y los muestra por consola
     * @param titulo
     */
    public void buscarPorTitulo(String titulo){
        boolean encontrado=false;
        for(Libro libro:catalogo){
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                System.out.println(" Libro encontrado: " + libro);
                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println(" No se encontró ningún libro con el dato especificado");
        }
    }

    /**
     * Busca libros por autor y muestra todos los títulos asociados a ese escritor
     * @param autor nombre del autor o parte
     */
    public void buscarPorAutor(String autor){
        boolean encontrado=false;
        String ultimoAutor="";
        //recorre todos los libros que hay en el catálogo
        for(Libro libro:catalogo){
            //verifica si el nombre del autor contiene la cadena establecida
            if (libro.getNombreAutor().toLowerCase().contains(autor.toLowerCase())){
                //Ejecuta si el autor es distinto al último
                if(!libro.getNombreAutor().equalsIgnoreCase(ultimoAutor)) {
                    //actualiza el valor del autor
                    ultimoAutor= libro.getNombreAutor();
                    System.out.println(" Autor encontrado: " + libro.getNombreAutor());
                    System.out.println(" Libros del autor: ");
                    //recorre los libros para listar sólo los libros del autor
                    for(Libro libroRecorrido : catalogo){
                        if(libroRecorrido.getNombreAutor().equalsIgnoreCase(ultimoAutor)){
                            System.out.println("-" + libroRecorrido.getTitulo());
                        }
                    }
                }

                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println(" No se encontró ningún autor con el dato especificado");
        }
    }

    /**
     * Elimina un libro del catálogo según el isbn introducido
     * @param isbn
     */
    public void eliminarLibro(String isbn){
        Scanner scanner= new Scanner(System.in);
        //Valida el formato isbn antes de continuar
        while(!Biblioteca.isbnValido(isbn)){
            System.out.println("ISBN inválido.Debe de tener el siguiente formato 978-xx-xxxxx-xx-x.Escríbalo correctamente, porfavor");
            isbn= scanner.nextLine();
        }
        boolean eliminado=false;
        //Recorre el catálogo de libros
        for(int indice=0; indice<catalogo.size();indice++){
            Libro libro= catalogo.get(indice);
            //Compara el ISBN del libro actual con el ISBN introducido
            if(libro.getIsbn().equalsIgnoreCase(isbn)){
                catalogo.remove(indice);//elimina el libro con ese ISBN
                System.out.println("Libro " + libro.getTitulo() + " con ISBN " + libro.getIsbn() + " ha sido eliminado");
                eliminado=true;
                break;
            }
        }
        if(!eliminado){
            System.out.println("No hay ningún libro con el ISBN especificado");
        }

    }

    /**
     * Verifica si el ISBN introducido cumple con el formato indicado
     * @param isbn a valida
     * @return  true si el ISBN es válido y false si no cumple con el formato
     */
    public static boolean isbnValido(String isbn) {
        String patronIsbn="\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d";
        return isbn.matches(patronIsbn);
    }

    /**
     * Comprueba si el ISBN introducido ya está asociado a otro libro del catálogo
     * @param isbn a comprobar si ya existía
     * @return true si el ISBN ya existía, false en caso contrario
     */
    public boolean isbnExistente(String isbn) {
        for(Libro libro:catalogo){
            if(libro.getIsbn().equalsIgnoreCase(isbn)){
                return true;
            }
        }
        return false;
    }
}
