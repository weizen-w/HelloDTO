package spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.domain.City;
import spring.dto.CityDTO;
import spring.service.CityService;

/**
 * 14/09/2023 HelloREST
 *
 * @author Wladimir Weizen
 */
@RestController
@RequestMapping("/city")
public class CityController {

  @Autowired
  private CityService cityService;

  @GetMapping("/all")
  public List<CityDTO> findAll() {
    return cityService.findAll();
  }

  @GetMapping("/{id}")
  public CityDTO findById(@PathVariable Integer id) {
    return cityService.findById(id);
  }

  @PostMapping("/add")
  public CityDTO add(@RequestBody CityDTO cityDTO) {
    return cityService.add(cityDTO);
  }

  @PutMapping("/update")
  public CityDTO update(@RequestBody CityDTO cityDTO) {
    return cityService.update(cityDTO);
  }

  @DeleteMapping("/delete/{id}")
  public CityDTO delete(@PathVariable Integer id) {
    return cityService.delete(id);
  }
}
