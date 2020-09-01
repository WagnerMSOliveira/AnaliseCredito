package com.cursoandroid.analisecredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private EditText editTextConfirmeSenha;
    private Button buttonCadastrar;
    private SharedPreferences preferencia;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().setTitle("Cadastro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //vinculando variáveis ao componentes xml
        editTextNome = findViewById(R.id.edit_text_cadastro_nome);
        editTextEmail = findViewById(R.id.edit_text_cadastro_email);
        editTextSenha = findViewById(R.id.edit_text_cadastro_senha);
        editTextConfirmeSenha = findViewById(R.id.edit_text_cadastro_cofirme_senha);
        buttonCadastrar = findViewById(R.id.button_criar_cadastro);

        preferencia = getSharedPreferences(getString(R.string.chave_preferencias), Context.MODE_PRIVATE);

        //evento de click
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //capturando valores dos campos de texto
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();
                String confirmacaoSenha = editTextConfirmeSenha.getText().toString();

                //verificar se os valores foram digitados corretamente
                if (nome.isEmpty()){
                    editTextNome.setError("Campo Obrigatorio");

                }else if (email.isEmpty()){
                    editTextEmail.setError("Campo Obrigatorio");


                }else if (senha.isEmpty()){
                    editTextSenha.setError("Campo Obrigatorio");


                }else if (senha.length() != 6) {
                    editTextSenha.setError("A senha deve conter 6 digitos");

                }else if (!senha.equals(confirmacaoSenha)){
                    editTextConfirmeSenha.setError("Senhas não conferem");

                }else {
                    SharedPreferences.Editor editor = preferencia.edit();
                    editor.putString(Usuario.CHAVE_NOME,nome);
                    editor.putString(Usuario.CHAVE_EMAIL, email);
                    editor.putString(Usuario.CHAVE_SENHA, senha);
                    editor.commit();

                    Toast.makeText(getApplicationContext(),"Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home: //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                onBackPressed();
                break;
            default:break;
        }
        return true;
    }
}
