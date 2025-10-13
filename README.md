1-NOMBRE DEL PROYECTO 
  Biblioteca virtual-Gestión de una biblioteca en java
2-BREVE EXPLICACIÓN DEL PROYECTO
El proyecto es una aplicación de consola en java para la gestión de una biblioteca. Permite añadir libros, listar libros,buscar libros por título, buscar autor por nombre y eliminar libros.
  3-DETALLES DE LA APLICACIÓN
    El proyecto permite:
      -Añadir libros con título,autor,isbn y año de publicación.
      -Valida que el formato de isbn sea correcto y no esté repetido.
      -Valida que el año de publicación del libro sea del 1850 en adelante
      -Listar los libros de la biblioteca.
      -Buscar libros por título.
      -Buscar autor por nombre y muestra todos los libros asociados a ese autor.
      -Uso de scanner para interactuar con el usuario mediante consola y captar los datos introducidos por el usuario.
      -Uso de la librería Gson para guardar y cargar los datos en un JSON.
4-REQUISITOS 
      -Java 17
      -IntelliJ
      -Gson si quieres almacenar y leer los datos del archivo JSON.
5-ESTRUCTURA DEL PROYECTO 
C:\Users\Formacion\IdeaProjects\Biblioteca\Biblioteca>tree /F /A
Listado de rutas de carpetas para el volumen Windows
El número de serie del volumen es 8449-04B3
C:.
|   .gitignore
|   Biblioteca.iml
|   Biblioteca.java
|   Libro.java
|   Main.java
|   README.md
|
+---.idea
|   |   .gitignore
|   |   misc.xml
|   |   modules.xml
|   |   vcs.xml
|   |   workspace.xml
|   |
|   \---libraries
|           gson_2_11_0.xml
|
+---out
|   \---production
|       \---Biblioteca
|               Biblioteca$1.class
|               Biblioteca.class
|               Libro.class
|               Main.class
|
\---src
        Biblioteca.java
        Libro.java
        Main.java
6-USO DEL PROYECTO
    1-Menú de opciones 
    2-Ejemplo de añadir el libro 
    3-Ejemplo de listar libros
    4-Ejemplo de buscar un libro por título
    5-Ejemplo de buscar un autor por nombre y que salgan todos sus libros
    6-Ejemplo de eliminar un libro por su isbn
7-VALIDACIONES
  -Sólo se permiten libros publicados en 1850 o a partir de 1850.
  -Sólo se permite isbn con este formato 978-xx-xxxxx-xx-x
  -En caso de ingresar texto donde se espera un número, se solicita reingresar.





  
