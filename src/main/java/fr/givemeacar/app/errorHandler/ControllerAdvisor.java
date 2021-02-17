package fr.givemeacar.app.errorHandler;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ControllerAdvisor {

    /**
     * Gestionnaire de non respect du pattern de validation d'un model
     * @param ex l'exception déclenchée
     * @param request la requête à l'origine de l'exception
     * @return un ResponseEntity contenant le map des les données de la violation de pattern
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlePatternException(
            MethodArgumentNotValidException ex, WebRequest request);


    /**
     * Gestionnaire de non respect des contraintes de validation du model
     * @param ex l'exception déclenchée
     * @param request la requête à l'origine de l'exception
     * @return un ResponseEntity contenant le map des les données de la violation de contrainte de validation
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityException(
            ConstraintViolationException ex, WebRequest request);

    /**
     * Gestionnaire d'exception de requete sql
     * @param ex l'exception déclenchée
     * @param request la requête à l'origine de l'exception
     * @return un ResponseEntity contenant le map des les données de d'exception de requete
     */
    @ExceptionHandler(DataException.class)
    public ResponseEntity handleSqlException(DataException ex, WebRequest request);


    /**
     * Convertit le message de violation de pattern en instance de map pour le client précisant les raisons du
     * déclenchement de l'exception
     * @param ex l'exception déclenchée
     * @return l'instance de map contenant les raisons de l'exception
     */
    public Map patternViolationToMap(MethodArgumentNotValidException ex);

    /**
     * Convertit le message de SqlException en instance de map pour le client précisant les raisons du
     * déclenchement de l'exception
     * @param message le message d'exception
     * @return l'instance de map contenant les raisons de l'exception
     */
    public Map sqlExceptionToMap(String message);

    /**
     * Convertit le message de violation de contrainte en instance de map pour le client précisant les raisons du
     * déclenchement de l'exception
     * @param message le message d'exception
     * @return l'instance de map contenant les raisons de l'exception
     */
    public Map constraintToMap(String message);
}
