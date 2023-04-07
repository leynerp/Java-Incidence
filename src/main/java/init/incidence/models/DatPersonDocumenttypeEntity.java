package init.incidence.models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dat_person_documenttype", schema = "mod_person", catalog = "db_incidence")
@Data
public class DatPersonDocumenttypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_person_documenttype")
    private int idPersonDocumenttype;
    @Basic
    @Column(name = "documentcode")
    private String documentCode;

    @Basic
    @Column(name = "principal")
    private int principal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idperson")
    DatPersonEntity person;

    @ManyToOne
    @JoinColumn(name = "iddocumenttype")
     NomDocumenttypeEntity documentType;


}
