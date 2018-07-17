package come.razouki.location.repository;

import come.razouki.location.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  LocationRepository extends JpaRepository<Location,Integer> {
}
