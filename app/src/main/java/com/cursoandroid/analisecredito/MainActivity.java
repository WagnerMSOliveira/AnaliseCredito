package com.cursoandroid.analisecredito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaPropostas;
    private Button buttonSolicitarEmprestimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewListaPropostas = findViewById(R.id.recycler_view_main_lista_propostas);
        buttonSolicitarEmprestimo = findViewById(R.id.button_main_solicitar);
    }
}
