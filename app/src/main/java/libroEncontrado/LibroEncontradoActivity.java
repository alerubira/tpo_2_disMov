package libroEncontrado;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo2dispmov.MainViewModel;
import com.example.tpo2dispmov.R;
import com.example.tpo2dispmov.databinding.ActivityLibroEncontradoBinding;
import com.example.tpo2dispmov.databinding.ActivityMainBinding;

public class LibroEncontradoActivity extends AppCompatActivity {
    private ActivityLibroEncontradoBinding binding;
    private LibroEncontradoViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityLibroEncontradoBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(LibroEncontradoViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        viewModel.getmutableLibroEncontrado().observe(this,libro->{
            binding.tVTitulo.setText("Titulo:"+libro.getTitulo());
            binding.tVAutor.setText("Autor :"+libro.getAutor());
            binding.tVPaginas.setText("Cantidad de paginas"+String.valueOf(libro.getPaginas()));
            binding.tVresenia.setText("Breve reseña : "+libro.getResenia());
        });
        viewModel.cargarLibro(getIntent());
    }
}