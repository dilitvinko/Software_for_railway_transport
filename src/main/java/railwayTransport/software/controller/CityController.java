package railwayTransport.software.controller;

import java.util.List;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.CityDto;
import railwayTransport.software.dto.mapper.CityMapper;
import railwayTransport.software.service.interfaces.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

  private final CityService cityService;


  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping("/all")
  public List<CityDto> getCarriages() {
    return cityService.findAll();
  }

  @GetMapping("/{id}")
  public CityDto getCarriage(@PathVariable Long id){
    return cityService.findById(id);
  }

}
