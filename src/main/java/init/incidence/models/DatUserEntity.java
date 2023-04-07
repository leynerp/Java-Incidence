package init.incidence.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dat_user", schema = "mod_person", catalog = "db_incidence")
public class DatUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser")
    private int iduser;
    @Basic
    @Column(name = "idperson")
    private int idperson;
    @Basic
    @Column(name = "user_uuid")
    private String userUuid;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatUserEntity that = (DatUserEntity) o;
        return iduser == that.iduser && idperson == that.idperson && Objects.equals(userUuid, that.userUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, idperson, userUuid);
    }
}
