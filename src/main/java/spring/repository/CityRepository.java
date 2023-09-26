package spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.domain.City;

/**
 * 14/09/2023 HelloREST
 *
 * @author Wladimir Weizen
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

  default City findByName(String title) {
    List<City> cities = findAll();
    for (City city : cities) {
      if (city.getTitel().equals(title)) {
        return city;
      }
    }
    return null;
  }
}
