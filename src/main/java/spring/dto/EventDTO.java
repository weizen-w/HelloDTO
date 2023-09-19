package spring.dto;

import lombok.AllArgsConstructor;
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
@Getter
@Setter
@ToString
public class EventDTO {

  private Integer id;
  private String name;
  private City city;

  public static EventDTO getInstance(Event event) {
    return new EventDTO(event.getId(), event.getName(), event.getCity());
  }
}
