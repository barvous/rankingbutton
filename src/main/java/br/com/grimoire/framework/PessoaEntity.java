package br.com.grimoire.framework;

import br.com.grimoire.domain.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class PessoaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pessoa")
        private Long id;

        @Column(name = "codigo_integracao_pessoa")
        private String codigoIntegracao;

        @Column(name = "apelido_pessoa")
        private String apelido;

        @Column(name = "primeiro_nome_pessoa")
        private String primeiroNome;

        @Column(name = "ultimo_nome_pessoa")
        private String ultimoNome;

        @Column(name = "quantidade_clique_total_pessoa")
        private Integer quantidadeCliqueTotal;

        public PessoaEntity() {
        }

        public PessoaEntity(Long id, String codigoIntegracao, String apelido, String primeiroNome, String ultimoNome,
                        Integer quantidadeCliqueTotal) {
                this.id = id;
                this.codigoIntegracao = codigoIntegracao;
                this.apelido = apelido;
                this.primeiroNome = primeiroNome;
                this.ultimoNome = ultimoNome;
                this.quantidadeCliqueTotal = quantidadeCliqueTotal;
        }

        public PessoaEntity(Pessoa pessoa) {
                this.id = pessoa.getId();
                this.codigoIntegracao = pessoa.getCodigoIntegracao();
                this.apelido = pessoa.getApelido();
                this.primeiroNome = pessoa.getPrimeiroNome();
                this.ultimoNome = pessoa.getUltimoNome();
                this.quantidadeCliqueTotal = pessoa.getQuantidadeCliqueTotal();
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCodigoIntegracao() {
                return codigoIntegracao;
        }

        public void setCodigoIntegracao(String codigoIntegracao) {
                this.codigoIntegracao = codigoIntegracao;
        }

        public String getApelido() {
                return apelido;
        }

        public void setApelido(String apelido) {
                this.apelido = apelido;
        }

        public String getPrimeiroNome() {
                return primeiroNome;
        }

        public void setPrimeiroNome(String primeiroNome) {
                this.primeiroNome = primeiroNome;
        }

        public String getUltimoNome() {
                return ultimoNome;
        }

        public void setUltimoNome(String ultimoNome) {
                this.ultimoNome = ultimoNome;
        }

        public Integer getQuantidadeCliqueTotal() {
                return quantidadeCliqueTotal;
        }

        public void setQuantidadeCliqueTotal(Integer quantidadeCliqueTotal) {
                this.quantidadeCliqueTotal = quantidadeCliqueTotal;
        }

        public Pessoa toPessoa() {
                return new Pessoa(this.id, this.codigoIntegracao, this.apelido, this.primeiroNome, this.ultimoNome,
                                this.quantidadeCliqueTotal);
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((id == null) ? 0 : id.hashCode());
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                PessoaEntity other = (PessoaEntity) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                return true;
        }

        @Override
        public String toString() {
                return "PessoaEntity [id=" + id + ", codigoIntegracao=" + codigoIntegracao + ", apelido=" + apelido
                                + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome
                                + ", quantidadeCliqueTotal=" + quantidadeCliqueTotal + "]";
        }

}
