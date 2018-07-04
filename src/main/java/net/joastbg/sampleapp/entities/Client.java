package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="CLIENT")
public abstract class Client implements Serializable  {

    public Client() {
    }
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClient;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "COMPTE_CLIENT", joinColumns = {
    @JoinColumn(name = "idClient", nullable = false, updatable = false) },
            inverseJoinColumns = {
                @JoinColumn(
                    name = "iban",
                    nullable = false, updatable = false) 
            })
    private Set<CompteBancaire> compteBancaireList;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CONTACT_CLIENT", joinColumns = {
    @JoinColumn(name = "idClient", nullable = false, updatable = false) },
            inverseJoinColumns = {
                @JoinColumn(
                    name = "idContact",
                    nullable = false, updatable = false) 
            })
    private Set<Contact> contactList;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public Set<CompteBancaire> getCompteBancaireList() {
        return compteBancaireList;
    }

    public void setCompteBancaireList(Set<CompteBancaire> compteBancaireList) {
        this.compteBancaireList = compteBancaireList;
    }

    public Set<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(Set<Contact> contactList) {
        this.contactList = contactList;
    }    
   
}



