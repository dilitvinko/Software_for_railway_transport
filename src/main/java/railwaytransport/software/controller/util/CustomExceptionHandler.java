package railwaytransport.software.controller.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import railwaytransport.software.controller.util.exceptiondto.ExceptionDTO;
import railwaytransport.software.exception.CityNotFoundException;
import railwaytransport.software.exception.DeleteYourselfException;
import railwaytransport.software.exception.WrongOrderInSchedulesForCalculatePriceException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(DeleteYourselfException.class)
  protected ResponseEntity<ExceptionDTO> handleDeleteYourselfException(
      HttpServletRequest httpServletRequest, Throwable e) {
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.CONFLICT.value(), "Can't delete yourself",
            e.getMessage()), HttpStatus.CONFLICT);
  }


  @ExceptionHandler(EmptyResultDataAccessException.class)
  protected ResponseEntity<ExceptionDTO> handleEmptyResultDataAccessException(
      HttpServletRequest httpServletRequest, Throwable e) {
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
            "Entity with this id does not exist", e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  protected ResponseEntity<ExceptionDTO> handleEntityNotFoundException(
      HttpServletRequest httpServletRequest, Throwable e) {
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
            "Unable to find entity with this id", e.getMessage()), HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(UnexpectedTypeException.class)
  protected ResponseEntity<ExceptionDTO> handleUnexpectedTypeException(
      HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.CONFLICT.value(), "Some problem with validation",
            e.getMessage()), HttpStatus.CONFLICT);
  }


  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<ExceptionDTO> handleConstraintViolationException(
      HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.CONFLICT.value(),
            "Some problem with DB (may be duplicate key - tickets)", e.getMessage()),
        HttpStatus.CONFLICT);
  }


  @ExceptionHandler(WrongOrderInSchedulesForCalculatePriceException.class)
  protected ResponseEntity<ExceptionDTO> handleWrongOrderInSchedulesForCalculatePriceException(
      HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.CONFLICT.value(),
            "DrivingOrder of outSchedule is bigger, then DrivingOrder of inSchedule",
            e.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(NullPointerException.class)
  protected ResponseEntity<ExceptionDTO> handleNullPointerException(
      HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
            "NullPointer",
            e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CityNotFoundException.class)
  protected ResponseEntity<ExceptionDTO> handleCityNotFound(
      HttpServletRequest httpServletRequest, Throwable e) {
    e.printStackTrace();
    return new ResponseEntity<>(
        new ExceptionDTO(httpServletRequest.getRequestURL().toString(), Timestamp.valueOf(
            LocalDateTime.now()), HttpStatus.NOT_FOUND.value(),
            "City Not Found",
            e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    List<String> errors = new ArrayList<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.add(error.getField() + ": " + error.getDefaultMessage());
    }
      return new ResponseEntity<>(
          new ExceptionDTO(request.getContextPath(),
              Timestamp.valueOf(LocalDateTime.now()), HttpStatus.BAD_REQUEST.value(), "BadRequestException",
              ex.getMessage()), HttpStatus.BAD_REQUEST);

  }


}
