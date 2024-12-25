package br.com.grimoire;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa>{
        
       Pessoa findByPrimeiroNome(String primeiroNome){
        return find("primeiroNome", primeiroNome).firstResult();
       }
}
