package com.example.gestionbibliotecaapp;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Libro> inventario;

    public Biblioteca() {
        this.inventario = new ArrayList<>();
    }

    public String agregarLibro(String titulo, String autor, int isbn) {
        if (buscarLibro(isbn) != null) {
            return "Error: Ya existe un libro con el ISBN " + isbn;
        }
        inventario.add(new Libro(titulo, autor, isbn));
        return "El libro " + titulo + " añadido correctamente.";
    }

    public String mostrarInventario() {
        if (inventario.isEmpty()) {
            return "El inventario está vacío.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Libros en el inventario:\n\n");
        for (Libro libro : inventario) {
            sb.append(libro.mostrar());
        }
        return sb.toString();
    }

    public String prestarLibro(int isbn) {
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            return libro.prestar();
        } else {
            return "Error: El ISBN " + isbn + " no existe.";
        }
    }

    public String devolverLibro(int isbn) {
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            return libro.devolver();
        } else {
            return "Error: El ISBN " + isbn + " no existe.";
        }
    }

    private Libro buscarLibro(int isbn) {
        for (Libro libro : inventario) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }
}