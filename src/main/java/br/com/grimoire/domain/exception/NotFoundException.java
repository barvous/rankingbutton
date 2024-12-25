package br.com.grimoire.domain.exception;

public class NotFoundException extends CustomException {

        public NotFoundException(String message) {
                super(message, "NotFoundException", 404);
        }
}
