package init.incidence.person.dao;

import init.incidence.models.DatPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<DatPersonEntity,Integer> {
}
