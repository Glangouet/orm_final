package net.joastbg.sampleapp.entities;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="ASSURANCE")
public abstract class Assurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int idAssurance;

    @Column
    private Date subscriptionDate;

    @Column
    private Date birthDate;

    @Column
    private Date draftDate;
    
    @Column
    private String typeAssurance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ASSURANCE_ECHEANCES", joinColumns = {
    @JoinColumn(name = "idAssurance", nullable = false, updatable = false) },
            inverseJoinColumns = {
                @JoinColumn(
                    name = "idEcheance",
                    nullable = false, updatable = false) 
            })
    private Set<Echeances> echeanceList;
    
    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDraftDate() {
        return draftDate;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public String getTypeAssurance() {
        return typeAssurance;
    }

    public void setTypeAssurance(String typeAssurance) {
        this.typeAssurance = typeAssurance;
    }

    public int getIdAssurance() {
        return idAssurance;
    }

    public void setIdAssurance(int idAssurance) {
        this.idAssurance = idAssurance;
    }

    public Set<Echeances> getEcheanceList() {
        return echeanceList;
    }

    public void setEcheanceList(Set<Echeances> echeanceList) {
        this.echeanceList = echeanceList;
    }
    
    
}
