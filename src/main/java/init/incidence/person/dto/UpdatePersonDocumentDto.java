package init.incidence.person.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class UpdatePersonDocumentDto {
    @NotNull
    private int idPerson;
    @NotNull
    List<PersonDocumentTypeDto> documents;
}
