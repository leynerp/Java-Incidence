package init.incidence.person.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class PersonGetDto {
    @NotBlank
    private String searchField;
    private String noIdentity;
    private int idTypeDocument;
}
