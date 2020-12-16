package fr.givemeacar.app.errorHandler;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
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
     * Handles a TruncationException
     * @param ex the exception
     * @param request the request
     * @return the ResponseEntity containing the Error handler
     */
    public ResponseEntity<Object> handleTruncationException(DataException ex,WebRequest request);


    /**
     * Transforms the constraintException message into a map
     * @param message the message to transform
     * @return the transformes message
     */
    public Map constraintToMap(String message);


    /**
     * Transforms the truncationException message into a map
     * @param message the message to transform
     * @return the transformes message
     */
    public Map truncationToMap(String message);

}
