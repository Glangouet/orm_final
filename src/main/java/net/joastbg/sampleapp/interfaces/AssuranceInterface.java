/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.interfaces;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author Guillaume
 */
public interface AssuranceInterface {
        
   public Date getSubscriptionDate();

    public void setSubscriptionDate(Date subscriptionDate);

    public Date getBirthDate();

    public void setBirthDate(Date birthDate);

    public Date getDraftDate();

    public void setDraftDate(Date draftDate);

    public String getTypeAssurance();

    public void setTypeAssurance(String typeAssurance);

    public int getIdAssurance();

    public void setIdAssurance(int idAssurance);
}
