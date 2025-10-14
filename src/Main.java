import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion=0;

//Bucle principal que se repita hasta que el usuario elija salir
        do {
            //Códigos ANSI para los colores por consola
            final String amarillo = "\u001B[33m";
            final String azul = "\u001B[34m";
            final String verde = "\u001B[32m";
            final String cian = "\u001B[36m";
            final String rojo = "\u001B[31m";
            final String resetearColor = "\u001B[0m";
            //Menú de opciones
            System.out.println(resetearColor + "Seleccione una opción:");
            System.out.println(verde + "1. Añadir libro" + resetearColor);
            System.out.println(azul + "2. Listar libros" + resetearColor);
            System.out.println(amarillo + "3. Buscar libro por título" + resetearColor);
            System.out.println(cian + "4. Buscar autor" + resetearColor);
            System.out.println("5. Eliminar libro por isbn" + resetearColor);
            System.out.println(rojo + "6. Salir");
            // Verifica si lo que escribe el usuario es un número
            if (!scanner.hasNextInt()) {
                System.out.println("Opción no válida. Debe ingresar un número del 1 al 6.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            //Ejecuta la acción dependiendo de la opción elegida
            switch (opcion) {
                case 1:
                    //Añadir libro
                    System.out.println(resetearColor + "Autor:");
                    String autor = scanner.nextLine();

                    System.out.println("Título:");
                    String titulo = scanner.nextLine();

                    //Valida el formato del ISBN
                    System.out.println("ISBN formato 978/979-xx-xxxxx-xx-x:");
                    String isbn = scanner.nextLine();
                    while (!Biblioteca.isbnValido(isbn) || biblioteca.isbnExistente(isbn)) {
                        if (!Biblioteca.isbnValido(isbn)) {
                            System.out.println("ISBN inválido.Debe de tener el siguiente formato 978/979-xx-xxxxx-xx-x.Escríbalo con los números necesarios, porfavor");
                        } else if (biblioteca.isbnExistente(isbn)) {
                            System.out.println("Ya existe un libro con ese isbn. Escriba otro diferente porfavor");
                        }
                        isbn = scanner.nextLine();
                    }
                    //Valida el año de publicación, sólo permite libros publicados de 1850 en adelante
                    int anio = 0;
                    boolean valido = false;
                    do {
                        System.out.println("Año de publicación:");
                        String entrada = scanner.nextLine();
                        try {
                            anio = Integer.parseInt(entrada);
                            if (anio < 1850 ) {
                                System.out.println("El año debe de ser mayor  o igual que 1850");
                            } else if(anio > 2025 ){
                                System.out.println("El año debe de ser menor o igual que 2025");
                            }
                            else {
                                valido = true;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Ingresa un número válido porfavor");
                        }
                    } while (!valido);
                    biblioteca.anadirLibro(new Libro(titulo, autor, isbn, anio));
                    break;

                case 2:
                    //Listar libros
                    biblioteca.listarLibros();
                    break;
                case 3:
                    //Busca libros por título
                    System.out.println("Ingresa el título a buscar");
                    String tituloBuscar = scanner.nextLine();
                    biblioteca.buscarPorTitulo(tituloBuscar);
                    break;
                case 4:
                    //Busca libros por autor
                    System.out.println("Ingresa el nombre del autor a buscar");
                    String autorBuscar = scanner.nextLine();
                    biblioteca.buscarPorAutor(autorBuscar);
                    break;
                case 5:
                    //Eliminar libro por ISBN
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

        } while (opcion != 6);//el menú se repite hasta que el usuario elija salir
        scanner.close();

    }
}
