package railwayTransport.software.controller;

import java.util.List;
import java.util.Set;
import javax.ws.rs.core.Response;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.PersonDto;
import railwayTransport.software.dto.TicketDto;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.exception.DeleteYourselfException;
import railwayTransport.software.service.PersonServiceImpl;

@Log4j
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonServiceImpl personService;

  public PersonController(PersonServiceImpl personService) {
    this.personService = personService;
  }


  @GetMapping
  public List<PersonDto> findAllPersons() {
    log.info("Get List<Dto> ");
    return personService.findAll();
  }

  @GetMapping("/{id}")
  public PersonDto getPerson(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return personService.findById(id);
  }



  @PostMapping
  public PersonDto createPerson(@RequestBody @Validated PersonDto personDto) {
    log.info("Create Dto");
    return personService.create(personDto);
  }

  @DeleteMapping("/{id}")
  public @ResponseBody
  Response deleteByIdPerson(@PathVariable Long id) {
    log.info("Delete Dto by id = " + id);
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Person currentPrincipal = (Person) authentication.getPrincipal();
    if (id == currentPrincipal.getId()){
      //TODO норально обработать
      throw new DeleteYourselfException();
    }
    personService.deleteById(id);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @PutMapping
  public PersonDto updatePerson(@RequestBody @Validated PersonDto personDto) {
    log.info("Update Dto by dto");
    return personService.update(personDto);
  }

}
