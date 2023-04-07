package init.incidence.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "nom_classificationgade", schema = "mod_configuration", catalog = "db_incidence")
public class NomClassificationgadeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idclassificationgade")
    private int idclassificationgade;
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

}
