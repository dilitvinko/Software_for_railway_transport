package railwaytransport.software.controller;

import java.util.List;
import java.util.Set;
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
import railwaytransport.software.dto.CarriageDto;
import railwaytransport.software.dto.TrainDto;
import railwaytransport.software.service.TrainServiceImpl;

@Log4j
@RestController
@RequestMapping("/trains")
public class TrainController {

  private final TrainServiceImpl trainService;

  public TrainController(TrainServiceImpl trainService) {
    this.trainService = trainService;
  }


  @GetMapping
  public List<TrainDto> findAllTrains() {
    return trainService.findAll();
  }

  @GetMapping("/{id}")
  public TrainDto getTrain(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return trainService.findById(id);
  }

  @GetMapping("/{id}/carriages")
  public Set<CarriageDto> getCarriagesFromTrain(@PathVariable Long id) {
    log.info("Get Dto by id =  " + id);
    return trainService.findById(id).getCarriages();
  }

  @PostMapping
  public TrainDto createTrain(@RequestBody @Validated TrainDto trainDto) {
    log.info("Create Dto");
    return trainService.create(trainDto);
  }

  @DeleteMapping
  public @ResponseBody
  Response deleteTrain(@RequestBody @Validated TrainDto trainDto) {
    log.info("Delete Dto by dto");
    trainService.delete(trainDto);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @DeleteMapping("/{id}")
  public @ResponseBody
  Response deleteByIdTrain(@PathVariable Long id) {
    log.info("Delete Dto by id = " + id);
    trainService.deleteById(id);
    return Response.status(Response.Status.OK.getStatusCode()).build();
  }

  @PutMapping
  public TrainDto updateTrain(@RequestBody @Validated TrainDto trainDto) {
    log.info("Update Dto by dto");
    return trainService.update(trainDto);
  }


}
