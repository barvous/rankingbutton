package br.com.grimoire.application.exception;

import java.time.LocalDateTime;

import br.com.grimoire.domain.exception.CustomException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

        @Override
        public Response toResponse(CustomException exception) {
                return Response.status(exception.getStatusCode())
                                .entity(new ErrorResponse(exception.getMessage(), exception.getError(),
                                                exception.getStatusCode()))
                                .build();
        }

        public static class ErrorResponse {
                private String message;
                private int statusResponse;
                private LocalDateTime dataException;
                private String error;

                public ErrorResponse(String message, String error, int statusResponse) {
                        this.message = message;
                        this.error = error;
                        this.statusResponse = statusResponse;
                        this.dataException = LocalDateTime.now();
                }

                public String getMessage() {
                        return message;
                }

                public void setMessage(String message) {
                        this.message = message;
                }

                public int getStatusResponse() {
                        return statusResponse;
                }

                public void setStatusResponse(int statusResponse) {
                        this.statusResponse = statusResponse;
                }

                public LocalDateTime getDataException() {
                        return dataException;
                }

                public void setDataException(LocalDateTime dataException) {
                        this.dataException = dataException;
                }

                public String getError() {
                        return error;
                }

                public void setError(String error) {
                        this.error = error;
                }
        }
}