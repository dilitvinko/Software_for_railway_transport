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
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.service.CarriageServiceImpl;
import railwayTransport.software.service.CarriageServiceImpl;

@RestController
@RequestMapping("/carriage")
public class CarriageController {

  private final CarriageServiceImpl carriageService;

  public CarriageController(CarriageServiceImpl carriageService) {
    this.carriageService = carriageService;
  }


  @GetMapping("/all")
  public List<CarriageDto> findAllCarriages() {
    return carriageService.findAll();
  }

  @GetMapping("/{id}")
  public CarriageDto getCarriage(@PathVariable Long id) {
    return carriageService.findById(id);
  }

  @PostMapping
  public CarriageDto createCarriages(@RequestBody CarriageDto carriageDto) {
    return carriageService.create(carriageDto);
  }

  @DeleteMapping
  public Boolean deleteCarriages(@RequestBody CarriageDto carriageDto) {
    return carriageService.delete(carriageDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdCarriages(@PathVariable Long id) {
    return carriageService.deleteById(id);
  }

  @PutMapping
  public CarriageDto updateCarriages(@RequestBody CarriageDto carriageDto) {
    return carriageService.update(carriageDto);
  }

}
