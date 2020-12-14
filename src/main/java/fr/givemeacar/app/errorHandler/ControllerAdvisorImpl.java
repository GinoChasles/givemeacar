package fr.givemeacar.app.errorHandler;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ControllerAdvisorImpl implements ControllerAdvisor{


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlePatternException(
            MethodArgumentNotValidException ex, WebRequest request) {

        return new ResponseEntity<>(patternViolationToMap(ex), HttpStatus.CONFLICT);
    }

    public Map patternViolationToMap(MethodArgumentNotValidException ex){
            Map<String, String> map = new HashMap<String, String>();

            Matcher m = Pattern.compile("\\[.*]").matcher(ex.getFieldError().getDefaultMessage());

            if(m.find()) {
                map.put("pattern", m.group(0));
            }
            map.put("constraint","pattern");
            map.put("value", ex.getFieldError().getRejectedValue().toString());
            map.put("field", ex.getFieldError().getField());
            map.put("message","pattern violation");
            map.put("timestamp",new Date().toString());
            return map;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityException(
            ConstraintViolationException ex, WebRequest request) {

        return new ResponseEntity<>(constraintToMap(ex.getSQLException().getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity handleTruncationException(DataException ex, WebRequest request) {

        return new ResponseEntity<>(truncationToMap(ex.getSQLException().getMessage()), HttpStatus.CONFLICT);
    }




    public Map truncationToMap(String message) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("table", message.split(" ")[7].replaceAll("'",""));
        map.put("constraint", "too long");
        map.put("message",message);
        map.put("timestamp",new Date().toString());
        return map;
    }

    public Map constraintToMap(String message) {
        String[] splited = message.split(" ");
        String[] constraint = splited[5].split("\\.");
        String[] reason = constraint[1].split("_");

        Map<String, String> map = new HashMap<String, String>();

        map.put("value", splited[2]);
        map.put("table", constraint[0]);
        map.put("field", reason[0]);
        map.put("constraint", reason[1].toLowerCase());
        map.put("message",message);
        map.put("timestamp",new Date().toString());
        return map;
    }
}