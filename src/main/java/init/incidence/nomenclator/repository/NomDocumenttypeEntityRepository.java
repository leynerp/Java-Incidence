package init.incidence.nomenclator.repository;

import init.incidence.models.NomDocumenttypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomDocumenttypeEntityRepository extends JpaRepository<NomDocumenttypeEntity, Integer> {
}