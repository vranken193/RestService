package be.pxl.rest.manager;
import be.pxl.rest.domain.Afspraak;
import be.pxl.rest.repository.AfspraakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AfspraakManager {

    @Autowired
    private AfspraakRepository repository;

    public Afspraak getAfspraakById(Integer id) {
        return repository.findById(id).orElse(null);
    }

}




