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
                    while (!Biblioteca.isbnValido(isbn)) {
                        System.out.println("ISBN inválido. Debe tener el formato 978/979-xx-xxxxx-xx-x. Escríbalo correctamente, por favor");
                        isbn = scanner.nextLine();
                    }
                    boolean agregarDuplicado = true;
                    for(Libro libroExistente : biblioteca.getCatalogo()){
                        if(libroExistente.getIsbn().equalsIgnoreCase(isbn)){
                            if(!libroExistente.getTitulo().equalsIgnoreCase(titulo) || !libroExistente.getNombreAutor().equalsIgnoreCase(autor)){
                                System.out.println("Ya existe ese ISBN pero con diferente título o autor");
                            }
                        }
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
                    int cantidadLibros= 0;
                    boolean cantidadIntroducida=false;
                    do{
                        System.out.println("¿Cuántos libros quieres añadir con estos datos?");
                        String entrada = scanner.nextLine();
                        try{
                            cantidadLibros = Integer.parseInt(entrada);
                            if(cantidadLibros <=0){
                                System.out.println("Ingrese un número mayor que 0");
                            }else{
                                cantidadIntroducida=true;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Ingresa un número válido por favor");
                        }
                    }while(!cantidadIntroducida);
                    for(int i = 0;i <cantidadLibros;i++) {
                        biblioteca.anadirLibro(new Libro(titulo, autor, isbn, anio));
                    }
                    System.out.println("Se añadió " + cantidadLibros + "libro(s)");
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
                    //Valida el formato
                    while(!Biblioteca.isbnValido(isbnEliminar)){
                        System.out.println("ISBN inválido. Debe tener el formato 978/979-xx-xxxxx-xx-x. Escríbalo correctamente, por favor");
                        isbnEliminar = scanner.nextLine();
                    }
                    int cantidadExistenteLibro=0;
                    for(Libro libro: biblioteca.getCatalogo()){
                        if(libro.getIsbn().equalsIgnoreCase(isbnEliminar)){
                            cantidadExistenteLibro++;
                        }
                    }
                    if (cantidadExistenteLibro == 0){
                        System.out.println("No hay ningún libro con el ISBN especificado");
                        break;
                    }
                    System.out.println("Se encontraron " + cantidadExistenteLibro + "libro(s) con el ISBN especificado");
                    int cantidadLibrosEliminar= 1;
                    if(cantidadExistenteLibro > 1) {
                        boolean cantidadValida = false;

                        do {
                            System.out.println("¿Cuántos libros deseas eliminar?");
                            String entradaEliminarLibros = scanner.nextLine();
                            try {
                                cantidadLibrosEliminar = Integer.parseInt(entradaEliminarLibros);
                                if (cantidadLibrosEliminar <= cantidadExistenteLibro && cantidadLibrosEliminar > 0) {
                                    cantidadValida = true;
                                } else {
                                    System.out.println("Debes introducir un número entre 1 y " + cantidadExistenteLibro);
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Por favor,introduce un número válido");
                            }
                        } while (!cantidadValida);
                    }
                    int eliminado=0;
                    for(int i =0;i < biblioteca.getCatalogo().size() -1 && eliminado < cantidadLibrosEliminar;i++){
                        Libro libro= biblioteca.getCatalogo().get(i);
                        if(libro.getIsbn().equalsIgnoreCase(isbnEliminar)){
                            biblioteca.getCatalogo().remove(i);
                            eliminado++;
                        }
                    }
                    System.out.println("Se eliminaron " + eliminado + " libro(s) con el ISBN " + isbnEliminar);
                    biblioteca.guardarCatalogo();
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
