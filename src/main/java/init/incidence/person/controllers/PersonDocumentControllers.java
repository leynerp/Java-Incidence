package init.incidence.person.controllers;

import init.incidence.person.dto.UpdatePersonDocumentDto;
import init.incidence.person.services.PersonDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/v1/persons/documents")
@Validated
public class PersonDocumentControllers {
    @Autowired
    PersonDocumentService personDocumentService;
    @Autowired
    private  MessageSource messageSource;
    @PostMapping
    public ResponseEntity insertPersonDocument(@RequestBody @Valid UpdatePersonDocumentDto personDocument) {
        personDocumentService.insertPersonDocument(personDocument);
        return new ResponseEntity(messageSource.getMessage("api.response.person.documents.creation.success",null, Locale.getDefault()), HttpStatus.CREATED);
    }
}
