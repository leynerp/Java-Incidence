package init.incidence.person.services;

import init.incidence.comun.Operation;
import init.incidence.comun.ResponsePagination;
import init.incidence.models.DatPersonEntity;
import init.incidence.person.dao.PersonDaoImpl;
import init.incidence.person.dto.PersonGetDto;
import init.incidence.person.dto.PersonPostDto;
import init.incidence.person.dto.UpdatePersonDocumentDto;
import init.incidence.person.mapper.MapperPerson;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonDaoImpl personDao;

    private MapperPerson mapperPerson= Mappers.getMapper(MapperPerson.class);

    public ResponsePagination<PersonPostDto> findAll(int start, int limit){
        List<PersonPostDto> dataPersons= mapperPerson.personsToPersonDto(personDao.getAll(start,limit));
        int countPersons=(int)personDao.geTotalPersonWithoutCriteria();
        return new ResponsePagination<PersonPostDto>(dataPersons,countPersons);
    }
    public ResponsePagination<PersonPostDto> findByParams(int start, int limit, PersonGetDto baseParams){
        List<PersonPostDto> dataPersons=mapperPerson.personsToPersonDto(personDao.getByParams(start,limit,baseParams));
        int countPersons=personDao.geTotalPerson(baseParams);
        return new ResponsePagination<PersonPostDto>(dataPersons,countPersons);
    }
    public void insertPerson(PersonPostDto newPerson) {
        personDao.saveData(mapperPerson.personDtoToPersonEntity(newPerson), Operation.INS);
    }

    public void deletePerson(int idPerson) {
        personDao.deleteData(idPerson);
    }
    public void updatePerson(PersonPostDto updPersonDto) {
        DatPersonEntity updatePerson=personDao.getById(updPersonDto.getIdPerson());
        mapperPerson.updatePersonFromPersonDto(updPersonDto,updatePerson);
        personDao.saveData(updatePerson,Operation.UPD);
    }
}
