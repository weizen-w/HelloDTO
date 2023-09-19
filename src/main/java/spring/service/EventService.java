package spring.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Event;
import spring.dto.EventDTO;
import spring.repository.EventRepository;

/**
 * 14/09/2023 HelloREST
 *
 * @author Wladimir Weizen
 */
@Service
public class EventService {

  static final Logger log = LoggerFactory.getLogger(EventService.class);

  @Autowired
  private EventRepository eventRepository;

  public List<EventDTO> findAll() {
    List<Event> events = eventRepository.findAll();
    List<EventDTO> eventDTOList = new ArrayList<>();
    events.forEach(e -> eventDTOList.add(EventDTO.getInstance(e)));
    log.info("Reading {} records from Event table.", eventDTOList.size());
    return eventDTOList;
  }

  public EventDTO findById(Integer id) {
    Event event = eventRepository.findById(id).orElse(null);
    if (event != null) {
      EventDTO eventDTO = EventDTO.getInstance(event);
      log.info("Reading {} from Event table.", eventDTO);
      return eventDTO;
    }
    log.error("Not found event, eventId={} from Event table.", id);
    return null;
  }

  public EventDTO add(EventDTO eventDTO) {
    Event event = new Event(null, eventDTO.getName(), eventDTO.getCity());
    event = eventRepository.save(event);
    return EventDTO.getInstance(event);
  }

  public EventDTO update(EventDTO eventDTO) {
    Event event = eventRepository.findById(eventDTO.getId()).orElse(null);
    if (event != null) {
      event.setName(eventDTO.getName());
      event.setCity(eventDTO.getCity());
      event = eventRepository.save(event);
      return EventDTO.getInstance(event);
    }
    return null;
  }

  public EventDTO delete(Integer id) {
    Event event = eventRepository.findById(id).orElse(null);
    if (event != null) {
      eventRepository.delete(event);
      return EventDTO.getInstance(event);
    }
    return null;
  }
}
