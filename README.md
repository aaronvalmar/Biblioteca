1-NOMBRE DEL PROYECTO 
  Biblioteca virtual-Gestión de una biblioteca en java
2-BREVE EXPLICACIÓN DEL PROYECTO
El proyecto es una aplicación de consola en java para la gestión de una biblioteca. Permite añadir libros, listar libros,buscar libros por título, buscar autor por nombre y eliminar libros:
      -Añadir libros con título,autor,isbn y año de publicación.
      -Valida que el formato de isbn sea correcto y no esté repetido.
      -Valida que el año de publicación del libro sea del 1850 en adelante
      -Listar los libros de la biblioteca.
      -Buscar libros por título.
      -Buscar autor por nombre y muestra todos los libros asociados a ese autor.
      -Uso de scanner para interactuar con el usuario mediante consola y captar los datos introducidos por el usuario.
      -Uso de la librería Gson para guardar y cargar los datos en un JSON.
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
<img width="559" height="606" alt="image" src="https://github.com/user-attachments/assets/55fca558-f394-4ebb-bbe0-90e52f74e633" />
6-USO DEL PROYECTO
    1-Menú de opciones 
      <img width="299" height="238" alt="image" src="https://github.com/user-attachments/assets/c471628f-7068-469c-841c-9e3829342d69" />
    2-Ejemplo de añadir el libro 
      <img width="555" height="284" alt="image" src="https://github.com/user-attachments/assets/dbf44235-917e-4448-a8c6-313b38fd181e" />
    3-Ejemplo de listar libros
       <img width="463" height="169" alt="image" src="https://github.com/user-attachments/assets/307540c9-246a-42b0-8f43-04ffe7ace5a4" />
    4-Ejemplo de buscar un libro por título
      <img width="506" height="198" alt="image" src="https://github.com/user-attachments/assets/cb6df5e4-32ad-470b-b7e0-12d3b298713c" />
    5-Ejemplo de buscar un autor por nombre y que salgan todos sus libros
      <img width="433" height="191" alt="image" src="https://github.com/user-attachments/assets/b295a0dc-bbbb-4583-bfa9-bdef6e454794" />
    6-Ejemplo de eliminar un libro por su isbn
      <img width="1026" height="171" alt="image" src="https://github.com/user-attachments/assets/555af990-55f0-4223-a9b0-236e9c8adafb" />
7-VALIDACIONES
  -Sólo se permiten libros publicados en 1850 o a partir de 1850.
  -Sólo se permite isbn con este formato 978-xx-xxxxx-xx-x
  -En caso de ingresar texto donde se espera un número, se solicita reingresar.





  
