package railwayTransport.software.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import railwayTransport.software.daoJPA.repository.PersonRepository;
import railwayTransport.software.dto.PersonDto;
import railwayTransport.software.entity.person.Person;
import railwayTransport.software.service.interfaces.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;
  private final ModelMapper modelMapper;

  public PersonServiceImpl(
      PersonRepository personRepository, ModelMapper modelMapper) {
    this.personRepository = personRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<PersonDto> findAll() {
    List<Person> persons = personRepository.findAll();
    return modelMapper.map(persons, new TypeToken<List<PersonDto>>() {
    }.getType());
  }

  @Override
  public PersonDto findById(long id) {
    return modelMapper.map(personRepository.getOne(id), new TypeToken<PersonDto>() {
    }.getType());
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
  public boolean delete(PersonDto entity) {
    boolean flag = false;
    Person person = modelMapper.map(entity, new TypeToken<PersonDto>() {
    }.getType());
    try{
      personRepository.delete(person);
      flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public PersonDto create(PersonDto entity) {
    Person person = new Person();
    modelMapper.map(entity, person);
    personRepository.saveAndFlush(person);
    entity = modelMapper.map(person, new TypeToken<PersonDto>() {
    }.getType());
    return entity;
  }

  @Override
  public PersonDto update(PersonDto entity) {
    Person person = new Person();
    modelMapper.map(entity, person);
    personRepository.saveAndFlush(person);
    entity = modelMapper.map(person, new TypeToken<PersonDto>() {
    }.getType());
    return entity;
  }
}
