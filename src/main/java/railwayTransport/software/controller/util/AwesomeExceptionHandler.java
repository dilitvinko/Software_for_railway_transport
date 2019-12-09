package railwayTransport.software.controller.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import railwayTransport.software.dto.exceptionDto.ExceptionDTO;
import railwayTransport.software.exception.DeleteYourselfException;
import railwayTransport.software.exception.WrongOrderInSchedulesForCalculatePriceException;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(DeleteYourselfException.class)
  protected ResponseEntity<ExceptionDTO> handleDeleteYourselfException(HttpServletRequest httpServletRequest, Throwable e) {
    return new ResponseEntity<>(new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
        LocalDateTime.now()), HttpStatus.CONFLICT.value(), "Can't delete yourself", e.getMessage()), HttpStatus.CONFLICT);
  }


  @ExceptionHandler(EmptyResultDataAccessException.class)
  protected ResponseEntity<ExceptionDTO> handleEmptyResultDataAccessException(HttpServletRequest httpServletRequest, Throwable e) {
    return new ResponseEntity<>(new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
        LocalDateTime.now()), HttpStatus.NOT_FOUND.value(), "Entity with this id does not exist", e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  protected ResponseEntity<ExceptionDTO> handleEntityNotFoundException(HttpServletRequest httpServletRequest, Throwable e) {
    return new ResponseEntity<>(new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
        LocalDateTime.now()), HttpStatus.NOT_FOUND.value(), "Unable to find entity with this id", e.getMessage()), HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(UnexpectedTypeException.class)
  protected ResponseEntity<ExceptionDTO> handleUnexpectedTypeException(HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
        LocalDateTime.now()), HttpStatus.CONFLICT.value(), "Some problem with validation", e.getMessage()), HttpStatus.CONFLICT);
  }


  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<ExceptionDTO> handleConstraintViolationException(HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
        LocalDateTime.now()), HttpStatus.CONFLICT.value(), "Some problem with DB (may be duplicate key - tickets)", e.getMessage()), HttpStatus.CONFLICT);
  }


  @ExceptionHandler(WrongOrderInSchedulesForCalculatePriceException.class)
  protected ResponseEntity<ExceptionDTO> handleWrongOrderInSchedulesForCalculatePriceException(HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
        LocalDateTime.now()), HttpStatus.CONFLICT.value(), "DrivingOrder of outSchedule is bigger, then DrivingOrder of inSchedule", e.getMessage()), HttpStatus.CONFLICT);
  }


}
