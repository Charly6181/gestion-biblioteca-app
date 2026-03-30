📚 Sistema de Gestión de Biblioteca en Java Un sistema de consola robusto diseñado en Java para la administración básica de un inventario bibliotecario. Este proyecto permite gestionar libros, controlar su disponibilidad (préstamos y devoluciones) y asegurar la integridad de los datos mediante validaciones de ISBN.

🚀 Funcionalidades Gestión de Inventario: Añadir nuevos libros con título, autor e ISBN único.

Control de Préstamos: Sistema para marcar libros como prestados, impidiendo que se presten si ya no están disponibles.

Sistema de Devoluciones: Restaurar la disponibilidad de los libros mediante su identificador único.

Buscador por ISBN: Localización rápida de ejemplares en la lista de la biblioteca.

Validación de Datos:  Control de duplicados (no permite dos libros con el mismo ISBN).

Manejo de excepciones (InputMismatchException) para evitar cierres inesperados al introducir datos no numéricos.

Validación de menús mediante expresiones regulares (RegEx).

🛠️ Estructura del Proyecto El código se organiza en tres clases principales dentro del paquete com.mycompany.sistemagestionbiblioteca:

Libro.java: Clase POJO que representa la entidad libro con sus atributos y lógica de estado (disponible/prestado).

Biblioteca.java: Actúa como el gestor de la colección, utilizando un ArrayList para almacenar y manipular los objetos Libro.

SistemaGestionBiblioteca.java: Clase principal que contiene el bucle del menú y la interacción directa con el usuario a través de la consola.
