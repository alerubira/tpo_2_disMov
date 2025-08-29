package libroEncontrado;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Modelo.Libro;

public class LibroEncontradoViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> mutableLibroEncontrado;
    public LibroEncontradoViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Libro> getmutableLibroEncontrado(){
        if(mutableLibroEncontrado==null){
            mutableLibroEncontrado=new MutableLiveData<>();
        }
        return mutableLibroEncontrado;
    }
    public void cargarLibro(Intent intent){
        Libro l = (Libro) intent.getSerializableExtra("libroSeleccionado");

        if (l != null) {
            mutableLibroEncontrado.setValue(l);
        }
    }
}
