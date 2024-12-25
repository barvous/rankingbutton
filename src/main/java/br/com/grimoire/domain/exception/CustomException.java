package br.com.grimoire.domain.exception;

public abstract class CustomException extends RuntimeException {
        private final int statusCode;
        private final String error;

        public CustomException(String message, String error, int statusCode) {
                super(message);
                this.error = error;
                this.statusCode = statusCode;
        }

        public int getStatusCode() {
                return statusCode;
        }

        public String getError() {
                return error;
        }

}