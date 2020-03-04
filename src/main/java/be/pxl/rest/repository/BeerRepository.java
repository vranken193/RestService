package be.pxl.rest.repository;

import be.pxl.rest.domain.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Integer> {
}
