package br.com.grimoire.framework;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<PessoaEntity>{
        
       public PessoaEntity findByPrimeiroNome(String primeiroNome){
        return find("primeiroNome", primeiroNome).firstResult();
       }
}
