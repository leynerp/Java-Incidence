package init.incidence.person.dao;

import init.incidence.comun.CrudDao;
import init.incidence.models.DatPersonEntity;
import init.incidence.person.dto.PersonGetDto;

public interface PersonDao extends CrudDao<DatPersonEntity, PersonGetDto> {
}
