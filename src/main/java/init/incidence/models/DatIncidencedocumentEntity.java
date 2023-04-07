package init.incidence.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dat_incidencedocument", schema = "mod_incidence", catalog = "db_incidence")
@Data
public class DatIncidencedocumentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idincidencedocument")
    private int idincidencedocument;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "registredate")
    private Timestamp registredate;
    @Basic
    @Column(name = "idincidence")
    private int idincidence;
    @Basic
    @Column(name = "principal")
    private int principal;


}
