package init.incidence.person.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDocumentTypeDto {

    private String noIdentity;
    private int idPersonDocumenttype;
    private String typeIdentity;
    private String idDocType;
    private int main;
}
