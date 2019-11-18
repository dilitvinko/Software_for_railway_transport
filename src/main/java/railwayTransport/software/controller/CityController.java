package railwayTransport.software.controller;

import java.util.List;
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

@RestController
@RequestMapping("/city")
public class CityController {

  private final CityServiceImpl cityService;

  public CityController(CityServiceImpl cityService) {
    this.cityService = cityService;
  }


  @GetMapping("/all")
  public List<CityDto> findAllCitys() {
    return cityService.findAll();
  }

  @GetMapping("/{id}")
  public CityDto getCarriage(@PathVariable Long id) {
    return cityService.findById(id);
  }

  @PostMapping
  public CityDto createCitys(@RequestBody CityDto cityDto) {
    return cityService.create(cityDto);
  }

  @DeleteMapping
  public Boolean deleteCitys(@RequestBody CityDto cityDto) {
    return cityService.delete(cityDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdCitys(@PathVariable Long id) {
    return cityService.deleteById(id);
  }

  @PutMapping
  public CityDto updateCitys(@RequestBody CityDto cityDto) {
    return cityService.update(cityDto);
  }

}
