package init.incidence.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "dat_entity", schema = "mod_configuration", catalog = "db_incidence")
@Data /*include @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor*/
public class DatEntityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "identity")
    private int identity;
    @Basic
    @Column(name = "denomination")
    private String denomination;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "active")
    private BigInteger active;
    @Basic
    @Column(name = "idparent")
    private Integer idparent;
    @Basic
    @Column(name = "identitytype")
    private int identitytype;

}
