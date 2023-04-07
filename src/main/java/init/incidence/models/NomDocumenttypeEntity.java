package init.incidence.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "nom_documenttype", schema = "mod_configuration", catalog = "db_incidence")
@Getter
@Setter
public class NomDocumenttypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddocumenttype")
    private int iddocumenttype;
    @Basic
    @Column(name = "denomination")
    private String denomination;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "date_init")
    private Timestamp dateInit;
    @Basic
    @Column(name = "date_end")
    private Timestamp dateEnd;
    @Basic
    @Column(name = "active")
    private BigInteger active;

    @OneToMany(mappedBy = "documentType")
    List<DatPersonDocumenttypeEntity> datPersonDocumentType;

}
