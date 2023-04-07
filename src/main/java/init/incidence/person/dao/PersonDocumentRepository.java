package init.incidence.person.dao;

import init.incidence.models.DatPersonDocumenttypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDocumentRepository  extends JpaRepository<DatPersonDocumenttypeEntity,Integer>  {
}
