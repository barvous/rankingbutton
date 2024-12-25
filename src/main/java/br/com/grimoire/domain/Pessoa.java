package br.com.grimoire.domain;

import br.com.grimoire.domain.exception.BadRequestException;

public class Pessoa {

        private Long id;

        private String codigoIntegracao;

        private String apelido;

        private String primeiroNome;

        private String ultimoNome;

        private Integer quantidadeCliqueTotal;

        public Pessoa() {
        }

        public Pessoa(Long id, String codigoIntegracao, String apelido, String primeiroNome, String ultimoNome,
                        Integer quantidadeCliqueTotal) {
                this.id = id;
                this.codigoIntegracao = codigoIntegracao;
                this.apelido = apelido;
                this.primeiroNome = primeiroNome;
                this.ultimoNome = ultimoNome;
                this.quantidadeCliqueTotal = quantidadeCliqueTotal;
        }

        public Integer incrementaCliques(Integer cliquesParaAdicionar) {

                if (cliquesParaAdicionar == null) {
                        throw new BadRequestException("quantidade de cliques para adicionar inválida");
                }

                Integer novoTotalDeCliques = quantidadeCliqueTotal + cliquesParaAdicionar;

                setQuantidadeCliqueTotal(novoTotalDeCliques);

                return getQuantidadeCliqueTotal();
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {

                if (id == null || id < 0) {
                        throw new BadRequestException("O parametro 'id' é inválido");
                }

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

                if (apelido == null || apelido.isBlank()) {
                        throw new BadRequestException("O parametro 'apelido' é obrigatorio");
                }

                this.apelido = apelido;
        }

        public String getPrimeiroNome() {
                return primeiroNome;
        }

        public void setPrimeiroNome(String primeiroNome) {

                if (primeiroNome == null || primeiroNome.isBlank()) {
                        throw new BadRequestException("O parametro 'primeiro_nome' é obrigatorio");
                }

                this.primeiroNome = primeiroNome;
        }

        public String getUltimoNome() {
                return ultimoNome;
        }

        public void setUltimoNome(String ultimoNome) {

                if (ultimoNome == null || ultimoNome.isBlank()) {
                        throw new BadRequestException("O parametro 'ultimo_nome' é obrigatorio");
                }

                this.ultimoNome = ultimoNome;
        }

        public Integer getQuantidadeCliqueTotal() {
                return quantidadeCliqueTotal;
        }

        public void setQuantidadeCliqueTotal(Integer quantidadeCliqueTotal) {
                this.quantidadeCliqueTotal = quantidadeCliqueTotal;
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
                Pessoa other = (Pessoa) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                return true;
        }

        @Override
        public String toString() {
                return "Pessoa [id=" + id + ", codigoIntegracao=" + codigoIntegracao + ", apelido=" + apelido
                                + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome
                                + ", quantidadeCliqueTotal=" + quantidadeCliqueTotal + "]";
        }

}
