package init.incidence.comun.validation.aspect;

import init.incidence.handlerexception.DuplicateDataException;
import init.incidence.models.DatPersonEntity;
import init.incidence.person.services.PersonDocumentService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;


@Aspect
@Component
public class ValidationAspect {
    @Autowired
    private PersonDocumentService personDocumentService;
    @Pointcut("execution(* init.incidence.person.dao.PersonDaoImpl.saveData(..))")
    private void personSave() { }

    @Before(value = "personSave()")
    public void validateNoIdentity(JoinPoint joinPoint) {
      Object[] arg=joinPoint.getArgs();
      DatPersonEntity person=(DatPersonEntity) arg[0];
        List<String> stringMap=person.getDatPersonDocument().stream().map((x)-> "'"+x.getDocumentType().getIddocumenttype()+":"+x.getDocumentCode()+"'").collect(Collectors.toList());

      /*for (DatPersonDocumenttypeEntity datPersonDocumenttypeEntity : person.getDatPersonDocument()) {
          temp="'"+datPersonDocumenttypeEntity.getDocumentType().getIddocumenttype()+":"+datPersonDocumenttypeEntity.getDocumentCode()+"'";
          stringMap.add(temp);
          temp=null;
      }*/
        int CountExistDocument=personDocumentService.getDocumentByTypeAndCode(stringMap.toString().substring(1).replace("]",""));
        if (CountExistDocument>0) throw new DuplicateDataException("api.response.person.creation.exception.duplicate");

    }
}
