package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECHEANCES")
public class Echeances implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int idEcheance;
        
    @Column
    private double price;

    @Column
    private Date issueDate;

    @Column
    private Date paiementDate;

    @Column
    private Date issueBillDate;

    public int getIdEcheance() {
        return idEcheance;
    }

    public void setIdEcheance(int idEcheance) {
        this.idEcheance = idEcheance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getPaiementDate() {
        return paiementDate;
    }

    public void setPaiementDate(Date paiementDate) {
        this.paiementDate = paiementDate;
    }

    public Date getIssueBillDate() {
        return issueBillDate;
    }

    public void setIssueBillDate(Date issueBillDate) {
        this.issueBillDate = issueBillDate;
    }
     
}
