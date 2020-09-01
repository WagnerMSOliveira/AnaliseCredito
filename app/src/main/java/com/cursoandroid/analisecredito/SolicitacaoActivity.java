package com.cursoandroid.analisecredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;

public class SolicitacaoActivity extends AppCompatActivity {

    private RadioButton radioButtonPessoal;
    private RadioButton radioButtonGarantia;
    private RadioButton radioButtonConsignado:
    private EditText editTextValor;
    private EditText editTextParcelas;
    private TextView textViewTaxa;
    private TextView textViewValorTotal;
    private TextView textViewValorParcela;
    private Button buttonConfirmar;
    private SharedPreferences preferencia;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

        //vinculando variáveis e componentes xml
        radioButtonPessoal = findViewById(R.id.radio_button_solicitacao_emprestimo_pessoal);
        radioButtonGarantia = findViewById(R.id.radio_button_solicitacao_emprestimo_garantia);
        radioButtonConsignado = findViewById(R.id.radio_button_solicitacao_emprestimo_consignado);
        editTextValor = findViewById(R.id.edit_text_solicitacao_emprestimo_valor);
        editTextParcelas = findViewById(R.id.edit_text_solicitacao_emprestimo_parcelas);
        textViewTaxa = findViewById(R.id.text_view_solicitacao_emprestimo_taxa);
        textViewValorTotal = findViewById(R.id.text_view_solicitacao_emprestimo_valor_total);
        textViewValorParcela = findViewById(R.id.text_view_solicitacao_emprestimo_valor_parcela);
        buttonConfirmar = findViewById(R.id.button_solicitacao_emprestimo_confirmar);

        //recuperando dados de usuario cadastrado
        preferencia = getSharedPreferences(getString(R.string.chave_preferencias), Context.MODE_PRIVATE);
        usuario = new Usuario();
        if (preferencia.contains(Usuario.CHAVE_NOME)&& preferencia.contains(Usuario.CHAVE_EMAIL) && preferencia.contains(Usuario.CHAVE_SENHA)){
            usuario.setNome(preferencia.getString(Usuario.CHAVE_NOME, ""));
            usuario.setEmail(preferencia.getString(Usuario.CHAVE_EMAIL, ""));
            usuario.setSenha(preferencia.getString(Usuario.CHAVE_SENHA, ""));
        }
        if (preferencia.contains(Usuario.CHAVE_LISTA_PROPOSTAS)){
            String propostasJson = preferencia.getString(Usuario.CHAVE_LISTA_PROPOSTAS, "");
            Gson formatador = new Gson();
            formatador.fromJson(propostasJson,Emprestimo.class);
        }
    }
}
