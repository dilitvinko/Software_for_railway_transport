package railwayTransport.software.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import railwayTransport.software.daoJPA.repository.TypeCarriageRepository;
import railwayTransport.software.dto.TypeCarriageDto;
import railwayTransport.software.dto.mapper.TypeCarriageMapper;
import railwayTransport.software.dto.mapper.TypeCarriageMapperImpl;
import railwayTransport.software.entity.train.TypeCarriage;
import railwayTransport.software.service.TypeCarriageServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TypeCarriageServiceImplTest {

  @Mock
  private TypeCarriageRepository typeCarriageRepository;
  @InjectMocks
  private TypeCarriageServiceImpl typeCarriageService;

  @Before
  public void setUp() {
    TypeCarriageMapper typeCarriageMapper = new TypeCarriageMapperImpl();
    typeCarriageService = new TypeCarriageServiceImpl(typeCarriageRepository, typeCarriageMapper);
  }

  @Test
  public void findAll() {
    typeCarriageService.findAll();
    verify(typeCarriageRepository, atLeastOnce()).findAll();
  }

  @Test
  public void findById() {
    typeCarriageService.findById(1);
    verify(typeCarriageRepository, atLeastOnce()).getOne(1L);
  }

  @Test
  public void deleteById() {
    typeCarriageService.deleteById(1);
    verify(typeCarriageRepository, atLeastOnce()).deleteById(1L);
  }

  @Test
  public void delete() {
    typeCarriageService.delete(new TypeCarriageDto());
    verify(typeCarriageRepository, atLeastOnce()).delete(new TypeCarriage());
  }

  @Test
  public void create() {
    typeCarriageService.create(new TypeCarriageDto());
    verify(typeCarriageRepository, atLeastOnce()).saveAndFlush(new TypeCarriage());
  }

  @Test
  public void update() {
    typeCarriageService.update(new TypeCarriageDto());
    verify(typeCarriageRepository, atLeastOnce()).saveAndFlush(new TypeCarriage());
  }
}