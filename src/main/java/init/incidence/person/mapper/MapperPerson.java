package init.incidence.person.mapper;
import init.incidence.models.DatPersonDocumenttypeEntity;
import init.incidence.models.DatPersonEntity;
import init.incidence.person.dto.PersonDocumentTypeDto;
import init.incidence.person.dto.PersonPostDto;
import org.mapstruct.*;

import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface MapperPerson {
    MapperPerson INSTANCE = Mappers.getMapper( MapperPerson.class );
    @Mapping(source = "name", target = "name")
    @Mapping(source = "FLastname", target = "firstLastName")
    @Mapping(source = "secLastname", target = "secondLastName")
    @Mapping(source = "idperson", target = "idPerson")
    @Mapping(source = "person.datPersonDocument", target = "documentIdentity")
    PersonPostDto personToPersonDTO(DatPersonEntity person);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstLastName", target = "FLastname")
    @Mapping(source = "secondLastName", target = "secLastname")
    @Mapping(source = "idPerson", target = "idperson")
    @Mapping(source = "documentIdentity", target = "datPersonDocument")
    DatPersonEntity personDtoToPersonEntity (PersonPostDto personDto);

    @Mapping(source = "personDocumentType.documentType.denomination", target = "typeIdentity")
    @Mapping(source = "documentCode", target = "noIdentity")
    @Mapping(source = "documentType.iddocumenttype", target = "idDocType")
    @Mapping(source = "principal", target = "main")
    PersonDocumentTypeDto documentTypeToDocumentDto(DatPersonDocumenttypeEntity personDocumentType);
    List<PersonPostDto> personsToPersonDto(List<DatPersonEntity> personEntities);
    List<DatPersonEntity> personsDtoToPerson(List<PersonPostDto> personDto);
    @Mapping(source = "idDocType", target = "documentType.iddocumenttype")
    @Mapping(source = "noIdentity", target = "documentCode")
    @Mapping(source = "main", target = "principal")
    DatPersonDocumenttypeEntity documentDtoToDocumentType(PersonDocumentTypeDto personDocumentDto);

    @Mapping(source = "idDocType", target = "documentType.iddocumenttype")
    @Mapping(source = "noIdentity", target = "documentCode")
    @Mapping(source = "main", target = "principal")
    List<DatPersonDocumenttypeEntity> documenstDtoToDocumentsType( List<PersonDocumentTypeDto> personDocumentDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstLastName", target = "FLastname")
    @Mapping(source = "secondLastName", target = "secLastname")
    @Mapping(source = "idPerson", target = "idperson")
    @Mapping(source = "documentIdentity", target = "datPersonDocument")
    void updatePersonFromPersonDto(PersonPostDto dto, @MappingTarget DatPersonEntity personEntity);

}
