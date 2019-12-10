package railwayTransport.software.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import railwayTransport.software.daoJPA.repository.CityRepository;
import railwayTransport.software.dto.CityDto;
import railwayTransport.software.dto.mapper.CityMapper;
import railwayTransport.software.dto.mapper.CityMapperImpl;
import railwayTransport.software.entity.schedule.City;
import railwayTransport.software.service.CityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

  @Mock
  private CityRepository cityRepository;
  @InjectMocks
  private CityServiceImpl cityService;

  @Before
  public void setUp() {
    CityMapper cityMapper = new CityMapperImpl();
    cityService = new CityServiceImpl(cityRepository, cityMapper);
  }

  @Test
  public void findAll() {
    when(cityRepository.findAll())
        .thenReturn(List.of(City.builder().id(1L).name("Moscow").build(),
            City.builder().id(2L).name("Minsk").build()));
    Assert.assertEquals(List.of(CityDto.builder().id(1L).name("Moscow").build(),
        CityDto.builder().id(2L).name("Minsk").build()), cityService.findAll());
    verify(cityRepository, atLeastOnce()).findAll();

  }

  @Test
  public void findById() {
    when(cityRepository.getOne(1L))
        .thenReturn(City.builder().id(1L).name("Moscow").build());
    Assert.assertEquals(CityDto.builder().id(1L).name("Moscow").build(), cityService.findById(1L));
    verify(cityRepository, atLeastOnce()).getOne(1L);
  }

  @Test
  public void deleteById() {
    cityService.deleteById(1);
    verify(cityRepository, atLeastOnce()).deleteById(1L);
  }

  @Test
  public void delete() {
    cityService.delete(new CityDto());
    verify(cityRepository, atLeastOnce()).delete(new City());
  }

  @Test
  public void create() {
    City city = new City("Moscow");
    when(cityRepository.saveAndFlush(city))
        .thenReturn(City.builder().id(1L).name("Moscow").build());
    Assert.assertEquals(CityDto.builder().id(1L).name("Moscow").build(),
        cityService.create(CityDto.builder().name("Moscow").build()));
    verify(cityRepository, atLeastOnce()).saveAndFlush(city);
  }

  @Test
  public void update() {
    City city = new City("Moscow");
    city.setId(1L);
    when(cityRepository.saveAndFlush(city))
        .thenReturn(City.builder().id(1L).name("Moscow").build());
    when(cityRepository.getOne(city.getId())).thenReturn(City.builder().id(1L).name("Moscow").build());
    Assert.assertEquals(CityDto.builder().id(1L).name("Moscow").build(),
        cityService.update(CityDto.builder().id(1L).name("Moscow").build()));
    verify(cityRepository, atLeastOnce()).saveAndFlush(city);

  }
}