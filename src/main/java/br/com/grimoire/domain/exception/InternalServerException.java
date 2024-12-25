package br.com.grimoire.domain.exception;

public class InternalServerException extends CustomException {
 
        public InternalServerException(String message) {
                super(message, "InternalServerException", 500);
        }
}
