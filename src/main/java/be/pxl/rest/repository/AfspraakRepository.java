package be.pxl.rest.repository;

import be.pxl.rest.domain.Afspraak;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfspraakRepository extends CrudRepository<Afspraak, Integer> {


}


