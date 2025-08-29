package com.example.tpo2dispmov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo2dispmov.databinding.ActivityMainBinding;

import java.util.ArrayList;

import Modelo.Libro;
import libroEncontrado.LibroEncontradoActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel=new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getMutableMensaje().observe(this,mensage->{
            binding.tVNoEncontrado.setText(mensage);
        });
        viewModel.getmutableLibro().observe(this,libro->{
            Intent intent=new Intent(this, LibroEncontradoActivity.class);
            intent.putExtra("libroSeleccionado",libro);
            startActivity(intent);
        });
        viewModel.traerLibros();
        binding.btnBuscar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                viewModel.seleccionarLibroPorTitulo(binding.eTTitulo.getText().toString());
            }
        });

    }


}