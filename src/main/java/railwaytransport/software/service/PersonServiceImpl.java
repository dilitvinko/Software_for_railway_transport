package railwaytransport.software.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import railwaytransport.software.daojpa.repository.PersonRepository;
import railwaytransport.software.dto.PersonDto;
import railwaytransport.software.dto.mapper.PersonMapper;
import railwaytransport.software.entity.person.Person;
import railwaytransport.software.service.interfaces.PersonService;

@Service
public class PersonServiceImpl implements PersonService, UserDetailsService {

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
    dto.setId(null);
    Person person = mapper.personDtoToPerson(dto);
    personRepository.saveAndFlush(person);
    dto = mapper.personToPersonDto(person);
    return dto;
  }

  @Override
  public PersonDto update(PersonDto dto) {
    Person person = mapper.personDtoToPerson(dto);
    if (null == personRepository.getOne(person.getId())) {
      throw new EntityNotFoundException();
    }
    personRepository.saveAndFlush(person);
    dto = mapper.personToPersonDto(person);
    return dto;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    UserDetails userDetails = personRepository.findUserByLogin(s);
    return userDetails;
  }
}
