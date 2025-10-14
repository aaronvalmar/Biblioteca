/**
 * Clase que representa un libro en la biblioteca
 * Contiene información sobre el título,el nombre del autor ,el isbn y el año de publicación
 */
public class Libro {
       private String titulo;
       private String nombreAutor;
       private String isbn;
       private int anoLibro;

    /**
     * Constructor que inicializa un objeto libro con sus atributos
     * Valida el formato del isbn antes de asignarlo
     * @param titulo titulo del libro
     * @param nombreAutor nombre del autor
     * @param isbn código isbn
     * @param anoLibro año de publicación del libro
     * @throws IllegalArgumentException si el isbn no cumple con el formato indicado
     */
    public Libro(String titulo, String nombreAutor, String isbn, int anoLibro){
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.anoLibro=anoLibro;
        if(!Biblioteca.isbnValido(isbn)){
            throw new IllegalArgumentException("ISBN inválido.Debe de tener el siguiente formato xxx-xx-xxxxx-xx-x");
        }
        this.isbn=isbn;
    }
    /*Getters y setters*/
    //Obtiene el título del libro
    public String getTitulo() {
        return titulo;
    }
    //Modifica el título del libro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //Obtiene el nombre del autor
    public String getNombreAutor() {
        return nombreAutor;
    }
    //Modifica el nombre del autor
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    //Obtiene el isbn
    public String getIsbn() {
        return isbn;
    }
    //Modifica el isbn
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    //Obtiene el año de publicación del libro
    public int getAnoLibro() {
        return anoLibro;
    }
    //Modifica el año de publicación del libro
    public void setAnoLibro(int anoLibro) {
        this.anoLibro = anoLibro;
    }

    /**
     * Devuelve una representación en texto del libro con sus datos
     * @return Cadena con la información del libro
     */

    @Override
    public String toString(){
        return String.format("Libro: \"%s\"  \n Nombre del autor: %s \n ISBN: %s \n Año: %d",
                titulo, nombreAutor, isbn, anoLibro);
        }
    }

