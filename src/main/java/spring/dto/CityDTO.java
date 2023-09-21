package spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.domain.City;
import spring.domain.Event;

/**
 * 19/09/2023 HelloDTO
 *
 * @author Wladimir Weizen
 */

@AllArgsConstructor
@Data
public class CityDTO {

  private Integer id;
  private String title;

  public static CityDTO getInstance(City city) {
    return new CityDTO(city.getId(), city.getTitel());
  }
}
