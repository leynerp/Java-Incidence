package init.incidence.person.dao;
import init.incidence.comun.Operation;
import init.incidence.handlerexception.RecourseNotFound;
import init.incidence.models.*;
import init.incidence.person.dto.PersonGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private PersonRepository personDao;
    @PersistenceContext
    private EntityManager entityM;

    @Override
    public void saveData(DatPersonEntity newPerson, Operation op) {
        newPerson.getDatPersonDocument().forEach(personDocumentType -> personDocumentType.setPerson(newPerson));
        personDao.save(newPerson);
    }


    @Override
    public void deleteData(int id) {
            personDao.findById(id).orElseThrow(() -> new RecourseNotFound("api.response.person.creation.exception.notFound"));
            personDao.deleteById(id);
    }

    @Override
    public List<DatPersonEntity> getAll(int start, int limit) {
        return personDao.findAll(PageRequest.of(start, limit)).toList();
    }

    public long geTotalPersonWithoutCriteria(){
        return personDao.count();

    }
    @Override
    public List<DatPersonEntity> getByParams(int start, int limit, PersonGetDto baseParams) {
        CriteriaQuery<DatPersonEntity> criteriaQuery= geCriteriaQueryFindPersonByParams(baseParams);
        return entityM.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public DatPersonEntity getById(int id) {
        return personDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    private CriteriaQuery<DatPersonEntity> geCriteriaQueryFindPersonByParams(PersonGetDto baseParams){
        CriteriaBuilder builder = entityM.getCriteriaBuilder();
        CriteriaQuery<DatPersonEntity> criteria = builder.createQuery( DatPersonEntity.class );
        Root<DatPersonEntity> root = criteria.from( DatPersonEntity.class );
        criteria.select( root ).distinct(true);
        Join<DatPersonEntity,DatPersonDocumenttypeEntity> personJoin = root.join(DatPersonEntity_.DAT_PERSON_DOCUMENT,JoinType.LEFT);
       // Fetch<DatPersonEntity,DatPersonDocumenttypeEntity> personFetch = root.fetch(DatPersonEntity_.DAT_PERSON_DOCUMENT);
        Join<DatPersonDocumenttypeEntity,NomDocumenttypeEntity> typeDocumentJoin = personJoin.join(DatPersonDocumenttypeEntity_.DOCUMENT_TYPE,JoinType.LEFT);
       // Fetch<DatPersonDocumenttypeEntity,NomDocumenttypeEntity> typeDocumentFetch = personFetch.fetch(DatPersonDocumenttypeEntity_.DOCUMENT_TYPE);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.or(builder.like(builder.lower(root.get("name")),"%"+baseParams.getSearchField().toLowerCase()+"%"),
                builder.like(  root.get("fLastname"),"%"+baseParams.getSearchField()+"%"  ),builder.like(  root.get("secLastname"),"%"+baseParams.getSearchField()+"%")));
        if (!baseParams.getNoIdentity().equals("") && baseParams.getNoIdentity()!=null){
            predicates.add(builder.equal(personJoin.get(DatPersonDocumenttypeEntity_.DOCUMENT_CODE ), baseParams.getNoIdentity()));
        }

        if (baseParams.getIdTypeDocument()!=0){
            predicates.add(builder.equal(typeDocumentJoin.get(NomDocumenttypeEntity_.IDDOCUMENTTYPE ), baseParams.getIdTypeDocument()));
        }
        Predicate finalQuery = builder.and(predicates.toArray(new Predicate[0]));
        return criteria.where(finalQuery);
    }
    public int geTotalPerson(PersonGetDto baseParams){
        CriteriaQuery<DatPersonEntity> criteriaQuery= geCriteriaQueryFindPersonByParams(baseParams);
        return entityM.createQuery(criteriaQuery).getResultList().size();

    }


}
