package init.incidence.person.controllers;


import init.incidence.comun.MessageFormat;
import init.incidence.comun.ResponsePagination;
import init.incidence.person.dto.PersonGetDto;
import init.incidence.person.dto.PersonPostDto;
import init.incidence.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("/v1/persons")
@Validated
public class PersonController {

    @Autowired
    private PersonService objectPersonService;
    @Autowired
    private MessageSource messageSource;

    @PostMapping
    public ResponseEntity<MessageFormat>  insertPerson(@RequestBody @Valid PersonPostDto newPerson) {
        objectPersonService.insertPerson(newPerson);
        return new ResponseEntity(new MessageFormat(HttpStatus.OK.value(),messageSource.getMessage("api.response.person.creation.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<MessageFormat> updatePerson(@RequestBody PersonPostDto updPerson) {
        objectPersonService.updatePerson(updPerson);
        return new ResponseEntity(new MessageFormat(HttpStatus.CREATED.value(),messageSource.getMessage("api.response.person.update.success", null, Locale.getDefault())), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idPerson}")
    public ResponseEntity<MessageFormat> deletePerson(@PathVariable("idPerson") int idperson) {
        objectPersonService.deletePerson(idperson);
        return new ResponseEntity(new MessageFormat(HttpStatus.OK.value(), messageSource.getMessage("api.response.person.delete.success", null, Locale.getDefault())), HttpStatus.OK);
    }

    @GetMapping("/{start}/{limit}")
    public ResponsePagination<PersonPostDto> getAll(@PathVariable("start") int start, @PathVariable("limit") int limit) {
        return objectPersonService.findAll(start, limit);
    }

    @GetMapping("/{start}/{limit}/filters")
    public ResponsePagination<PersonPostDto> findByParams(@PathVariable("start") int start, @PathVariable("limit") int limit, @RequestBody @Valid PersonGetDto objectSearch) {
        return objectPersonService.findByParams(start, limit, objectSearch);
    }

    @GetMapping("/test")
    public ResponseEntity<MessageFormat> getAllByFilter() {
        return new ResponseEntity(new MessageFormat(HttpStatus.OK.value(),"start"),HttpStatus.OK);
    }

}
