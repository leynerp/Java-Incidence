package init.incidence.nomenclator.mapper;

import init.incidence.models.NomDocumenttypeEntity;
import init.incidence.nomenclator.dto.NomDocumentDto;
import init.incidence.person.mapper.MapperPerson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NomenclatorMapper {
    NomenclatorMapper INSTANCE = Mappers.getMapper( NomenclatorMapper.class );
    @Mapping(source = "iddocumenttype", target = "idDocument")
    @Mapping(source = "denomination", target = "denomination")
    NomDocumentDto  NomDocumentTypeToNomDocumentDto(NomDocumenttypeEntity nomDocumenttypeEntity);
    List<NomDocumentDto>  ListNomDocumentTypeToListNomDocumentDto(List<NomDocumenttypeEntity> nomDocumenttypeEntity);
}
