package br.com.grimoire.framework;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pessoas")
public class PessoaController {

        @Inject
        PessoaRepository pessoaRepository;

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String hello() {
                PessoaEntity pessoa = pessoaRepository.findByPrimeiroNome("marcos");
                if (pessoa == null) {
                        return "null";
                } else {

                        return pessoa.getPrimeiroNome();
                }
        }
}
