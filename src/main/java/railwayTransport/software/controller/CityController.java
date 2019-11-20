package railwayTransport.software.controller;

import java.util.List;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.CityDto;
import railwayTransport.software.service.CityServiceImpl;

@Log4j

@RestController
@RequestMapping("/city")
public class CityController {

  private final CityServiceImpl cityService;


  public CityController(CityServiceImpl cityService) {
    this.cityService = cityService;
  }


  @GetMapping("/all")
  public List<CityDto> findAllCities() {
    return cityService.findAll();
  }

  @GetMapping("/{id}")
  public CityDto getCity(@PathVariable Long id) {
    log.info("get City by id = : " + id);
    return cityService.findById(id);
  }

  @PostMapping
  public CityDto createCity(@RequestBody CityDto cityDto) {
    return cityService.create(cityDto);
  }

  @DeleteMapping
  public Boolean deleteCity(@RequestBody CityDto cityDto) {
    return cityService.delete(cityDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdCity(@PathVariable Long id) {
    return cityService.deleteById(id);
  }

  @PutMapping
  public CityDto updateCity(@RequestBody CityDto cityDto) {
    return cityService.update(cityDto);
  }

}
