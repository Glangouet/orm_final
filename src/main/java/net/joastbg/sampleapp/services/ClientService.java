/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guillaume
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientDao clientDao;
    
    public List<PersonnePhysique> birthdayFeature() {
        
        List<PersonnePhysique> lc = this.clientDao.findAllPersonnePhysique();
       
        SimpleDateFormat formater = null;
        Date redusDate = new Date();
        formater = new SimpleDateFormat("MM");
        int month = Integer.parseInt(formater.format(redusDate));
        System.out.println(month);
        
        List<PersonnePhysique> lpb = new ArrayList<>();
        
        for (PersonnePhysique person : lc) {
            Date d = person.getBirthDate();
            int comparMonth = Integer.parseInt(formater.format(d));
            System.out.println(comparMonth);
            if ((comparMonth >= month) && comparMonth <= month+3) {
                lpb.add(person);
            }
        }
        
        return lpb;
    }
}
