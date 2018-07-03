package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="ASSURANCE_HABITAT")
public class AssuranceHabitat extends Assurance implements Serializable {
    
    @Column
    private String address;

    @Column
    private int coverValue;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCoverValue() {
        return coverValue;
    }

    public void setCoverValue(int coverValue) {
        this.coverValue = coverValue;
    }
}
