package railwaytransport.software.service;

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
import railwaytransport.software.daojpa.repository.TrainRepository;
import railwaytransport.software.dto.TrainDto;
import railwaytransport.software.dto.mapper.TrainMapper;
import railwaytransport.software.dto.mapper.TrainMapperImpl;
import railwaytransport.software.entity.train.Train;

@RunWith(MockitoJUnitRunner.class)
public class TrainServiceImplTest {

  @Mock
  private TrainRepository trainRepository;
  @InjectMocks
  private TrainServiceImpl trainService;

  @Before
  public void setUp() {
    TrainMapper trainMapper = new TrainMapperImpl();
    trainService = new TrainServiceImpl(trainRepository, trainMapper);

    when(trainRepository.findAll())
        .thenReturn(List.of(Train.builder().id(1L).name("Train-123").build(),
            Train.builder().id(2L).name("Train-777").build()));

  }

  @Test
  public void findAll() {

    Assert.assertEquals(List.of(TrainDto.builder().id(1L).name("Train-123").build(),
        TrainDto.builder().id(2L).name("Train-777").build()), trainService.findAll());
    verify(trainRepository, atLeastOnce()).findAll();
  }

  @Test
  public void findById() {
  }

  @Test
  public void deleteById() {
  }

  @Test
  public void delete() {
  }

  @Test
  public void deleteT() {
  }

  @Test
  public void create() {
  }

  @Test
  public void update() {
  }
}