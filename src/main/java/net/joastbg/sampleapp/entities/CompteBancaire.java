package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE_BANCAIRE")
public class CompteBancaire implements Serializable {
    
    @Column
    @Id
    private String iban;

    @Column
    private String bic;
    
    @Column
    private String pCode;
    
    @Column
    private boolean mainAccount;

    public CompteBancaire() {
    }
    
    public CompteBancaire(
            String i,
            String b,
            String p, 
            boolean m) {
        iban = i;
        bic = b;
        pCode = p;
        mainAccount = m;
    } 

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }    

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public boolean isMainAccount() {
        return mainAccount;
    }

    public void setMainAccount(boolean mainAccount) {
        this.mainAccount = mainAccount;
    }
    
    
    
}
