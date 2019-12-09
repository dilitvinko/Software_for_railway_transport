package railwayTransport.software.controller;

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
import railwayTransport.software.dto.CarriageDto;
import railwayTransport.software.service.CarriageServiceImpl;

@Log4j

@RestController
@RequestMapping("/carriages")
public class
CarriageController {

  private final CarriageServiceImpl carriageService;

  public CarriageController(CarriageServiceImpl carriageService) {
    this.carriageService = carriageService;
  }


  @GetMapping
  public List<CarriageDto> findAllCarriages() {
    log.info("Get List<Dto> ");
    return carriageService.findAll();
  }

  @GetMapping("/{id}")
  public CarriageDto getCarriage(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return carriageService.findById(id);
  }

  @PostMapping
  public CarriageDto createCarriages(@RequestBody @Validated CarriageDto carriageDto) {
    log.info("Create Dto");
    return carriageService.create(carriageDto);
  }

  @DeleteMapping
  public @ResponseBody
  Response deleteCarriage(@RequestBody CarriageDto carriageDto) {
    log.info("Delete Dto by dto");
    carriageService.delete(carriageDto);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @DeleteMapping("/{id}")
  public @ResponseBody
  Response deleteByIdCarriage(@PathVariable Long id) {
    log.info("Delete Dto by id = " + id);
    carriageService.deleteById(id);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @PutMapping
  public CarriageDto updateCarriage(@RequestBody CarriageDto carriageDto) {
    log.info("Update Dto by dto");
    return carriageService.update(carriageDto);
  }

}
