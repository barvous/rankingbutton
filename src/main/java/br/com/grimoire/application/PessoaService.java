package br.com.grimoire.application;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import br.com.grimoire.domain.PessoaUseCases;
import br.com.grimoire.domain.Pessoa;
import br.com.grimoire.domain.exception.InternalServerException;
import br.com.grimoire.domain.exception.NotFoundException;
import br.com.grimoire.framework.PessoaEntity;
import br.com.grimoire.framework.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaService implements PessoaUseCases {

        @Inject
        PessoaRepository pessoaRepository;

        @Override
        public List<Pessoa> listarPessoas() {
                List<PessoaEntity> listaPessoaEntity = pessoaRepository.findAll().list();

                return listaPessoaEntity.stream().map(PessoaEntity::toPessoa).toList();

        }

        @Override
        public Pessoa buscarPessoaPeloId(Long id) {

                Optional<PessoaEntity> pessoaEntityDB = pessoaRepository.findByIdOptional(id);

                if (pessoaEntityDB.isEmpty()) {
                        throw new NotFoundException("Pessoa nao encontrada");
                }

                return pessoaEntityDB.get().toPessoa();
        }

        @Override
        public Pessoa buscarPessoaPeloPrimeiroNome(String primeiroNome) {

                PessoaEntity pessoaEntityDB = pessoaRepository.findByPrimeiroNome(primeiroNome);

                if (pessoaEntityDB == null) {
                        throw new NotFoundException("Pessoa nao encontrada");
                }

                return pessoaEntityDB.toPessoa();
        }

        @Override
        @Transactional
        public Pessoa salvarPessoa(Pessoa pessoa) {
                PessoaEntity pessoaEntity = new PessoaEntity(pessoa);

                pessoaRepository.persist(pessoaEntity);

                return pessoaEntity.toPessoa();
        }

        @Override
        @Transactional
        public void atualizarPessoa(Long id, Pessoa pessoa) {
                PessoaEntity pessoaEntity = new PessoaEntity(pessoa);

                Optional<PessoaEntity> pessoaEntityOptional = pessoaRepository.findByIdOptional(id);

                if (pessoaEntityOptional.isEmpty()) {
                        throw new NotFoundException("Pessoa nao encontrada");
                }

                PessoaEntity pessoaEntityDB = pessoaEntityOptional.get();

                try {
                        BeanUtils.copyProperties(pessoaEntityDB, pessoaEntity);
                } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        throw new InternalServerException(
                                        "Falha ao atualizar a pessoa no banco de dados: " +
                                                        e.getLocalizedMessage());

                }

                System.out.println(pessoaEntityDB);

                pessoaEntityDB.setId(id);
                pessoaRepository.persist(pessoaEntityDB);
        }

        @Override
        @Transactional
        public void deletarPessoaPeloId(Long id) {
                buscarPessoaPeloId(id);

                pessoaRepository.deleteById(id);
        }

}
