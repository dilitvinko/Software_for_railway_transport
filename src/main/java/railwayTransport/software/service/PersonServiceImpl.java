package railwayTransport.software.service;

import java.util.List;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.PersonRepository;
import railwayTransport.software.dto.PersonDto;
import railwayTransport.software.dto.mapper.PersonMapper;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.service.interfaces.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;
  private final PersonMapper mapper;

  public PersonServiceImpl(
      PersonRepository personRepository, PersonMapper mapper) {
    this.personRepository = personRepository;
    this.mapper = mapper;
  }

  @Override
  public List<PersonDto> findAll() {
    return mapper.listPersonToListPersonDto(personRepository.findAll());
  }

  @Override
  public PersonDto findById(long id) {
    return mapper.personToPersonDto(personRepository.getOne(id));
  }

  @Override
  public void deleteById(long id) {
    personRepository.deleteById(id);
  }

  @Override
  public void delete(PersonDto dto) {
    Person person = mapper.personDtoToPerson(dto);
    personRepository.delete(person);
  }

  @Override
  public PersonDto create(PersonDto dto) {
    Person person = mapper.personDtoToPerson(dto);
    personRepository.saveAndFlush(person);
    dto = mapper.personToPersonDto(person);
    return dto;
  }

  @Override
  public PersonDto update(PersonDto dto) {
    Person person = mapper.personDtoToPerson(dto);
    personRepository.saveAndFlush(person);
    dto = mapper.personToPersonDto(person);
    return dto;
  }
}
