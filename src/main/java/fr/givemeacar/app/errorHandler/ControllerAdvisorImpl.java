package fr.givemeacar.app.errorHandler;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ControllerAdvisorImpl {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityException(
            ConstraintViolationException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(messageToMap(ex.getSQLException().getMessage()), HttpStatus.CONFLICT);
    }

    public Map messageToMap(String message) {
        String[] splited = message.split(" ");
        String[] constraint = splited[5].split("\\.");
        String[] reason = constraint[1].split("_");

        Map<String, String> map = new HashMap<String, String>();

        map.put("value", splited[2]);
        map.put("table", constraint[0]);
        map.put("field", reason[0]);
        map.put("constraint", reason[1].toLowerCase());

        return map;
    }
}