package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import java.io.Serializable;

@Entity
@Table(name = "PERSONNE_PHYSIQUE")
public class PersonnePhysique extends Client implements Serializable {
    
    @Column
    private String lastname;

    @Column
    private String firstname;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
