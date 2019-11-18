package railwayTransport.software.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
  public boolean deleteById(long id) {
    boolean flag = false;
    try{
      personRepository.deleteById(id);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean delete(PersonDto dto) {
    boolean flag = false;
    Person person = mapper.personDtoToPerson(dto);
    try{
      personRepository.delete(person);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
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
