package railwayTransport.software.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.daoJPA.repository.TestRepository;
import railwayTransport.software.daoJPA.repository.TesteRepository;
import railwayTransport.software.entity.TestEntity;
import railwayTransport.software.entity.Teste;

@RestController
public class TestSpringController
{
  @Autowired
  private TestRepository testRepository;
  @Autowired
  private TesteRepository testeRepository;

  @RequestMapping("/getString")
  public Teste getString()
  {
    TestEntity testEntity = new TestEntity("Bob", 25);
    testRepository.saveAndFlush(testEntity);

    Teste teste = new Teste(32, 98);
    testeRepository.saveAndFlush(teste);

    return teste;
  }
}
