package init.incidence.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dat_indicence", schema = "mod_incidence", catalog = "db_incidence")
@Data
public class DatIndicenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idincidence")
    private int idincidence;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "init_date")
    private Timestamp initDate;
    @Basic
    @Column(name = "end_date")
    private Timestamp endDate;
    @Basic
    @Column(name = "idinformationorigen")
    private int idinformationorigen;
    @Basic
    @Column(name = "idincidencetype")
    private int idincidencetype;
    @Basic
    @Column(name = "idclassificationgade")
    private int idclassificationgade;

}
