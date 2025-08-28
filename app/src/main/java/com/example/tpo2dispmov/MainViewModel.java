package com.example.tpo2dispmov;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import Modelo.Libro;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<String> mutableMensaje;
    private MutableLiveData<Libro> mutableLibro;
    private ArrayList<Libro> libros=new ArrayList<>();
    private Libro libroSeleccionado;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<String> getMutableMensaje() {
        if (mutableMensaje == null){
            mutableMensaje = new MutableLiveData<>();
        }
        return mutableMensaje;
    }

    public LiveData<Libro> getmutableLibro() {
        if (mutableLibro == null){
            mutableLibro = new MutableLiveData<>();
        }
        return mutableLibro;
    }
    public void traerLibros(){
        libros.clear(); // por si ya había libros antes

        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 471, "Obra maestra del realismo mágico"));
        libros.add(new Libro("El Quijote", "Miguel de Cervantes", 863, "Clásico de la literatura española"));
        libros.add(new Libro("1984", "George Orwell", 328, "Distopía sobre un futuro totalitario"));
        libros.add(new Libro("Crimen y castigo", "Fiódor Dostoievski", 671, "Reflexión sobre la moral y la justicia"));
        libros.add(new Libro("La Odisea", "Homero", 400, "Viaje épico de Odiseo"));
        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen", 432, "Romance y crítica social"));
        libros.add(new Libro("Fahrenheit 451", "Ray Bradbury", 249, "Mundo donde los libros están prohibidos"));
        libros.add(new Libro("El señor de los anillos", "J.R.R. Tolkien", 1216, "Aventura épica en la Tierra Media"));
        libros.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 223, "Inicio de la saga mágica"));
        libros.add(new Libro("Don Juan Tenorio", "José Zorrilla", 200, "Clásico del teatro español"));
    }
    public void seleccionarLibroPorTitulo(String titulo) {
        libroSeleccionado = null;

        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                libroSeleccionado = l;
                break;
            }
        }
        if(libroSeleccionado!=null){
            mutableLibro.setValue(libroSeleccionado);
        }else{
            mutableMensaje.setValue("El Libro Ingresado no se encuentra en estock");
        }
    }
}
