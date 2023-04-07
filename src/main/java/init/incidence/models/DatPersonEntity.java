package init.incidence.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "dat_person", schema = "mod_person", catalog = "db_incidence")
@Getter
@Setter
@NoArgsConstructor
public class DatPersonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idperson")
    private int idperson;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "f_lastname")
    private String fLastname;
    @Basic
    @Column(name = "sec_lastname")
    private String secLastname;

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<DatPersonDocumenttypeEntity> datPersonDocument;


}
