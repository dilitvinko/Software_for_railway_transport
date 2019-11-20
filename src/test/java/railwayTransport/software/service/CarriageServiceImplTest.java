package railwayTransport.software.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import railwayTransport.software.daoJPA.repository.CarriageRepository;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.mapper.CarriageMapper;
import railwayTransport.software.dto.mapper.CarriageMapperImpl;
import railwayTransport.software.entity.train.Carriage;

@RunWith(MockitoJUnitRunner.class)
public class CarriageServiceImplTest {

  @Mock
  private CarriageRepository carriageRepository;
  @InjectMocks
  private CarriageServiceImpl carriageService;

  @Before
  public void setUp() {
    CarriageMapper carriageMapper = new CarriageMapperImpl();
    carriageService = new CarriageServiceImpl(carriageRepository, carriageMapper);
  }

  @Test
  public void findAll() {
    carriageService.findAll();
    verify(carriageRepository, atLeastOnce()).findAll();
  }

  @Test
  public void findById() {
    carriageService.findById(1);
    verify(carriageRepository, atLeastOnce()).getOne(1L);
  }

  @Test
  public void deleteById() {
    carriageService.deleteById(1);
    verify(carriageRepository, atLeastOnce()).deleteById(1L);
  }

  @Test
  public void delete() {
    carriageService.delete(new CarriageDto());
    verify(carriageRepository, atLeastOnce()).delete(new Carriage());
  }

  @Test
  public void create() {
    carriageService.create(new CarriageDto());
    verify(carriageRepository, atLeastOnce()).saveAndFlush(new Carriage());
  }

  @Test
  public void update() {
    carriageService.update(new CarriageDto());
    verify(carriageRepository, atLeastOnce()).saveAndFlush(new Carriage());
  }
}