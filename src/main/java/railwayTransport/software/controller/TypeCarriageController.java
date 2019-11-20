package railwayTransport.software.controller;

import java.util.List;
import javax.ws.rs.core.Response;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import railwayTransport.software.dto.TypeCarriageDto;
import railwayTransport.software.service.TypeCarriageServiceImpl;

@Log4j
@RestController
@RequestMapping("/typecarriage")
public class TypeCarriageController {

  private final TypeCarriageServiceImpl typeCarriageService;

  public TypeCarriageController(TypeCarriageServiceImpl typeCarriageService) {
    this.typeCarriageService = typeCarriageService;
  }


  @GetMapping("/all")
  public List<TypeCarriageDto> findAllTypeCarriages() {
    log.info("Get List<Dto> ");
    return typeCarriageService.findAll();
  }

  @GetMapping("/{id}")
  public TypeCarriageDto getTypeCarriage(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return typeCarriageService.findById(id);
  }

  @PostMapping
  public TypeCarriageDto createTypeCarriage(@RequestBody TypeCarriageDto typeCarriageDto) {
    log.info("Create Dto");
    return typeCarriageService.create(typeCarriageDto);
  }

  @DeleteMapping
  public @ResponseBody
  Response deleteTypeCarriage(@RequestBody TypeCarriageDto typeCarriageDto) {
    log.info("Delete Dto by dto");
    typeCarriageService.delete(typeCarriageDto);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @DeleteMapping("/{id}")
  public @ResponseBody
  Response deleteByIdTypeCarriage(@PathVariable Long id) {
    log.info("Delete Dto by id = " + id);
    typeCarriageService.deleteById(id);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @PutMapping
  public TypeCarriageDto updateTypeCarriage(@RequestBody TypeCarriageDto typeCarriageDto) {
    log.info("Update Dto by dto");
    return typeCarriageService.update(typeCarriageDto);
  }

}
