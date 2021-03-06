package railwaytransport.software;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import railwaytransport.software.dto.mapper.CarriageMapper;
import railwaytransport.software.dto.mapper.CityMapper;
import railwaytransport.software.dto.mapper.PersonMapper;
import railwaytransport.software.dto.mapper.ScheduleMapper;
import railwaytransport.software.dto.mapper.TicketMapper;
import railwaytransport.software.dto.mapper.TrainMapper;
import railwaytransport.software.dto.mapper.TypeCarriageMapper;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setFieldMatchingEnabled(true)
        .setSkipNullEnabled(true)
        .setFieldAccessLevel(PRIVATE);
    return mapper;
  }

  @Bean
  public CityMapper cityMapper() {
    return Mappers.getMapper(CityMapper.class);
  }

  @Bean
  public CarriageMapper carriageMapper() {
    return Mappers.getMapper(CarriageMapper.class);
  }

  @Bean
  PersonMapper personMapper() {
    return Mappers.getMapper(PersonMapper.class);
  }

  @Bean
  ScheduleMapper scheduleMapper() {
    return Mappers.getMapper(ScheduleMapper.class);
  }

  @Bean
  TicketMapper ticketMapper() {
    return Mappers.getMapper(TicketMapper.class);
  }

  @Bean
  TrainMapper trainMapper() {
    return Mappers.getMapper(TrainMapper.class);
  }

  @Bean
  TypeCarriageMapper typeCarriageMapper() {
    return Mappers.getMapper(TypeCarriageMapper.class);
  }

}

