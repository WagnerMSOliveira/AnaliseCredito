package com.cursoandroid.analisecredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button buttonLogin;
    private Button buttonCadastrar;
    private SharedPreferences preferencia;
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        //vinculando variáveis ao componentes xml
        editTextEmail = findViewById(R.id.edit_text_login_email);
        editTextSenha = findViewById(R.id.edit_text_login_senha);
        buttonLogin = findViewById(R.id.button_login);
        buttonCadastrar = findViewById(R.id.button_login_cadastrar);

        //recuperando dados de usuario cadastrado
        preferencia = getSharedPreferences(getString(R.string.chave_preferencias), Context.MODE_PRIVATE);
        if (preferencia.contains(Usuario.CHAVE_NOME)&& preferencia.contains(Usuario.CHAVE_EMAIL) && preferencia.contains(Usuario.CHAVE_SENHA)){
            usuario = new Usuario();
            usuario.setNome(preferencia.getString(Usuario.CHAVE_NOME, ""));
            usuario.setEmail(preferencia.getString(Usuario.CHAVE_EMAIL, ""));
            usuario.setSenha(preferencia.getString(Usuario.CHAVE_SENHA, ""));
        }
        //evento de click
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (usuario != null){
                    //capturando valores dos campos de texto
                    String email = editTextEmail.getText().toString();
                    String senha = editTextSenha.getText().toString();

                    //verificar se os valores foram digitados corretamente
                    if (email.isEmpty()){
                        editTextEmail.setError("Campo Obrigatorio");


                    }else if (senha.isEmpty()){
                        editTextSenha.setError("Campo Obrigatorio");


                    }else if (!senha.equals("123456")){
                        editTextSenha.setError("Senha Incorreta");

                    }else {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario não cadastrado!", Toast.LENGTH_SHORT).show();
                }


            }

        });

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criar uma intensão de ir para a tela de cadastro
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                //executar intensão
                startActivity(intent);
            }
        });

    }
}
