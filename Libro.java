public class Libro {
       private String titulo;
       private String nombreAutor;
       private String isbn;
       private int anoLibro;

    public Libro(String titulo, String nombreAutor, String isbn, int anoLibro){
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.anoLibro=anoLibro;
        if(!Biblioteca.isbnValido(isbn)){
            throw new IllegalArgumentException("ISBN inválido.Debe de tener el siguiente formato 978-xx-xxxxx-xx-x");
        }
        this.isbn=isbn;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnoLibro() {
        return anoLibro;
    }

    public void setAnoLibro(int anoLibro) {
        this.anoLibro = anoLibro;
    }

    @Override
    public String toString(){
        return String.format("Libro: \"%s\"  \n Nombre del autor: %s \n ISBN: %s \n Año: %d",
                titulo, nombreAutor, isbn, anoLibro);


    }

    }

