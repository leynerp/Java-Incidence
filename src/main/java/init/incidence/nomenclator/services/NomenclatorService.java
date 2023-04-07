package init.incidence.nomenclator.services;

import init.incidence.models.DatPersonEntity;
import init.incidence.models.NomDocumenttypeEntity;
import init.incidence.nomenclator.dto.NomDocumentDto;
import init.incidence.nomenclator.mapper.NomenclatorMapper;
import init.incidence.nomenclator.repository.NomDocumenttypeEntityRepository;
import init.incidence.person.mapper.MapperPerson;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomenclatorService {
    @Autowired
    private NomDocumenttypeEntityRepository nomDocumentRepository;

    private NomenclatorMapper mapperNomenclator= Mappers.getMapper(NomenclatorMapper.class);
    public List<NomDocumentDto> getAll(int start, int limit) {
        return mapperNomenclator.ListNomDocumentTypeToListNomDocumentDto(nomDocumentRepository.findAll(PageRequest.of(start, limit)).toList()) ;
    }

}
