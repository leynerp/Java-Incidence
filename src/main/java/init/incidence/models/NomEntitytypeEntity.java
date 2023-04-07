package init.incidence.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "nom_entitytype", schema = "mod_configuration", catalog = "db_incidence")
@Data
public class NomEntitytypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "identitytype")
    private int identitytype;
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
