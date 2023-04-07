package init.incidence.person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PersonPostDto {
    private int idPerson;
    @NotBlank
    private String name;
    @NotBlank
    private String firstLastName;

    private String secondLastName;
    @NotNull
    private List<PersonDocumentTypeDto>  documentIdentity;
}
