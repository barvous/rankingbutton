package br.com.grimoire.domain.exception;

public class BadRequestException extends CustomException {

        public BadRequestException(String message) {
                super(message, "BadRequestException", 400);
        }
}
