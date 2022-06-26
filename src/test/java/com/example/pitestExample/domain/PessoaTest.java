package com.example.pitestExample.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PessoaTest {

    @Test
    @DisplayName("Deve criar com sucesso uma instancia de uma pessoa")
    void deveCriarUmaInstanciaDePessoa() {
        var pessoa = Pessoa
            .builder()
            .nome("Name name")
            .idade(17)
            .nacionalidade(Nacionalidade.NATIVO)
            .build();

        Assertions.assertEquals("Name name", pessoa.getNome());
        Assertions.assertEquals(17, pessoa.getIdade());
        Assertions.assertEquals(Nacionalidade.NATIVO, pessoa.getNacionalidade());
        Assertions.assertTrue(pessoa.isAtivo());

    }

    @Test
    @DisplayName("Não deve alterar uma pessoa inativa")
    void naoDeveAlterarUmaPessoaInativa() {
        var pessoa = Pessoa
            .builder()
            .nome("Name name")
            .idade(17)
            .nacionalidade(Nacionalidade.NATIVO)
            .build();

        pessoa.inativar();

        assertThrows(RuntimeException.class, () -> pessoa.alterar("name", 18, Nacionalidade.NATIVO));

    }

    @Test
    @DisplayName("Deve alterar com sucesso  uma pessoa")
    void deveAlterarUmaPessoa() {
        var pessoa = Pessoa
            .builder()
            .nome("Name name")
            .idade(17)
            .nacionalidade(Nacionalidade.NATIVO)
            .build();

        pessoa.alterar("Name", 18, Nacionalidade.NATIVO);

        Assertions.assertEquals("Name", pessoa.getNome());
        Assertions.assertEquals(18, pessoa.getIdade());
        Assertions.assertEquals(Nacionalidade.NATIVO, pessoa.getNacionalidade());
        Assertions.assertTrue(pessoa.isAtivo());

    }
}
