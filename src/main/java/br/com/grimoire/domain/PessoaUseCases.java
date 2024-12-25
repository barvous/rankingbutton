package br.com.grimoire.domain;

import java.util.List;

public interface PessoaUseCases {

        List<Pessoa> listarPessoas();

        Pessoa buscarPessoaPeloId(Long id);

        Pessoa salvarPessoa(Pessoa pessoa);
        
        void atualizarPessoa(Long id, Pessoa pessoa);

        void deletarPessoaPeloId(Long id);

        Integer incrementarClique(Long idPessoa, Integer cliquesParaAdicionar);
}
