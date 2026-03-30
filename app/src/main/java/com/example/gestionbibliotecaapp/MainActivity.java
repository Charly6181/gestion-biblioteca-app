package com.example.gestionbibliotecaapp;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Biblioteca biblioteca;


    private EditText etTitulo, etAutor, etIsbnNuevo, etIsbnAccion;
    private TextView tvInventario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Inicializar la biblioteca
        biblioteca = new Biblioteca();

        // 2. Vincular componentes XML con Java
        vincularVistas();

        // 3. Configurar los eventos de los botones
        configurarBotones();
    }

    private void vincularVistas() {
        etTitulo = findViewById(R.id.etTitulo);
        etAutor = findViewById(R.id.etAutor);
        etIsbnNuevo = findViewById(R.id.etIsbnNuevo);
        etIsbnAccion = findViewById(R.id.etIsbnAccion);
        tvInventario = findViewById(R.id.tvInventario);
    }

    private void configurarBotones() {
        // Botón Añadir Libro
        findViewById(R.id.btnAnadir).setOnClickListener(v -> accionAnadirLibro());

        // Botón Prestar Libro
        findViewById(R.id.btnPrestar).setOnClickListener(v -> accionPrestarLibro());

        // Botón Devolver Libro
        findViewById(R.id.btnDevolver).setOnClickListener(v -> accionDevolverLibro());
    }

    private void accionAnadirLibro() {
        String titulo = etTitulo.getText().toString();
        String autor = etAutor.getText().toString();
        String isbnStr = etIsbnNuevo.getText().toString();

        if (titulo.isEmpty() || autor.isEmpty() || isbnStr.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        int isbn = Integer.parseInt(isbnStr);
        String mensaje = biblioteca.agregarLibro(titulo, autor, isbn);
        Toast.makeText(this, "Libro añadido correctamente.", Toast.LENGTH_SHORT).show();


        etTitulo.setText("");
        etAutor.setText("");
        etIsbnNuevo.setText("");
        actualizarInventario();
    }

    private void accionPrestarLibro() {
        String isbnStr = etIsbnAccion.getText().toString();
        if (isbnStr.isEmpty()) {
            Toast.makeText(this, "Introduce un ISBN.", Toast.LENGTH_SHORT).show();
            return;
        }

        int isbn = Integer.parseInt(isbnStr);
        String mensaje = biblioteca.prestarLibro(isbn);
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

        etIsbnAccion.setText("");
        actualizarInventario();
    }

    private void accionDevolverLibro() {
        String isbnStr = etIsbnAccion.getText().toString();
        if (isbnStr.isEmpty()) {
            Toast.makeText(this, "Introduce un ISBN.", Toast.LENGTH_SHORT).show();
            return;
        }

        int isbn = Integer.parseInt(isbnStr);
        String mensaje = biblioteca.devolverLibro(isbn);
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

        etIsbnAccion.setText("");
        actualizarInventario();
    }

    private void actualizarInventario() {
        tvInventario.setText(biblioteca.mostrarInventario());
    }
}