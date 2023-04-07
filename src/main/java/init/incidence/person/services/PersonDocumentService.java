package init.incidence.person.services;

import init.incidence.models.DatPersonDocumenttypeEntity;
import init.incidence.models.DatPersonEntity;
import init.incidence.person.dao.PersonDaoImpl;
import init.incidence.person.dao.PersonDocumentRepository;
import init.incidence.person.dto.UpdatePersonDocumentDto;
import init.incidence.person.mapper.MapperPerson;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PersonDocumentService {

    @Autowired
    PersonDocumentRepository personDocumentRepository;

    @PersistenceContext
    private EntityManager entityM;
    @Autowired
    PersonDaoImpl personDao;
    private MapperPerson mapperPerson= Mappers.getMapper(MapperPerson.class);

    public void insertPersonDocument(UpdatePersonDocumentDto personDocumentDto) {
        DatPersonEntity person=personDao.getById(personDocumentDto.getIdPerson());
        List<DatPersonDocumenttypeEntity> personDocument=mapperPerson.documenstDtoToDocumentsType(personDocumentDto.getDocuments());
        personDocument.forEach(personDocumentType -> personDocumentType.setPerson(person));
        personDocumentRepository.saveAll(personDocument);
    }

    public  int getDocumentByTypeAndCode(String condicion){
        String querySql="SELECT count(doctype.idperson)  FROM mod_person.dat_person_documenttype doctype WHERE  (doctype.iddocumenttype || ':' || doctype.documentcode) IN ("+condicion+")";
        Query query =entityM.createNativeQuery(querySql);
        int countDocuments =((Number)query.getSingleResult()).intValue();
       return countDocuments;
    }

}
