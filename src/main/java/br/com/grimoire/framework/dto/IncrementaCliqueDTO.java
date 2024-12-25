package br.com.grimoire.framework.dto;

public class IncrementaCliqueDTO {

        private Integer cliqueIncrement;

        public IncrementaCliqueDTO() {
        }

        public IncrementaCliqueDTO(Integer cliqueIncrement) {
                this.cliqueIncrement = cliqueIncrement;
        }

        public Integer getCliqueIncrement() {
                return cliqueIncrement;
        }

        public void setCliqueIncrement(Integer cliqueIncrement) {
                this.cliqueIncrement = cliqueIncrement;
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((cliqueIncrement == null) ? 0 : cliqueIncrement.hashCode());
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
                IncrementaCliqueDTO other = (IncrementaCliqueDTO) obj;
                if (cliqueIncrement == null) {
                        if (other.cliqueIncrement != null)
                                return false;
                } else if (!cliqueIncrement.equals(other.cliqueIncrement))
                        return false;
                return true;
        }

        @Override
        public String toString() {
                return "IncrementarCliqueDTO [cliqueIncrement=" + cliqueIncrement + "]";
        }
}
