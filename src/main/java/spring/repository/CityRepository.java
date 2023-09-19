package spring.repository;

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

}
