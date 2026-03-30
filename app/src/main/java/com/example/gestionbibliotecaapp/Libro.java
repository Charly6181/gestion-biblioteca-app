package com.example.gestionbibliotecaapp;


public class Libro {
    private final String titulo;
    private final String autor;
    private final int isbn;
    private boolean disponible;

    public Libro(String titulo, String autor, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    public String prestar() {
        if (disponible) {
            disponible = false;
            return "Libro prestado con éxito.";
        } else {
            return "El libro no está disponible.";
        }
    }

    public String devolver() {
        if (!disponible) {
            disponible = true;
            return "Devolución correcta.";
        } else {
            return "No se puede devolver (el libro ya está disponible).";
        }
    }

    public String mostrar() {
        return "Título: " + titulo + " | Autor: " + autor + " | ISBN: " + isbn + " | Disponible: " + (disponible ? "Sí" : "No") + "\n\n";
    }

    public int getIsbn() {
        return isbn;
    }
}