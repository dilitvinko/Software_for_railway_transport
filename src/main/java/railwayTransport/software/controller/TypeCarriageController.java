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
import railwayTransport.software.dto.TypeCarriageDto;
import railwayTransport.software.entity.train.Train;
import railwayTransport.software.service.TypeCarriageServiceImpl;

@RestController
@RequestMapping("/typecarriage")
public class TypeCarriageController {

  private final TypeCarriageServiceImpl typeCarriageService;

  public TypeCarriageController(TypeCarriageServiceImpl typeCarriageService) {
    this.typeCarriageService = typeCarriageService;
  }


  @GetMapping("/all")
  public List<TypeCarriageDto> findAllTypeCarriages() {
    return typeCarriageService.findAll();
  }

  @GetMapping("/{id}")
  public TypeCarriageDto getTypeCarriage(@PathVariable Long id) {
    return typeCarriageService.findById(id);
  }

  @PostMapping
  public TypeCarriageDto createTypeCarriage(@RequestBody TypeCarriageDto typeCarriageDto) {
    return typeCarriageService.create(typeCarriageDto);
  }

  @DeleteMapping
  public Boolean deleteTypeCarriage(@RequestBody TypeCarriageDto typeCarriageDto) {
    return typeCarriageService.delete(typeCarriageDto);
  }

  @DeleteMapping("/{id}")
  public Boolean deleteByIdTypeCarriage(@PathVariable Long id) {
    return typeCarriageService.deleteById(id);
  }

  @PutMapping
  public TypeCarriageDto updateTypeCarriage(@RequestBody TypeCarriageDto typeCarriageDto) {
    return typeCarriageService.update(typeCarriageDto);
  }

}
