package be.pxl.rest.controller;

import be.pxl.rest.domain.User;
import be.pxl.rest.listmaker.AfspraakList;
import be.pxl.rest.manager.BeerManager;
import be.pxl.rest.domain.Afspraak;
import be.pxl.rest.manager.AfspraakManager;
import be.pxl.rest.repository.AfspraakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import javax.xml.ws.Response;
import java.util.List;

@RestController
public class RestPXLController {

    @Autowired
    private BeerManager manager;
    @Autowired
    private AfspraakManager afspraakmanager;

    @Autowired
    private AfspraakRepository afspraakRepository;

    @Autowired
    private JmsTemplate template;

    @GetMapping(value = { "/pxl/sayhello/{name}", "/pxl/sayhello" })
    public ResponseEntity sayHello(@PathVariable(required = false) String name,
                                   @RequestParam(required = false) String output) {

        if ("reverse".equals(output)) {

            name = new StringBuilder(name).reverse().toString();
        }

        User user = new User();
        user.setFirstname(name);
        //user.setLastname("Schuyten");

        template.convertAndSend("HelloQueue", "Hopla, berichtje in jms...");

        return new ResponseEntity(user, HttpStatus.OK);
    }



    //afspraak



    @GetMapping(value = "/afspraak/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity getAfspraak(@PathVariable Integer id) {
        // get afspraak by id

        return new ResponseEntity(afspraakmanager.getAfspraakById(id), HttpStatus.OK);
    }

    @GetMapping("/afspraken")
    @Secured("ROLE_ADMIN")
    Iterable<Afspraak> all() {
        return afspraakRepository.findAll();
    }


    @PostMapping(value = "/afspraak/{id}")
    @Secured("ROLE_ADMIN")
    Afspraak newAfspraak(@RequestBody Afspraak newAfspraak) {

        return afspraakRepository.save(newAfspraak);
    }

    @DeleteMapping("/afspraak/{id:^d+$}")
    @Secured("ROLE_ADMIN")
    ResponseEntity<?> deleteAfspraak(@PathVariable int id) {

        afspraakRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


/*
    @PostMapping(value = "/afspraak")
    public ResponseEntity addAfspraak(
            @RequestBody Afspraak afspraak) {

        System.out.println(afspraak);
        // add him/her
        return new ResponseEntity(HttpStatus.CREATED);
    }
*/




    // afspraak

    @GetMapping(value = "/user/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        // get him/her
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/beer/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity getBeer(@PathVariable Integer id) {
        // get beer by id

        return new ResponseEntity(manager.getBeerById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        // delete him/her
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/user{id}")
    public ResponseEntity updateUser(@PathVariable String id) {
        // update him/her
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    public ResponseEntity addUser(
        @RequestBody User user) {

        System.out.println(user);
        // add him/her
        return new ResponseEntity(HttpStatus.CREATED);
    }




}
