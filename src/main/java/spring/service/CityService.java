package spring.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.City;
import spring.dto.CityDTO;
import spring.repository.CityRepository;

/**
 * 14/09/2023 HelloREST
 *
 * @author Wladimir Weizen
 */
@Service
public class CityService {

  static final Logger log = LoggerFactory.getLogger(CityService.class);

  @Autowired
  private CityRepository cityRepository;

  public List<CityDTO> findAll() {
    List<City> cities = cityRepository.findAll();
    List<CityDTO> cityDTOList = new ArrayList<>();
    cities.forEach(c -> cityDTOList.add(CityDTO.getInstance(c)));
    log.info("Reading {} records from City table.", cityDTOList.size());
    return cityDTOList;
  }

  public CityDTO findById(Integer id) {
    City city = cityRepository.findById(id).orElse(null);
    if (city != null) {
      CityDTO cityDTO = CityDTO.getInstance(city);
      log.info("Reading {} from City table.", cityDTO);
      return cityDTO;
    }
    log.error("Not found city, cityId={} from City table.", id);
    return null;
  }

  public CityDTO add(CityDTO cityDTO) {
    City city = new City(null, cityDTO.getTitle());
    city = cityRepository.save(city);
    return CityDTO.getInstance(city);
  }

  public CityDTO update(CityDTO cityDTO) {
    City city = cityRepository.findById(cityDTO.getId()).orElse(null);
    if (city != null) {
      city.setTitel(cityDTO.getTitle());
      city = cityRepository.save(city);
      return CityDTO.getInstance(city);
    }
    return null;
  }

  public CityDTO delete(Integer id) {
    City city = cityRepository.findById(id).orElse(null);
    if (city != null) {
      cityRepository.delete(city);
      return CityDTO.getInstance(city);
    }
    return null;
  }
}
