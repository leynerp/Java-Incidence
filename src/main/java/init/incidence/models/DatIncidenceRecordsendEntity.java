package init.incidence.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dat_incidence_recordsend", schema = "mod_incidence", catalog = "db_incidence")
@Data
public class DatIncidenceRecordsendEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idincidencerecord")
    private int idincidencerecord;
    @Basic
    @Column(name = "idusersend")
    private int idusersend;
    @Basic
    @Column(name = "iduserget")
    private Integer iduserget;
    @Basic
    @Column(name = "accion")
    private BigInteger accion;
    @Basic
    @Column(name = "observation")
    private String observation;
    @Basic
    @Column(name = "received")
    private Timestamp received;

}
