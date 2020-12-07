package fr.givemeacar.app.errorHandler;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public interface ControllerAdvisor {

    /**
     * Handles a DataIntegrityException
     * @param ex the exception
     * @param request the request
     * @return the ResponseEntity containing the Error handler
     */
    public ResponseEntity<Object> handleDataIntegrityException(ConstraintViolationException ex, WebRequest request);

    /**
     * Transforms the constraint message into a map
     * @param message the message to transform
     * @return the transformes message
     */
    public Map messageToMap(String message);

}
