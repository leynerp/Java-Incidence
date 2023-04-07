package init.incidence.nomenclator.controller;

import init.incidence.models.NomDocumenttypeEntity;
import init.incidence.nomenclator.dto.NomDocumentDto;
import init.incidence.nomenclator.services.NomenclatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/nomenclators")
public class NomenclatorController {
    @Autowired
    private NomenclatorService nomenclatorService;
    @GetMapping("/{start}/{limit}")
    public List<NomDocumentDto> getAll(@PathVariable("start") int start, @PathVariable("limit") int limit) {
        return nomenclatorService.getAll(start, limit);
    }
}
