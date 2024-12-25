package br.com.grimoire.application;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import br.com.grimoire.domain.IPessoa;
import br.com.grimoire.domain.Pessoa;
import br.com.grimoire.domain.exception.InternalServerException;
import br.com.grimoire.framework.PessoaEntity;
import br.com.grimoire.framework.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PessoaUserCases implements IPessoa {

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
        public Pessoa salvarPessoa(Pessoa pessoa) {
                PessoaEntity pessoaEntity = new PessoaEntity(pessoa);

                Long nextId = pessoaRepository.count() + 1L;
                pessoaEntity.setId(nextId);

                pessoaRepository.persist(pessoaEntity);

                return pessoaEntity.toPessoa();
        }

        @Override
        public void atualizarPessoa(Long id, Pessoa pessoa) {
                PessoaEntity pessoaEntity = new PessoaEntity(pessoa);

                PessoaEntity pessoaEntityDB = new PessoaEntity(buscarPessoaPeloId(id));

                try {
                        BeanUtils.copyProperties(pessoaEntityDB, pessoaEntity);
                } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        throw new InternalServerException(
                                        "Falha ao atualizar a pessoa no banco de dados: " +
                                                        e.getLocalizedMessage());

                }

                pessoaRepository.persist(pessoaEntityDB);
        }

        @Override
        public void deletarPessoaPeloId(Long id) {
                buscarPessoaPeloId(id);

                pessoaRepository.deleteById(id);
        }

}
