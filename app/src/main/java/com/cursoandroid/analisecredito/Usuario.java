package com.cursoandroid.analisecredito;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    public static final String CHAVE_NOME = "chaveNome";
    public static final String CHAVE_EMAIL = "chaveEmail";
    public static final String CHAVE_SENHA = "chaveSenha";
    public static final String CHAVE_LISTA_PROPOSTAS = "chaveListaPropostas";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
