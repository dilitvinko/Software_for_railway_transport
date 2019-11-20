package railwayTransport.software.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.PersonDto;
import railwayTransport.software.service.PersonServiceImpl;

@RestController
@RequestMapping("/person")
public class PersonController {

  private final PersonServiceImpl personService;

  public PersonController(PersonServiceImpl personService) {
    this.personService = personService;
  }


  @GetMapping("/all")
  public List<PersonDto> findAllPersons() {
    return personService.findAll();
  }

  @GetMapping("/{id}")
  public PersonDto getCarriage(@PathVariable Long id) {
    return personService.findById(id);
  }

  @PostMapping
  public PersonDto createPerson(@RequestBody PersonDto personDto) {
    return personService.create(personDto);
  }

  @DeleteMapping
  public Boolean deletePerson(@RequestBody PersonDto personDto) {
    return personService.delete(personDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdPerson(@PathVariable Long id) {
    return personService.deleteById(id);
  }

  @PutMapping
  public PersonDto updatePerson(@RequestBody PersonDto personDto) {
    return personService.update(personDto);
  }

}
