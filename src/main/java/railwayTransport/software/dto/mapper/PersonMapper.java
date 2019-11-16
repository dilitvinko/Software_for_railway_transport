package railwayTransport.software.dto.mapper;

import org.mapstruct.Mapper;
import railwayTransport.software.dto.PersonDto;
import railwayTransport.software.entity.person.Person;

@Mapper
public interface PersonMapper {
  PersonDto personToPersonDto(Person entity);


  Person personDtoToPerson(PersonDto dto);

}
