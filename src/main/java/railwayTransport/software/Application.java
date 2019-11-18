package railwayTransport.software;

import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import railwayTransport.software.dto.mapper.CarriageMapper;
import railwayTransport.software.dto.mapper.CityMapper;
import railwayTransport.software.dto.mapper.PersonMapper;
import railwayTransport.software.dto.mapper.ScheduleMapper;
import railwayTransport.software.dto.mapper.TicketMapper;
import railwayTransport.software.dto.mapper.TrainMapper;
import railwayTransport.software.dto.mapper.TypeCarriageMapper;
import railwayTransport.software.entity.train.Carriage;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

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
  public CityMapper cityMapper(){
    return Mappers.getMapper(CityMapper.class);
  }
  @Bean
  public CarriageMapper carriageMapper(){
    return Mappers.getMapper(CarriageMapper.class);
  }
  @Bean
  PersonMapper personMapper(){
    return Mappers.getMapper(PersonMapper.class);
  }
  @Bean
  ScheduleMapper scheduleMapper(){
    return Mappers.getMapper(ScheduleMapper.class);
  }
  @Bean
  TicketMapper ticketMapper(){
    return Mappers.getMapper(TicketMapper.class);
  }
  @Bean
  TrainMapper trainMapper(){
    return Mappers.getMapper(TrainMapper.class);
  }
  @Bean
  TypeCarriageMapper typeCarriageMapper(){
    return Mappers.getMapper(TypeCarriageMapper.class);
  }



}

