package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ASSURANCE_AUTO")
public class AssuranceAuto extends Assurance implements Serializable {

    @Column
    private String immatriculation;

    @Column
    private double bonnusMalus;

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public double getBonnusMalus() {
        return bonnusMalus;
    }

    public void setBonnusMalus(double bonnusMalus) {
        this.bonnusMalus = bonnusMalus;
    }
}
