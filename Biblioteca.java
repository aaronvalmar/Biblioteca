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

public class Biblioteca {

    private static final String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
    private static final String nombreArchivo= escritorio + File.separator +"bibilioteca.json";
    private ArrayList<Libro> catalogo;
    final String amarillo= "\u001B[33m";
    final String cian = "\u001B[36m";


    public Biblioteca() {
        catalogo = new ArrayList<>();
        cargarCatalogo();

    }
    public void guardarCatalogo(){
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fileWriter = new FileWriter(nombreArchivo)){
            gson.toJson(catalogo,fileWriter);
            System.out.println("Catálogo guardado en " + nombreArchivo);
        } catch (Exception e) {
            System.err.println("Error al guardar el catálogo:" + e.getMessage());
        }
    }
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

    public void anadirLibro(Libro libro){
        if(libro == null){
            System.out.println("No se puede añadir un libro nulo");
            return;
        }
        catalogo.add(libro);
        System.out.println("Añadido correctamente el libro " + libro.getTitulo());
    }
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
                    for(Libro libr : catalogo){
                        if(libr.getNombreAutor().equalsIgnoreCase(ultimoAutor)){
                            System.out.println("-" + libr.getTitulo());
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

    public void eliminarLibro(String isbn){
        boolean eliminado=false;
        for(int indice=0; indice<catalogo.size();indice++){
            Libro libro= catalogo.get(indice);
            if(libro.getIsbn().equalsIgnoreCase(isbn)){
                catalogo.remove(indice);
                System.out.println("Libro " + libro.getTitulo() + "con ISBN " + libro.getIsbn() + "ha sido eliminado");
                eliminado=true;
                break;
            }
        }

    }

    public static boolean isbnValido(String isbn) {
        String patronIsbn="\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d";
        return isbn.matches(patronIsbn);
    }


    public boolean isbnExistente(String isbn) {
        for(Libro libro:catalogo){
            if(libro.getIsbn().equalsIgnoreCase(isbn)){
                return true;
            }
        }
        return false;
    }
}
