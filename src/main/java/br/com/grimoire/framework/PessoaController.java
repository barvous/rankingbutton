package br.com.grimoire.framework;

import br.com.grimoire.domain.Pessoa;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pessoas")
public class PessoaController {

        @Inject
        PessoaRepository pessoaRepository;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String buscarPessoaPeloPrimeiroNome(@QueryParam("primeiro_nome") String primeiroNome) {
                Pessoa pessoa = pessoaRepository.findByPrimeiroNome(primeiroNome).toPessoa();

                if (pessoa == null) {
                        return "null";
                } else {

                        return pessoa.getPrimeiroNome();
                }
        }
}
