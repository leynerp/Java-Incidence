package init.incidence.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dat_incidence_record", schema = "mod_incidence", catalog = "db_incidence")
@Data
public class DatIncidenceRecordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idincidencerecord")
    private int idincidencerecord;
    @Basic
    @Column(name = "identity")
    private int identity;
    @Basic
    @Column(name = "idincidence")
    private int idincidence;
    @Basic
    @Column(name = "record_date")
    private Timestamp recordDate;
}
