package railwaytransport.software.controller;

import java.util.List;
import javax.ws.rs.core.Response;
import lombok.extern.log4j.Log4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwaytransport.software.dto.CityDto;
import railwaytransport.software.service.CityServiceImpl;

@Log4j

@RestController
@RequestMapping("/cities")
public class CityController {

  //TODO логирование

  private final CityServiceImpl cityService;


  public CityController(CityServiceImpl cityService) {
    this.cityService = cityService;
  }


  @GetMapping
  public List<CityDto> findAllCities() {
    log.info("Get List<Dto> ");
    return cityService.findAll();
  }

  @GetMapping("/{id}")
  public CityDto getCity(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return cityService.findById(id);
  }

  @PostMapping
  public CityDto createCity(@Validated CityDto cityDto) {
    log.info("Create Dto");
    return cityService.create(cityDto);
  }

  @DeleteMapping
  public @ResponseBody
  Response deleteCity(@RequestBody @Validated CityDto cityDto) {
    log.info("Delete Dto by dto");
    cityService.delete(cityDto);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @DeleteMapping("/{id}")
  public @ResponseBody
  Response deleteByIdCity(@PathVariable @Validated Long id) {
    log.info("Delete Dto by id = " + id);
    cityService.deleteById(id);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @PutMapping
  public CityDto updateCity(@RequestBody @Validated CityDto cityDto) {
    log.info("Update Dto by dto");
    return cityService.update(cityDto);
  }

}
