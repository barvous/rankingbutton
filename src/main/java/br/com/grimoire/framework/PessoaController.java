package br.com.grimoire.framework;

import java.util.List;

import br.com.grimoire.domain.Pessoa;
import br.com.grimoire.domain.PessoaUseCases;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pessoas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaController {

        @Inject
        PessoaUseCases pessoaUserCases;

        @GET
        public Response listarTodos() {
                List<Pessoa> listaPessoa = pessoaUserCases.listarPessoas();

                System.out.println(listaPessoa);

                return Response.status(Response.Status.OK).entity(listaPessoa).build();
        }

        @GET
        @Path("/{id_pessoa}")
        public Response buscarPeloId(@PathParam("id_pessoa") Long idPessoa) {
                Pessoa pessoa = pessoaUserCases.buscarPessoaPeloId(idPessoa);

                return Response.status(Response.Status.OK).entity(pessoa).build();
        }

        @GET
        @Path("/filter")
        public Response buscarPessoaPeloPrimeiroNome(@QueryParam("primeiro_nome") String primeiroNome) {
                Pessoa pessoa = pessoaUserCases.buscarPessoaPeloPrimeiroNome(primeiroNome);

                return Response.status(Response.Status.OK).entity(pessoa).build();
        }

        @POST
        public Response salvarPessoa(Pessoa pessoa) {

                Pessoa pessoaDB = pessoaUserCases.salvarPessoa(pessoa);

                return Response.status(Response.Status.CREATED).entity(pessoaDB).build();
        }

        @PUT
        @Path("/{id_pessoa}")
        public Response salvarPessoa(@PathParam("id_pessoa") Long idPessoa, Pessoa pessoa) {

                pessoaUserCases.atualizarPessoa(idPessoa, pessoa);

                return Response.status(Response.Status.OK).build();
        }

        @DELETE
        @Path("/{id_pessoa}")
        public Response deletarPessoa(@PathParam("id_pessoa") Long idPessoa) {

                pessoaUserCases.deletarPessoaPeloId(idPessoa);

                return Response.status(Response.Status.NO_CONTENT).build();
        }
}
