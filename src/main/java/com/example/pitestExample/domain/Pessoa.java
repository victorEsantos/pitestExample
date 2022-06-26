package com.example.pitestExample.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
public class Pessoa {
    private String nome;
    private int idade;

    private Nacionalidade nacionalidade;

    private boolean isAtivo;

    @Builder
    public Pessoa(String nome, int idade, Nacionalidade nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.isAtivo = true;
    }

    public void alterar(String nome, int idade, Nacionalidade nacionalidade) {

        validarIsAtivo();

        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.isAtivo = true;
    }

    private void validarIsAtivo() {
        if (this.isAtivo() == false) {
            throw new RuntimeException();
        }
    }

    public void inativar() {
        this.isAtivo = false;
    }

}
