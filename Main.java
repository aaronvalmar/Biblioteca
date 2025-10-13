import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;


        do {
            final String amarillo = "\u001B[33m";
            final String azul = "\u001B[34m";
            final String verde = "\u001B[32m";
            final String cian = "\u001B[36m";
            final String rojo = "\u001B[31m";
            final String resetearColor="\u001B[0m";
            System.out.println(resetearColor + "Seleccione una opción:");
            System.out.println( verde + "1. Añadir libro" + resetearColor);
            System.out.println(azul + "2. Listar libros" + resetearColor);
            System.out.println(amarillo + "3. Buscar libro por título"  + resetearColor);
            System.out.println(cian + "4. Buscar autor"  + resetearColor);
            System.out.println("5. Eliminar libro por isbn"  + resetearColor);
            System.out.println(rojo +"6. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println(resetearColor + "Autor:");
                    String autor = scanner.nextLine();

                    System.out.println("Título:");
                    String titulo = scanner.nextLine();

                    System.out.println("ISBN formato 978-xx-xxxxx-xx-x:");
                    String isbn = scanner.nextLine();
                    while(!Biblioteca.isbnValido(isbn) || biblioteca.isbnExistente(isbn)){
                        if(!Biblioteca.isbnValido(isbn)){
                        System.out.println("ISBN inválido.Debe de tener el siguiente formato 978-xx-xxxxx-xx-x.Escríbalo con los números necesarios, porfavor");
                    }else if(biblioteca.isbnExistente(isbn)){
                            System.out.println("Ya existe un libro con ese isbn. Escriba otro diferente porfavor");
                        }
                        isbn= scanner.nextLine();
                    }
                    int anio=0;
                    boolean valido=false;
                    do{
                         System.out.println("Año de publicación:");
                         String entrada=scanner.nextLine();
                    try{
                         anio = Integer.parseInt(entrada);
                            if (anio >= 1850) {
                                valido = true;
                            } else {
                                System.out.println("El año debe de ser mayor que 1850");
                            }

                        }catch(NumberFormatException e){
                            System.out.println("Ingresa un número válido porfavor");
                        }
                    }while(!valido);
                    biblioteca.anadirLibro(new Libro(titulo,autor, isbn, anio));
                    break;
                case 2:
                    biblioteca.listarLibros();
                    break;
                case 3:
                    System.out.println("Ingresa el título a buscar");
                    String tituloBuscar = scanner.nextLine();
                    biblioteca.buscarPorTitulo(tituloBuscar);
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del autor a buscar");
                    String autorBuscar = scanner.nextLine();
                    biblioteca.buscarPorTitulo(autorBuscar);
                    break;
                case 5:
                    System.out.println("Ingresa el isbn del libro que quieres eliminar");
                    String isbnEliminar = scanner.nextLine();
                    biblioteca.eliminarLibro(isbnEliminar);
                    break;
                case 6:
                    biblioteca.guardarCatalogo();
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida");

            }
        } while (opcion != 6);
        scanner.close();

    }
}
